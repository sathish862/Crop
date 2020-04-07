package com.example.crop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;

public class listView extends AppCompatActivity {

    String data = retrive.getData();

    String uid;

    String x;
    String y;
    String z;

    TextView a,b,c;

    retrive obj = new retrive();

    DatabaseReference mDatabase;

    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listview = (ListView) findViewById(R.id.listView);

        infoProducts productMember;

        uid=(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid());

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Member").child(uid).child("Income");


        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listview.setAdapter(adapter);

        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String a = Objects.requireNonNull(dataSnapshot.child("eproductName").getValue()).toString();
                String b = Objects.requireNonNull(dataSnapshot.child("edate").getValue()).toString();

                if(b.equals(data)){
                arrayList.add(a);

                adapter.notifyDataSetChanged();}
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
