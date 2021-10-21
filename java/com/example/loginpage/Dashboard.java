package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Dashboard extends AppCompatActivity {

    TextView textView;
    Button btnlogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        textView=findViewById(R.id.textView);
        btnlogout=findViewById(R.id.button);

       final SharedPreferences sharedPreferences=getSharedPreferences("User_Session",MODE_PRIVATE);
       textView.setText("You are logged in " +sharedPreferences.getString("user",""));
       btnlogout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               sharedPreferences.edit().clear().commit();
               startActivity(new Intent(Dashboard.this,MainActivity.class));
               finish();
           }
       });
    }


}