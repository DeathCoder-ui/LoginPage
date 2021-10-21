package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

     EditText user,psw;
     Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=findViewById(R.id.edtUser);
        psw=findViewById(R.id.edtpsw);
        btnlogin=findViewById(R.id.bttnlogin);

        final SharedPreferences session=getSharedPreferences("User_Session",MODE_PRIVATE);
        if (session.getBoolean("session",false)&& !session.getString("user","").isEmpty()){
            startActivity(new Intent(MainActivity.this,Dashboard.class));
            finish();
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.edit().putString("user",user.getText().toString()).commit();
                session.edit().putBoolean("session",true).commit();
                startActivity(new Intent(MainActivity.this,Dashboard.class));
                finish();
            }
        });
    }
}