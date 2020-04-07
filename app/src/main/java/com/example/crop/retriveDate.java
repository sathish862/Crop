package com.example.crop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class retriveDate extends AppCompatActivity {

    private TextView iname,iprice,ikg;

    String uid,x;

    DatabaseReference ref;

    eProducts a;

    retrive obj;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive_date);


        a = new eProducts();
        //listView = (ListView)findViewById(R.id.listView);

        iname = (TextView)findViewById(R.id.iname);
        iprice = (TextView)findViewById(R.id.iprice);
        ikg = (TextView)findViewById(R.id.ikg);

        uid=(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid());

        ref = FirebaseDatabase.getInstance().getReference().child("Member").child(uid).child("Income").child("20").child("3")
                .child("2020").child("0");
       /* list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.activity_incomeinfo, R.id.incomeinfo,list);*/

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String a = dataSnapshot.child("eproductName").getValue().toString();
                String b = dataSnapshot.child("eprice").getValue().toString();
                String c = dataSnapshot.child("ekg").getValue().toString();

                iname.setText(a);
                iprice.setText(b);
                ikg.setText(c);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
