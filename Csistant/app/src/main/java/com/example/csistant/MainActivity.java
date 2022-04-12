package com.example.csistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    public void gotoLoginPage(View view)
    {
        Intent intent = new Intent(this,login.class);
        startActivity(intent);
    }
    public void gotoSignUpPage(View view)
    {
        Intent intent = new Intent(this,signin.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}