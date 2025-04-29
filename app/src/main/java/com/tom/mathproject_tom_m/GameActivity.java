package com.tom.mathproject_tom_m;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity {
    private String Username3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initview();
        Intent intent = getIntent();
        Username3= intent.getStringExtra("UserName2");
    }

    private void initview() {

    }
}