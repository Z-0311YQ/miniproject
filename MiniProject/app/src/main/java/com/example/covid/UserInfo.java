package com.example.covid;

//https://firebase.google.com/docs/auth/android/google-signin

public class UserInfo {
    public int Score;
    public String username;
    public String emailadd;

    //required default constructor
    public UserInfo() {
    }

    public UserInfo(int Score, String username, String emailadd) {
        this.Score = Score;
        this.username = username;
        this.emailadd = emailadd;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return emailadd;
    }

    public void setEmail(String emailadd) {
        this.emailadd = emailadd;
    }
}
