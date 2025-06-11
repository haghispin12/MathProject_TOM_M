package com.tom.mathproject_tom_m.mathproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tom.mathproject_tom_m.R;

public class LoginActivity extends AppCompatActivity {
private Button Start;
private EditText UserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        Initviwe();
//        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//        String s1 = sh.getString("name", "");
//        UserName.setText(s1);

    }
    public void Initviwe(){
//        Start = findViewById(R.id.start);
//        UserName=findViewById(R.id.UserName);
//        Start.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                intent.putExtra("UserName1",UserName.getText().toString());
//                startActivity(intent);
//                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
//                SharedPreferences.Editor myEdit = sharedPreferences.edit();
//                myEdit.putString("name", UserName.getText().toString());
//                myEdit.apply();
//            }
//
//        });
    }
}