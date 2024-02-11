package com.tom.mathproject_tom_m;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Vm extends ViewModel {
    MutableLiveData<Integer> Vnum1;
    MutableLiveData<Integer>Vnum2;
    Exersise exersise;
public Vm(){
    Vnum1=new MutableLiveData<>();
    Vnum2=new MutableLiveData<>();
    exersise=new Exersise();
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
}
