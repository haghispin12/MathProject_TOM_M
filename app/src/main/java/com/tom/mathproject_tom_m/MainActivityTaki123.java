package com.tom.mathproject_tom_m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.tom.mathproject_tom_m.mathproj.MainActivity;

public class MainActivityTaki123 extends AppCompatActivity {
    private String Username2;
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
        Intent intent = getIntent();
        Username2 = intent.getStringExtra("UserName2");
        Toast.makeText(MainActivityTaki123.this, Username2, Toast.LENGTH_LONG).show();
        Name.setText(Username2);

     }

    private void initview() {
        creatgame = findViewById(R.id.creatgame);
        Name = findViewById(R.id.Name);

        Score12 = findViewById(R.id.Score12);
        Gameid = findViewById(R.id.Gameid);
        JoinGame = findViewById(R.id.JoinGame);
        iD = findViewById(R.id.iD);
        OkStartGame = findViewById(R.id.OkStartGame);
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
//                FirebaseFirestore.getInstance().collection("game2").whereEqualTo().document().update("Uid2","tom").whereEqualTo("idGame","15b2610a-5a35-4387-914a-41dab894c4e3").getFirestore().document().addSnapshotListener(new EventListener<QuerySnapshot>() {
//                    @Override
//                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                        //value.getD;
//                    }
//                });
            }
        });
        creatgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GAME game1 = new GAME(Username2);
                GameMode(game1);
                Gameid.setText( "Game id is: " + game1.getIdGame());
            }
        });
    }

    public void GameMode(GAME game2) {


        FirebaseFirestore.getInstance().collection("game2").add(game2).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                Log.d("","");
                Gameid.setText(task.getResult().getId());
            }

        });


//                FirebaseFirestore.getInstance().collection("game2").document().set(game2).addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//
//                        Toast.makeText(MainActivityTaki123.this, "add student has been success", Toast.LENGTH_SHORT).show();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(MainActivityTaki123.this, "add student has been failed", Toast.LENGTH_SHORT).show();
//                    }
//                });
    }

}