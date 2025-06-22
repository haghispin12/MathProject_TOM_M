package com.tom.mathproject_tom_m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.tom.mathproject_tom_m.mathproj.User;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    private String Username3;
    Button kupa;
    ImageView garbage;

  private  RecyclerView RCard;
  private String DocumentId1;
//private  Intent inn = new Intent(this, MyService.class);
   private ArrayList<Card> cards;//recycleview
  private GAME g1=new GAME(Username3);
  private AdapterCard adapterCard2;

  public boolean  isLooser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initview();

        Intent intent = getIntent();
        Username3= intent.getStringExtra("UserName2");
        DocumentId1=intent.getStringExtra("DocumentId");
        CreatRecicleViwe();


        Intent inn1 = new Intent(this, MyService.class);
        startForegroundService(inn1);


        Card c1=new Card(1,"green",R.drawable.green1);
        onchangeCard(DocumentId1);


    }

    private void initview() {
RCard=findViewById(R.id.RCard);
        kupa=findViewById(R.id.kupa);
        garbage=findViewById(R.id.garbage);
        garbage.setImageResource( g1.getMainCard().getImage());
        cards=new ArrayList<>();
        startGame();
        kupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    cards.add(g1.RandomCard());
                    adapterCard2.updateArr(cards);
                    adapterCard2.notifyDataSetChanged();
                }

        });


    }

    public void CreatRecicleViwe(){
         adapterCard2 = new AdapterCard(cards, new AdapterCard.OnItemClickListener1() {
                    @Override
                    public void onItemClick(Card carditem) {

                            if (carditem.checkcard(g1.getMainCard())) {
                                g1.setMainCard(carditem)  ;
                                garbage.setImageResource(g1.getMainCard().getImage());
                                cards.remove(carditem);
                                adapterCard2.updateArr(cards);
                                adapterCard2.notifyDataSetChanged();
                                updateSingl1(DocumentId1);

                                if(cards.isEmpty()) {
                                    updateWinner(DocumentId1);
                                    CreatDialog("Winner","You Win");
                                }
                            }
                        }

                });
        RCard.setLayoutManager(new GridLayoutManager(this,4));
        RCard.setAdapter(adapterCard2);
        RCard.setHasFixedSize(true);
    }

    public void startGame(){
        for(int i=0;i<8;i++){
            cards.add( g1.RandomCard());
        }
    }

    public boolean thereisCards(){
        if (cards.isEmpty())
            return false;
        return true;
    }


    public void updateSingl1(String documantId){//עדכון  ערכי הקלף בשרת
        FirebaseFirestore.getInstance().collection("games").document(documantId).update("currentnum",g1.getMainCard().getNumber(),"currentcolor",g1.getMainCard().getColor()).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(GameActivity.this, "update student has been success", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(GameActivity.this, "update student has been failed", Toast.LENGTH_SHORT).show();
            }
        });

    }

    boolean isFirst = true;

    public void onchangeCard(String Documentid2) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference userDocRef = db.collection("games").document(Documentid2);
        //Query activeUsersQuery = db.collection("users").whereEqualTo("isActive", true);
        ListenerRegistration userListenerRegistration = userDocRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot, @Nullable FirebaseFirestoreException e) {



                    if (e != null) {
                        Log.w("FirestoreListener", "Listen failed.", e);
                        return;
                    }

                    if (snapshot != null && snapshot.exists()) {
                        Log.d("FirestoreListener", "Current user data: " + snapshot.getData());
                        // Process the document data here (Java)
                        double Currentnum = snapshot.getDouble("currentnum");
                        String Currentcolor = snapshot.getString("currentcolor");


                        if(!isFirst) {
                           g1.setMainCard(g1.onChangeMainCard((int) Currentnum, Currentcolor));
                           garbage.setImageResource(g1.getMainCard().getImage());
                        }else {
                            isFirst=false;
                        }

                        String Winner1 = snapshot.getString("winner");

                        if (Winner1 != null && !Winner1.equals(Username3))
                            CreatDialog("Looser", "You lose");


                    } else {
                        Log.d("FirestoreListener", "Current data: null");
                    }



            }
        });

    }

    public void updateWinner(String documantId){//עדכון  התר
        FirebaseFirestore.getInstance().collection("games").document(documantId).update("winner",Username3).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(GameActivity.this, "update winner has been success", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(GameActivity.this, "update winner has been failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
public void CreatDialog(String title,String mesage){
    AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
    alertDialog.setTitle("title");
    alertDialog.setMessage(mesage);
    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",new DialogInterface.OnClickListener()
    {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

            Intent inn2 = new Intent(GameActivity.this, MyService.class);
          stopService(inn2);
            Intent intent = new Intent(GameActivity.this, MainActivityTaki123.class );
startActivity(intent);
        }

            });

    alertDialog.show();

}
}