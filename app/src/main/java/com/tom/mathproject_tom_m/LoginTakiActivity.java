package com.tom.mathproject_tom_m;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tom.mathproject_tom_m.mathproj.LoginActivity;
import com.tom.mathproject_tom_m.mathproj.MainActivity;

public class LoginTakiActivity extends AppCompatActivity {

Button btConnected;
TextView tvNameOfGame;
EditText etEmail;
    private FirebaseAuth auth ;
EditText etPassowrd;
Button btSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_taki2);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        auth= FirebaseAuth.getInstance();

       // int n=10;
        initview();

       if (auth.getCurrentUser()!=null) {
           Intent intent = new Intent(LoginTakiActivity.this, MainActivityTaki123.class);
           intent.putExtra("UserName2", auth.getCurrentUser().getEmail());
           startActivity(intent);
       }
    }

    private void initview() {
        etPassowrd=findViewById(R.id.etPassowrd);
        etEmail=findViewById(R.id.etEmail);
        btSignUp=findViewById(R.id.btSignUp);
        btConnected=findViewById(R.id.btConnected);
        btConnected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signInWithEmailAndPassword(etEmail.getText().toString(),etPassowrd.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginTakiActivity.this, "Authentication success.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginTakiActivity.this, MainActivityTaki123.class);
                            intent.putExtra("UserName2",etEmail.getText().toString());
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(LoginTakiActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        btSignUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onClick(View v) {


                    auth.createUserWithEmailAndPassword(etEmail.getText().toString(),etPassowrd.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                                Toast.makeText(LoginTakiActivity.this,"Registration success",Toast.LENGTH_SHORT).show();
                             else{
                                Toast.makeText(LoginTakiActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


        });
    }

}