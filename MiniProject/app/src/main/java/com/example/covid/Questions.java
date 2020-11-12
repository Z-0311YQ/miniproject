package com.example.covid;

public class Questions {
    public String symptom [] ={
            "Fever of 100F, or feeling usually hot accomplained by shivering/chills",
            "New cough not related to chronic condition",
            "Sore throat",
            "New loss of taste or smell",
            "Vomiting",
            "Severe fatigue",
            "Severe muscle aches",
            "o"
    };
/*
    private String answers[][] = {
            {"Yes","No"},
            {"Yes","No"},
            {"Yes","No"},
            {"Yes","No"},
            {"Yes","No"},
            {"Yes","No"},
            {"Yes","No"},
            {"Yes","No"}
    };

    private String correctAnswer [] = {
      "No", "No","No","No","No","No","No","No"
    };*/

    public String getQuestion(int a){
        String q = symptom[a];
        return q;
    }
/*
    public String getAnswer1(int b){
        String i = answers[b][0];
        return i;
    }

    public String getAnswer2(int c){
        String i = answers[c][1];
        return i;
    }

    public String correctAns(int d){
        String i = correctAnswer[d];
        return i;
    }*/
}
