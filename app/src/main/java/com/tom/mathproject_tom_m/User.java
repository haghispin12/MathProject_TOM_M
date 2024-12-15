package com.tom.mathproject_tom_m;

import android.graphics.Bitmap;
import android.net.Uri;

public class User {
    private String Name;
    private int Score;
    private int Rate;
    private Uri uri;
    private long id;

    public User(){

    }

    public User(long id, String name, int rating, Bitmap bitmap, int score) {
        this.Name = name;
        this.Score = score;
        this.Rate = rating;
        this.bitmap = bitmap;
        this.uri = uri;
        this.id = id;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    private Bitmap bitmap;

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }




    public int getScore() {
        return Score;
    }

    public int getRate() {
        return Rate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setScore(int score) {
        Score = score;
    }

    public void setRate(int rate) {
        Rate = rate;
    }
    public void updateScore(int scorePoints){
        Score+=scorePoints;
    }
}
