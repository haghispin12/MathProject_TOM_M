package com.tom.mathproject_tom_m;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tom.mathproject_tom_m.mathproj.MainActivity;

public class MainActivityTaki123 extends AppCompatActivity {
Button creatgame;
TextView Name;
    TextView Score12;
    TextView Gameid;
    Button JoinGame;
    EditText iD;
    Button OkStartGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_taki123);
        initview();
        Intent intent=getIntent();
        String Username2=intent.getStringExtra("UserName2");
        Toast.makeText(MainActivityTaki123.this ,Username2,Toast.LENGTH_LONG).show();
    }

    private void initview() {
        creatgame= findViewById(R.id.creatgame);
        Name= findViewById(R.id.Name);
        Score12= findViewById(R.id.Score12);
        Gameid= findViewById(R.id.Gameid);
        JoinGame= findViewById(R.id.JoinGame);
        iD= findViewById(R.id.iD);
        OkStartGame= findViewById(R.id.OkStartGame);
        JoinGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iD.setVisibility(View.VISIBLE);
                OkStartGame.setVisibility(View.VISIBLE);
            }
        });
        OkStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}