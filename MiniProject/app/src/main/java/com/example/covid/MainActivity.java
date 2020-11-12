package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button Surv,Calendar,CovidInfo,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar = (Button)findViewById(R.id.Calender);
        Calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendar();
            }
        });
        Surv = (Button)findViewById(R.id.Surv);
        Surv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSurvey();
            }
        });
        CovidInfo = (Button)findViewById(R.id.CovidInfo);
        CovidInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openData();
            }
        });

        logout = (Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoBacktoSignin();
                //switch (v.getId()) {
                // ...
                //  case R.id.logout:
                //    signOut();
                //  break;
                // ...
                //}
            }
        });

    }

    public void GoBacktoSignin(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void openCalendar(){
        Intent intent = new Intent(this,Calendar.class);
        startActivity(intent);
    }

    public void openSurvey(){
        Intent intent = new Intent(this,Survey.class);
        startActivity(intent);
    }

    public void openData(){
        Intent intent = new Intent(this,Data.class);
        startActivity(intent);
    }
}