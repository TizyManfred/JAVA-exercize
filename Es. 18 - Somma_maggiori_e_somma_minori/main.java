package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //dichiarazione
        int elementi, i, x, y, spartiacque, sommaMin, sommaMax, nElementiMax, nElementiMin;

        int [] vTutti;
        int [] vMin;
        int [] vMax;

        //assegnamento
        elementi = 100;
        spartiacque = 50;
        sommaMin = 0;
        sommaMax = 0;
        i = 0;
        x = 0;
        y = 0;

        vTutti = new int[elementi];
        vMin = new int[elementi];
        vMax = new int[elementi];

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        //caricamento valori nell'array
        while (i<elementi){
            vTutti[i] = random.nextInt(100); //ho assegnato io arbitrariamente che i valori arrivino fino a 100
            i = i + 1;
        }

        i = 0;


        while (i<elementi){
            if (vTutti[i] < spartiacque){
                vMin[x] = vTutti[i];
                sommaMin = sommaMin + vTutti[i];
                x = x + 1;
            } else {
                vMax[y] = vTutti[i];
                sommaMax = sommaMax + vTutti[i];
                y = y + 1;
            }
            i = i + 1;
        }

        //assegnamento
        nElementiMin = x + 1;
        nElementiMax = y + 1;
        x = 0;
        y = 0;

        //output vettore vMin
        System.out.println("Gli elementi minori di "+spartiacque+" sono: ");
        while (x<nElementiMin) {
            if (x == (nElementiMin-1)){
                System.out.println(vMin[x]);
            } else {
                System.out.print(vMin[x] + ", ");
            }
            x = x + 1;
        }

        //output vettore vMax
        System.out.println("Gli elementi maggiori di "+spartiacque+" sono: ");
        while (y<nElementiMax) {
            if (y == (nElementiMax-1)){
                System.out.println(vMax[y]);
            } else {
                System.out.print(vMax[y] + ", ");
            }
            y = y + 1;
        }

        //trovo la somma maggiore e do in output all'utente il risultato
        if (sommaMin > sommaMax) {
            System.out.print("La somma maggiore è quella dei numeri minori di "+spartiacque+" con il risultato di "+sommaMin);
        } else {
            System.out.print("La somma maggiore è quella dei numeri maggiori di "+spartiacque+" con il risultato di "+sommaMax);
        }
    }
}
