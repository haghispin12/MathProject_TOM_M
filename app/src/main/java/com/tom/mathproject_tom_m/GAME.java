package com.tom.mathproject_tom_m;

import java.util.UUID;

public class GAME {

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
    }

}
