package com.company;

public class Point {
    //attributi
    private float x;
    private float y;

    //costruttori
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    //metodi
    void moveTo(float newX, float newY) {
        this.x = newX;
        this.y = newY;
    }

    void shift(float shiftX, float shiftY){
        x = x + shiftX;
        y = y + shiftY;
    }

    //getter
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    String ToString(){
        String str;
        str = "("+x+"; "+y+")";
        return str;
    }
}
