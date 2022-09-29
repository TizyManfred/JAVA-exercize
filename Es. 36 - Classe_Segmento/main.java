package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float x1, y1, x2, y2;
        Scanner input = new Scanner(System.in);

        System.out.println("Menù: ");
        System.out.println("---");
        System.out.println("1. Crea segmento");
        System.out.println("2. Sposta segmento");
        System.out.println("3. Sposta un punto");
      //da terminare

        System.out.println("0. Esci");


            System.out.println("Punto A");
            System.out.println("---");
            System.out.print("Inserisci la coordinata X: ");
            x1 = input.nextFloat();
            System.out.print("Inserisci la coordinata Y: ");
            y1 = input.nextFloat();

            Point a = new Point(x1, y1);


            System.out.println("Punto B");
            System.out.println("---");
            System.out.print("Inserisci la coordinata X: ");
            x2 = input.nextFloat();
            System.out.print("Inserisci la coordinata Y: ");
            y2 = input.nextFloat();

            Point b = new Point(x1, y1);


            Segment seg = new Segment(a, b);
    }
}
