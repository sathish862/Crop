package com.example.crop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cropcalender extends AppCompatActivity {

    Button jan,feb,march,april,may,june,july,aug,sep,oct,nov,dec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cropcalender);
        TextView textView = (TextView)findViewById(R.id.link);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        jan = (Button)findViewById(R.id.jan);
        feb = (Button)findViewById(R.id.feb);
        march = (Button)findViewById(R.id.mar);
        april = (Button)findViewById(R.id.april);
        may = (Button)findViewById(R.id.may);
        june = (Button)findViewById(R.id.june);
        july = (Button)findViewById(R.id.july);
        aug = (Button)findViewById(R.id.aug);
        sep = (Button)findViewById(R.id.sep);
        oct = (Button)findViewById(R.id.oct);
        nov = (Button)findViewById(R.id.nov);
        dec = (Button)findViewById(R.id.dec);

        jan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cropcalender.this,january.class);
                startActivity(intent);
            }
        });

        feb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cropcalender.this,february.class);
                startActivity(intent);
            }
        });

        march.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cropcalender.this,march.class);
                startActivity(intent);
            }
        });

        april.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cropcalender.this,april.class);
                startActivity(intent);
            }
        });

        may.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cropcalender.this,may.class);
                startActivity(intent);
            }
        });

        june.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cropcalender.this,june.class);
                startActivity(intent);
            }
        });

        july.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cropcalender.this,july.class);
                startActivity(intent);
            }
        });

        aug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cropcalender.this,august.class);
                startActivity(intent);
            }
        });

        sep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cropcalender.this,september.class);
                startActivity(intent);
            }
        });

        oct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cropcalender.this,october.class);
                startActivity(intent);
            }
        });

        nov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cropcalender.this,november.class);
                startActivity(intent);
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cropcalender.this,december.class);
                startActivity(intent);
            }
        });

    }
}
