package com.tom.mathproject_tom_m;

import java.util.ArrayList;
import java.util.UUID;

public class GAME {
  private ArrayList<Card> arrCards;

    public int getStatusgame() {
        return statusgame;
    }

    public void setStatusgame(int statusgame) {
        this.statusgame = statusgame;
    }

    public String getTurn() {
        return Turn;
    }

    public void setTurn(String turn) {
        Turn = turn;
    }

    public String getWinner() {
        return Winner;
    }

    public void setWinner(String winner) {
        Winner = winner;
    }

    public Card getMainCard() {
        return MainCard;
    }

    public void setMainCard(Card mainCard) {
        MainCard = mainCard;
    }

    public ArrayList<Card> getArrCards() {
        return arrCards;
    }



    private Card MainCard;
    public String getIdGame() {
        return IdGame;
    }

    public void setIdGame(String idGame) {
        IdGame = idGame;
    }

    String IdGame;

    public String getUid1() {
        return Uid1;
    }

    public void setUid1(String uid1) {
        Uid1 = uid1;
    }

    public String getUid2() {
        return Uid2;
    }

    public void setUid2(String uid2) {
        Uid2 = uid2;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    String Uid1;
    String Uid2;
    int Status;
    String Winner;
    String Turn;
    private int statusgame;

    public int getCurrentnum() {
        return currentnum;
    }

    public void setCurrentnum(int currentnum) {
        this.currentnum = currentnum;
    }

    public String getCurrenrcolor() {
        return currenrcolor;
    }

    public void setCurrenrcolor(String currenrcolor) {
        this.currenrcolor = currenrcolor;
    }




    int currentnum;
    String currenrcolor;
    public GAME(String IdGame,String uid2 ){
        this.IdGame=IdGame;
        this.Uid2=Uid2;
        this.Status=1;
        this.currenrcolor=null;
        this.currentnum=0;
        this.statusgame=0;
        this.Winner=null;
        this.Turn=uid2;
    }

    public GAME(String Uid1){
        this.IdGame= UUID.randomUUID().toString();
        this.Uid1=Uid1;
        this.Status=0;
        this.currenrcolor=null;
        this.currentnum=0;
        this.statusgame=0;
        this.Winner=null;
        this.Turn=Uid1;
        this.arrCards=new ArrayList<>();
        creatArrCards();
        Card c0 =new Card(1,"red",R.drawable.red1);
        this.MainCard=c0;
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
        arrCards.add(0, c0);
        arrCards.add(1, c1);
        arrCards.add(2, c2 );
        arrCards.add(3, c3);
        arrCards.add(4, c4);
        arrCards.add(5, c5);
        arrCards.add(6, c6);
        arrCards.add(7, c7);
        arrCards.add(8, c8);
        arrCards.add(9, c9);
        arrCards.add(10, c10);
        arrCards.add(11, c11);
    }
    public Card RandomCard(){//$
        int num= (int) (Math.random()*12);
        Card c2=arrCards.get(num);
        return c2;
    }
    public Card onChangeMainCard(int num,String color){//$
        Card c=new Card();
        for(int i=0;i<arrCards.size();i++){
            if(arrCards.get(i).getNumber()==num && arrCards.get(i).getColor().equals(color))
                c=arrCards.get(i);
        }
        return c;
    }
}
