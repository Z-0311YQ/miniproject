package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class Data extends AppCompatActivity {

    private static final String url = "https://api.covid19api.com/summary";
    private TextView textView;
    private String info = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        this.getSupportActionBar().hide();
        RequestQueue queue = Volley.newRequestQueue(this);
        textView = findViewById(R.id.text);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObj = new JSONObject(response);
                    JSONArray countries = jsonObj.getJSONArray("Countries");
                    for(int i = 0;i<countries.length();i++){
                        JSONObject country = countries.getJSONObject(i);
                        info = info + "Country: " + country.getString("Country") +
                                    "\nNew Confirmed: " + country.getString("NewConfirmed") +
                                    "\nTotal Confirmed: " + country.getString("TotalConfirmed") +
                                    "\nNew Deaths: " + country.getString("NewDeaths") +
                                    "\nTotal Deaths: " + country.getString("TotalDeaths") +
                                    "\nNew Recovered: " + country.getString("NewRecovered") +
                                    "\nTotal Recovered: " + country.getString("TotalRecovered") +
                                    "\n___________________________\n";
                    }
                    textView.setText(info);
                }
                catch (Exception e){
                    textView.setText("Error!");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That Didn't Work!");
            }
        });

        queue.add(stringRequest);
    }
}