package com.tom.mathproject_tom_m;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class LoginTakiActivity extends AppCompatActivity {

Button btConnected;
TextView tvNameOfGame;
EditText etEmail;
EditText etPassowrd;
Button btSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_taki2);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        int n=10;
        initview();
    }

    private void initview() {
        btSignUp=findViewById(R.id.btSignUp);
        btConnected=findViewById(R.id.btConnected);
        btConnected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}