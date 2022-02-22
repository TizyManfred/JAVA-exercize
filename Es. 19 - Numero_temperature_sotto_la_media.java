package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //dichiarazione
	    int len, giorni, somma, media, i;
        int [] temperature;

        boolean condizione = true;

        //assegnazione
        len = 10;
        i = 0;
        somma = 0;

        Scanner input = new Scanner(System.in);

        temperature = new int[len];

        while (i < len) {
            System.out.print("Inserisci la temperatura: ");
            temperature[i] = input.nextInt();
            somma = somma + temperature[i];
            i = i + 1;
        }

        //calcolo della media
        media = somma/len;

        //assegnazione
        i = 0;
        giorni = 0;

        //trovo i giorni con la temperatura al di sotto della media
        while (i<len) {
            if (temperature[i] < media) {
                giorni = giorni + 1;
            }
            i = i + 1;
        }

        //output
        if (giorni > 1) {
            System.out.println("Il numero di giorni con la temperatura al di sotto della media è "+giorni);
        } else if (giorni == 1){
            System.out.println("C'è solo un giorno con la temperatura al di sotto della media");
        } else {
            System.out.println("Non c'è nessuna temperatura al di sotto della media");
        }
    }
}
