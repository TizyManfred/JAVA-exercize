package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //intervallo
        System.out.print("Inserisci il primo punto: ");
        double a = input.nextDouble();
        System.out.print("Inserisci il secondo punto: ");
        double b = input.nextDouble();

        int precisione;
        System.out.print("Inserisci la precisione con la quale vuoi il risultato: ");
        precisione = input.nextInt();

        boolean trovato = false;
        double x0 = 0;

        int iterazioni = 200; //numero che si può aumentare per aumentare la precisione ma quasi mai arriva a farne così tante

        if ((f(a) * f(b)) < 0) {
            double c;

            for (int i = 0; (i < iterazioni && !trovato); i++) {
                System.out.println("\nIterazione numero " + (i + 1) + ": ");
                c = (a + b) / 2;

                System.out.println("X1: "+a+"\nf(X1): "+f(a)+"\nX2: "+b+"\nf(X2): "+f(b));
                System.out.println("Xmedio: "+c+"\nf(c):"+f(c));

                if (f(c) == 0) {
                    x0 = c;
                    trovato = true;
                } else if (f(a) == 0){
                    x0 = a;
                    trovato = true;
                } else if (f(b) == 0){
                    x0 = b;
                    trovato = true;
                } else if ((f(a) * f(c)) < 0) {
                    b = c;
                } else if ((f(b) * f(c)) < 0) {
                    a = c;
                }
            }
        } else if(f(a) == 0) {
            x0 = a;
            trovato = true;
        } else if(f(b) == 0) {
            x0 = b;
            trovato = true;
        } else {
            System.out.println("L’ intervallo non contiene uno zero");
        }

        if(trovato){
            x0 = arrotonda(x0, precisione);
            System.out.println("\n\n"+x0+ "  E' lo zero della fuzione");
        }
    }

    public static double f(double x){
        double y = 0;

        //ho dovuto inserire questa equazione, altrimenti con il - dava problemi
        y = (Math.pow(2,x) + x);
        return y;
    }


    public static double arrotonda(double value, int numCifreDecimali) {
        double temp = Math.pow(10, numCifreDecimali);
        return Math.round(value * temp) / temp;
    }
}



