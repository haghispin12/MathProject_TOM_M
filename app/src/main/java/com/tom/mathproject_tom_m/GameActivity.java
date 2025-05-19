package com.tom.mathproject_tom_m;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.tom.mathproject_tom_m.mathproj.User;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    private String Username3;
    Button kupa;
    ImageView garbage;
  private  RecyclerView RCard;

   private ArrayList<Card> cards;//recycleview
   Card [] arrCards;//מערך של כל הקלפים שיש
  private AdapterCard adapterCard2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        cards=new ArrayList<>();
        arrCards =new Card[12];
        initview();
        creatcards();
        CreatRecicleViwe();
        Intent intent = getIntent();
        Username3= intent.getStringExtra("UserName2");
        Card c1=new Card(1,"green",R.drawable.green1);

    }

    private void initview() {
RCard=findViewById(R.id.RCard);
        creatArrCards();
        startGame();
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

                    }
                });
        RCard.setLayoutManager(new LinearLayoutManager(this));
        RCard.setAdapter(adapterCard2);
        RCard.setHasFixedSize(true);
    }
    public Card RandomCard(){
        int num= (int) (Math.random()*12);
        Card c1=arrCards[num];
        return c1;
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
}