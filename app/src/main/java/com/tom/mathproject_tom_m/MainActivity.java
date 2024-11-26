package com.tom.mathproject_tom_m;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.app.Instrumentation;
import android.content.Intent;
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
    private Button Rate;
    private  Exersise e1 =new Exersise();
    private Vm viewModelMain;
    int scorepoints;
ActivityResultLauncher<Intent> ActivityResultluncherLauncher = registerForActivityResult
        (new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
    @Override
    public void onActivityResult(ActivityResult result) {
        int myrate=result.getData().getIntExtra("Rate123", -1);
        viewModelMain.setUserRate(myrate);
        Toast.makeText(MainActivity.this, myrate + " ", Toast.LENGTH_SHORT).show();

    }
});

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        Intent intent=getIntent();
        String Username1=intent.getStringExtra("UserName1");
        Toast.makeText(MainActivity.this ,Username1,Toast.LENGTH_LONG).show();
        viewModelMain=new ViewModelProvider(this).get(Vm.class);
        viewModelMain.setUserName(Username1);


        viewModelMain.Vnum1.observe(this, new Observer<Integer>() {

            @Override

            public void onChanged(Integer num1) {
                firstrandom.setText(num1+" ");
            }

        });
        viewModelMain.Vnum2.observe(this, new Observer<Integer>() {

            @Override

            public void onChanged(Integer num1) {
                secondrandom.setText(num1+" ");
            }

        });
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
            Rate=findViewById(R.id.Rate);

        Rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, RateActivity.class);
              ActivityResultluncherLauncher.launch(intent);

            }

        });


        etgar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelMain.vChalenge();
                scorepoints=20;

            }

        });
        ad20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelMain.Ad20();
                scorepoints=15;
            }
        });
        loach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelMain.loach();
                scorepoints=10;
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (viewModelMain.check(enteranswer.getText().toString())) {
                   Toast.makeText(MainActivity.this, "Sucssesfull", Toast.LENGTH_LONG).show();
                   viewModelMain.updateUserScore(scorepoints);
               }
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
                Intent intent = new Intent(MainActivity.this,ShowallUsersActivity.class);
                startActivity(intent);
               // FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
              // trans.add(R.id.FragmentShowAllusers, new ShowUsersFragment());
              //  trans.commit();
            }
        });

    }





    }
