package com.company;

public class Segment {
    //attributi
    private Point p1;
    private Point p2;

    //costruttore
    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    //metodi
    public double length(){
        double len = 0;
        len = Math.sqrt(Math.pow((p2.getX()- p1.getX()),2)+Math.pow((p2.getY() - p1.getY()),2));
        return len;
    }

    public Point middle(){
        Point medio;
        medio = new Point(p1.getX() -p2.getX(), p1.getY() -p2.getY());
        return medio;
    }

    public void shift(float shiftX, float shiftY){
        p1.shift(shiftX, shiftY);
        p2.shift(shiftX, shiftY);
    }

    //getter
    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    //toString
    String ToString(){
        String str = "";
        str = "Coordinate punto A: "+p1.ToString()+"\nCoordinate punto B: "+p2.toString();
        return str;
    }
}
