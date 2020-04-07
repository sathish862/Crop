package com.example.crop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Instruction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        TextView cultivation = (TextView)findViewById(R.id.cultivation);
        cultivation.setMovementMethod(LinkMovementMethod.getInstance());

        TextView fertilizer = (TextView)findViewById(R.id.fertilixerclick);
        fertilizer.setMovementMethod(LinkMovementMethod.getInstance());

        TextView mixedCrop = (TextView)findViewById(R.id.mixedcrop);
        mixedCrop.setMovementMethod(LinkMovementMethod.getInstance());

        TextView pest = (TextView)findViewById(R.id.pest);
        pest.setMovementMethod(LinkMovementMethod.getInstance());

        TextView disease = (TextView)findViewById(R.id.diseaseclick);
        disease.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
