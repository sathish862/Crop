package com.example.crop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private CardView investmentCardView, incomeCardView, weightCardView, profitlossCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        firebaseAuth = FirebaseAuth.getInstance();

        investmentCardView = findViewById(R.id.invetmentCardView);
        incomeCardView = findViewById(R.id.incomeCardView);
        weightCardView = findViewById(R.id.weightCardView);
        profitlossCardView = findViewById(R.id.profitlossCardView);

        investmentCardView.setOnClickListener(this);
        incomeCardView.setOnClickListener(this);
        weightCardView.setOnClickListener(this);
        profitlossCardView.setOnClickListener(this);
    }

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(SecondActivity.this,MainActivity.class));
    }

    private void Cropcalendar(){

        startActivity(new Intent(SecondActivity.this,Cropcalender.class));
    }

    private void Instruction(){

        startActivity(new Intent(SecondActivity.this,Instruction.class));
    }

    private void Retrive(){

        startActivity(new Intent(SecondActivity.this,retrive.class));
    }

    private void Sample(){

        startActivity(new Intent(SecondActivity.this,listView.class));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.logoutMenu) {
            Logout();
            Toast.makeText(SecondActivity.this, "Signed Out", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.ccMenu){
            Cropcalendar();
        }
        if (item.getItemId() == R.id.instructionMenu){
            Instruction();
        }
        if (item.getItemId() == R.id.retriveMenu){
            Retrive();
        }
        if (item.getItemId() == R.id.sample){
            Sample();
        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()){
            case R.id.invetmentCardView:{
                intent = new Intent(this,InvestmentActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.incomeCardView:{
                intent = new Intent(this,incomeActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.weightCardView:{
                intent = new Intent(this,weightActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.profitlossCardView:{
                intent = new Intent(this,profitLossActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
