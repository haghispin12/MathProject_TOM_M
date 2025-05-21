package com.tom.mathproject_tom_m;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tom.mathproject_tom_m.mathproj.User;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    private String Username3;
    Button kupa;
    ImageView garbage;
   private Card MainCard;
  private  RecyclerView RCard;
  private String DocumentId1;

   private ArrayList<Card> cards;//recycleview
   Card [] arrCards;//מערך של כל הקלפים שיש
  private AdapterCard adapterCard2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initview();
        CreatRecicleViwe();
        Intent intent = getIntent();
        Username3= intent.getStringExtra("UserName2");
        DocumentId1=intent.getStringExtra("DocumentId");
        Card c1=new Card(1,"green",R.drawable.green1);


    }

    private void initview() {
RCard=findViewById(R.id.RCard);
        kupa=findViewById(R.id.kupa);
        garbage=findViewById(R.id.garbage);
        arrCards =new Card[12];
        creatArrCards();
        MainCard=RandomCard();
        garbage.setImageResource( MainCard.getImage());
        cards=new ArrayList<>();
        startGame();
        kupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cards.add(RandomCard());
                adapterCard2.updateArr(cards);
                adapterCard2.notifyDataSetChanged();
            }
        });

    }
    public void creatcards(){
        cards.add(new Card(1,"blue",R.drawable.blue1));
        cards.add(new Card(1,"green",R.drawable.green1));
        cards.add(new Card(3,"blue",R.drawable.blue3));


    }
    public void CreatRecicleViwe(){
         adapterCard2 = new AdapterCard(cards, new AdapterCard.OnItemClickListener1() {
                    @Override
                    public void onItemClick(Card carditem) {
                      if(checkCard(carditem,MainCard)) {
                          MainCard = carditem;
                          garbage.setImageResource(MainCard.getImage());
                          cards.remove(carditem);
                          adapterCard2.updateArr(cards);
                          adapterCard2.notifyDataSetChanged();
                          updateSingl1(DocumentId1);
                      }
                    }
                });
        RCard.setLayoutManager(new GridLayoutManager(this,4));
        RCard.setAdapter(adapterCard2);
        RCard.setHasFixedSize(true);
    }
    public Card RandomCard(){
        int num= (int) (Math.random()*12);
        Card c2=arrCards[num];
        return c2;
    }
    public void startGame(){
        for(int i=0;i<8;i++){
            cards.add( RandomCard());
        }
    }
    public boolean checkCard(Card c1,Card c2){
      if(c1.getColor().equals(c2.getColor())|| c1.getNumber()==c2.getNumber())
          return true;
      return false;
    }
    public boolean thereisCards(){
        if (cards.isEmpty())
            return false;
        return true;
    }

public void creatArrCards(){
    Card c0 =new Card(1,"red",R.drawable.red1);
    Card c1 =new Card(1,"green",R.drawable.green1);
    Card c2=new Card(1,"blue",R.drawable.blue1);
    Card c3 =new Card(1,"yellow",R.drawable.yellow1);
    Card c4 =new Card(3,"red",R.drawable.red3);
    Card c5 =new Card(3,"blue",R.drawable.blue3);
    Card c6 =new Card(3,"green",R.drawable.green3);
    Card c7 =new Card(3,"yellow",R.drawable.yellow3);
    Card c8 =new Card(4,"red",R.drawable.red4);
    Card c9 =new Card(4,"blue",R.drawable.blue4);
    Card c10 =new Card(4,"yellow",R.drawable.yellow4);
    Card c11 =new Card(4,"green",R.drawable.green4);
    arrCards[0]=c0;
    arrCards[1]=c1;
    arrCards[2]=c2;
    arrCards[3]=c3;
    arrCards[4]=c4;
    arrCards[5]=c5;
    arrCards[6]=c6;
    arrCards[7]=c7;
    arrCards[8]=c8;
    arrCards[9]=c9;
    arrCards[10]=c10;
    arrCards[11]=c11;
}
    public void updateSingl1(String documantId){//עדכון  ערכי הקלף בשרת
        FirebaseFirestore.getInstance().collection("games").document(documantId).update("currentnum",MainCard.getNumber(),"currentcolor",MainCard.getColor()).addOnSuccessListener(new OnSuccessListener<Void>() {
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
    public Card onChangeMainCard(int num,String color){
        Card c=new Card();
        for(int i=0;i<arrCards.length;i++){
            if(arrCards[i].getNumber()==num && arrCards[i].getColor().equals(color))
                c=arrCards[i];
        }
        return c;
    }
}