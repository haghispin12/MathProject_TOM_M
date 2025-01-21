package com.tom.mathproject_tom_m;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    }
}