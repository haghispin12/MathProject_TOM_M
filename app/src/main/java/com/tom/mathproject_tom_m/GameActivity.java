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

   private ArrayList<Card> cards;
   Card [] arrCards;
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
        int num= (int) (Math.random()*12+1);
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


}