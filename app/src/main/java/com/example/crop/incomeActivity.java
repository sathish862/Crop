package com.example.crop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Objects;


public class incomeActivity extends AppCompatActivity {

    EditText amount,weight;
    Button add;
    Spinner products;
    long maxid=0;

    String uid,date;

    DatabaseReference reff;
    eProducts productMember;

    String s,a;

    private static final String TAG = "date";
    private  TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    RegistrationActivity mail = new RegistrationActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        Toast.makeText(this,"FireBase Connection Successful",Toast.LENGTH_SHORT).show();
        //adding date

        mDisplayDate = (TextView)findViewById(R.id.date);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(incomeActivity.this,
                        android.R.style.Theme_Material_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                Log.d(TAG, "onDateSet: dd/mm/yyyy: " + dayOfMonth + "/" + month + "/" + year);

                date = dayOfMonth + "/" + month + "/" + year;

                mDisplayDate.setText(date);
                a=date;
            }
        };

        //adding back button in screen
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //database
        amount = (EditText)findViewById(R.id.etAmount);
        add = (Button)findViewById(R.id.btnAddData);
        products = (Spinner)findViewById(R.id.spinner1);
        weight = (EditText)findViewById(R.id.etWeight);
        productMember = new eProducts();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float price = Float.parseFloat(amount.getText().toString().trim());
                String item = products.getSelectedItem().toString();
                float w = Float.parseFloat(weight.getText().toString().trim());

                productMember.setEprice(price);
                productMember.setEproductName(item);
                productMember.setEdate(date);
                productMember.setEkg(w);

                uid=(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid());

                reff.child(uid).child("Income").child(String.valueOf(maxid)).setValue(productMember);
                maxid=maxid+1;
                Toast.makeText(incomeActivity.this,"Data Inserted Successfully",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
