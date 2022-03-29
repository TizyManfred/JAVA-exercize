package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a, b, c, a1, b1, c1, Ds, Dx, Dy, x, y;

        Scanner input;
        input = new Scanner(System.in);

        System.out.println("Inserimento della prima equazione");
        System.out.print("Inserisci il valore di a: ");
        a = input.nextInt();
        System.out.print("Inserisci il valore di b: ");
        b = input.nextInt();
        System.out.print("Inserisci il valore di c: ");
        c = input.nextInt();

        System.out.println("Inserimento della seconda equazione");
        System.out.print("Inserisci il valore di a: ");
        a1 = input.nextInt();
        System.out.print("Inserisci il valore di b: ");
        b1 = input.nextInt();
        System.out.print("Inserisci il valore di c: ");
        c1 = input.nextInt();

        Ds = (a*b1)-(a1*b);
        Dx = (c * b1) - (c1 * b);
        Dy = (a * c1) - (a1 * c);

        if(Ds == 0 && Dx == 0){
            System.out.println("Il sistema è indeterminato");
        }
        else if(Ds == 0 && Dx != 0){
            System.out.println("Il sistema è impossibile");
        }
        else {
            x = Dx / Ds;
            y = Dy / Ds;

            System.out.println("La soluzione di x è: "+ x);
            System.out.println("La soluzione di y è: " + y);
        }
    }
}
