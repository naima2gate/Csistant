package com.example.csistant;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class homescreen extends AppCompatActivity {

    public void gotoHomescreen(View view){
        Intent intent = new Intent(this,homescreen.class);
        startActivity(intent);
    }
    /*public void gotoProfile(View view){
        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);
    }
    public void gotoSettings(View view){
        Intent intent = new Intent(this,Settings.class);
        startActivity(intent);
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
    }
}