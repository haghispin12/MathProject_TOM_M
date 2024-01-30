package com.tom.mathproject_tom_m;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button etgar;
    private Button ad20;
    private Button loach;
    private TextView firstrandom;
    private TextView secondrandom;
    private EditText enteranswer;
    private Button check;
    private Button save;
    private Button allpar;
    private  Exersise e1 =new Exersise();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    public  void initview() {
        etgar = findViewById(R.id.etgar);
        ad20 = findViewById(R.id.ad20);
        loach = findViewById(R.id.loach);
        firstrandom = findViewById(R.id.firstrandom);
        secondrandom = findViewById(R.id.secondrandom);
        enteranswer = findViewById(R.id.enteranswer);
        save = findViewById(R.id.save);
        allpar = findViewById(R.id.allpar);
        check=findViewById(R.id.check);

        etgar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.generateetgernumbers();
                updateview();
            }

        });
        ad20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.generatead20numbers();
                updateview();
            }
        });
        loach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.generateloachnumbers();
                updateview();
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (e1.check(enteranswer.getText().toString()))
                   Toast.makeText(MainActivity.this ,"Sucssesfull",Toast.LENGTH_LONG).show();
               else
                   Toast.makeText(MainActivity.this ,"eror",Toast.LENGTH_LONG).show();

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        allpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void updateview(){
        firstrandom.setText(e1.getNum1()+" ");
        secondrandom.setText(e1.getNum2()+" ");
    }



    }
