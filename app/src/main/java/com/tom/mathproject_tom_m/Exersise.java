package com.tom.mathproject_tom_m;

import java.util.Random;

public class Exersise {
    private int num1;
    private int num2;
    private int num3;


    public  void generateloachnumbers(){//לוח הכפל
        Random r=new Random();
        this.num1=r.nextInt(10);
        this.num2=r.nextInt(10);
    }
    public   void generatead20numbers(){//ad20
        Random r=new Random();
        this.num1=r.nextInt(10);
        this.num2=r.nextInt(10)+10;
    }
    public   void generateetgernumbers() {//etger
        Random r = new Random();
        this.num1 = r.nextInt(10);
        this.num2 = r.nextInt(90) + 10;
    }
        public boolean check(String str){
            num3=num1*num2;
            String res=num3+"";
            if (res.equals(str))
                return true;

                return false;

        }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getNum3() {
        return num3;
    }

}
