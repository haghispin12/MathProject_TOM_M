package com.tom.mathproject_tom_m;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginTakiActivity extends AppCompatActivity {
Button btlogin;
Button btConnected;
TextView tvNameOfGame;
EditText etEmail;
EditText etPassowrd;
Button btSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_taki2);
    }
}