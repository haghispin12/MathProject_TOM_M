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
    private int num1;
    private int num2;
    private int num3;
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
                generateetgernumbers();
                updateview();
            }

        });
        ad20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatead20numbers();
                updateview();
            }
        });
        loach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateloachnumbers();
                updateview();
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (check())
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
public  void generateloachnumbers(){//לוח הכפל
    Random r=new Random();
    this.num1=r.nextInt(10);
    this.num2=r.nextInt(10);
}
    public   void generatead20numbers(){//ad20
        Random r=new Random();
        this.num1=r.nextInt(10);
        this.num2=r.nextInt(10)+10;
    }
    public   void generateetgernumbers(){//etger
        Random r=new Random();
        this.num1=r.nextInt(10);
        this.num2=r.nextInt(90)+10;
    }
    public void updateview(){
        firstrandom.setText(num1+" ");
        secondrandom.setText(num2+" ");
    }

    public boolean check(){
        num3=num1*num2;
        String res=num3+"";
        if (enteranswer.getText().toString().equals(res))
            return true;
        else
            return false;


    }
}