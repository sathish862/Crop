package com.example.crop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class retrive extends AppCompatActivity {

    static String data;

    String a;

    String day1,month1,year1;

    EditText day,month,year;

    String z,fidate,date;
    String x;
    String y;

    infoProducts productMember;

    private static final String TAG = "date";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    Button setok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive);

        mDisplayDate = (TextView) findViewById(R.id.retrivedate);

        setok = (Button) findViewById(R.id.BTsetOk);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int a = cal.get(Calendar.YEAR);
                int b = cal.get(Calendar.MONTH);
                int c = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(retrive.this,
                        android.R.style.Theme_Material_Light_Dialog_MinWidth,
                        mDateSetListener,
                        a, b, c);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                Log.d(TAG, "onDateSet: dd/mm/yyyy: " + dayOfMonth + "/" + month + "/" + year);

                date = dayOfMonth + "/" + month + "/" + year;
                mDisplayDate.setText(date);
                a=date;
                data = date;
                day1=String.valueOf(dayOfMonth);
                month1 = String.valueOf(month);
                year1 = String.valueOf(year);

            }
        };

        setok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(retrive.this, listView.class);
                startActivity(intent);
            }
        });
    }
    public static String getData(){
        return data;
    }
}