package com.tom.mathproject_tom_m;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class Vm extends ViewModel {
    MutableLiveData<Integer> Vnum1;
    MutableLiveData<Integer>Vnum2;
    Exersise exersise;
    User user;
    MutableLiveData<ArrayList<User>> Myusers;
public Vm(){
    Vnum1=new MutableLiveData<>();
    Vnum2=new MutableLiveData<>();
    exersise=new Exersise();
    user=new User();
   Myusers= new MutableLiveData<>(new ArrayList<User>()) ;
}
public  void getMyusers(Context context){
    DBHelper dbHelper=new DBHelper(context);
    Myusers.setValue(dbHelper.selectAll());
}
public long dbAdduser(Context context){
    DBHelper dbHelper=new DBHelper(context);
    long id=dbHelper.insert(user,context);
    Log.d("Iduser",id+" ");
    //if(id!=-1)
    //dbgetusers(context);
    return id;
}
    public void dbUpdateuser(User user2 ,Context context){
        DBHelper dbHelper=new DBHelper(context);
        dbHelper.update(user2);
    }
public void vChalenge(){
    exersise.generateetgernumbers();
    Vnum1.setValue(exersise.getNum1());
    Vnum2.setValue(exersise.getNum2());
}
public void Ad20(){
    exersise.generatead20numbers();
    Vnum1.setValue(exersise.getNum1());
    Vnum2.setValue(exersise.getNum2());

}
public void loach(){
    exersise.generateloachnumbers();
    Vnum1.setValue(exersise.getNum1());
    Vnum2.setValue(exersise.getNum2());
}
public Boolean check(String str1){
    return exersise.check(str1);
}

    public MutableLiveData<Integer> getVnum1() {
        return Vnum1;
    }

    public MutableLiveData<Integer> getVnum2() {
        return Vnum2;
    }

    public void setVnum1(MutableLiveData<Integer> vnum1) {
        Vnum1 = vnum1;
    }

    public void setVnum2(MutableLiveData<Integer> vnum2) {
        Vnum2 = vnum2;
    }
    public void setUserName(String Username1){
    user.setName(Username1);
    }
    public void setUserRate(int Rate1){
    user.setRate(Rate1);
    }
    public int getUserRate(){
    return user.getRate();
    }
    public String getUsername(){
    return user.getName();
    }
    public String getUserScore(){
    String S10=  "" +user.getScore();
    return S10;
    }
    public void updateUserScore(int ScorePoints){
    user.updateScore(ScorePoints);
    }

}
