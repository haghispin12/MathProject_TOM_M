package com.tom.mathproject_tom_m;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
private Button Start;
private EditText UserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Initviwe();



    }
    public void Initviwe(){
        Start = findViewById(R.id.start);
        UserName=findViewById(R.id.UserName);
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                intent.putExtra("UserName1",UserName.getText().toString());
                startActivity(intent);


            }

        });
    }
}