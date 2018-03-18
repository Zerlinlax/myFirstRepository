package com.example.zerlin.ui_pickershomework;

public class Food {

    private String name;
    private boolean spicy;
    private boolean seafood;
    private boolean sour;
    private int price;
    private int picture;

    public Food(String name, boolean spicy, boolean seafood
            , boolean sour, int price, int picture) {
        this.name = name;
        this.spicy = spicy;
        this.seafood = seafood;
        this.sour = sour;
        this.price = price;
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", spicy=" + spicy +
                ", seafood=" + seafood +
                ", sour=" + sour +
                ", price=" + price +
                ", picture=" + picture +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public boolean isSeafood() {
        return seafood;
    }

    public void setSeafood(boolean seafood) {
        this.seafood = seafood;
    }

    public boolean isSour() {
        return sour;
    }

    public void setSour(boolean sour) {
        this.sour = sour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
