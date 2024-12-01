package com.tom.mathproject_tom_m;

import android.widget.ImageView;
import android.widget.TextView;

public class Fruit {
   ImageView imageView;
   TextView tx;
    private String name;
    private int drawable;
    public Fruit(String name,int drawable) {
        this.drawable = drawable;
        this.name = name;
    }
    public String getfruitName() {
        return name;
    }
    public int getDrawable() {
        return drawable;
    }
    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
    public void setName(String name) {
        this.name = name;
    }

    }

