package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.Random;

public class Survey extends AppCompatActivity {
    Button nobutton, yesbutton, ret;
    TextView question;

    private Questions symptom = new Questions();
    //private String suvAnswer;
   // private int QLength = symptom.symptom.length;
    private int counter = 1;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        nobutton = (Button)findViewById(R.id.nobutton);
        yesbutton = (Button)findViewById(R.id.yesbutton);
        ret = (Button)findViewById(R.id.ret);
        question  = (TextView)findViewById(R.id.question);

        nobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter < 8){
                    updateQuestion();
                }
                else{
                    goback();
                }
            }
        });

        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goback();
            }
        });

        yesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter <8){
                    score ++;
                    updateQuestion();
                }
                else{
                    goback();
                }
            }
        });
    }

    public void updateQuestion(){
        question.setText(symptom.getQuestion(counter));
        //yesbutton.setText(symptom.getAnswer1(counter));
        //nobutton.setText(symptom.getAnswer2(counter));

        //suvAnswer = symptom.correctAns(counter);
        counter++;

        if(counter == 8){
            question.setText("You have " + String.valueOf(score) + " symptom");
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
            if(acct != null){
                String personEmail = acct.getEmail();
                storeInfo(personEmail,score);
            }
        }
    }

    public void goback(){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
    }

    private void storeInfo(String user,int score){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Info");
        myRef.setValue("User: " + user +" ---> Score: " + score);
    }
}