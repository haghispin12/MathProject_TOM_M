package com.tom.mathproject_tom_m;

public class Card {
    private int Number;
    private String Color;

    public Card(int number, String color, int image) {
        Number = number;
        Color = color;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private int image;

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }
    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
    public Card(){
    }

}
