package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Calendar extends AppCompatActivity {
    private Button goback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        goback = (Button)findViewById(R.id.goback);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReturntoMain();
            }
        });
    }

    public void ReturntoMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}