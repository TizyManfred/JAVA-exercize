package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //dichiarazione
        int giorni, somma, i, minGiorni;
        float media;
        int [] temperature;

        //assegnazione
        giorni = 10;
        i = 0;
        somma = 0;
        minGiorni = 0;
        temperature = new int[giorni];

        //Richiamo la funzione
        caricamento(giorni, temperature);

        somma = somma(giorni,temperature);

        media = media(giorni,somma);

        sottoMedia(giorni, media, temperature);

        output(minGiorni);
    }

    public static void caricamento(int len, int [] a) {
        //inizializzazione
        int i;
        Scanner input = new Scanner(System.in);
        for (i=0;i<len;i++) {
            System.out.print("Inserisci la temperatura: ");
            a[i] = input.nextInt();
        }
    }

    public static int somma(int len, int [] a) {  //ritorna un intero al chiamante
        int i;
        int sum = 0;
        for(i=0;i<len;i++){
            sum = sum + a[i];
        }
        return sum;
    }

    public static float media(int somma, int giorni) {
        float media;
        media = somma/giorni;
        System.out.println("La media è di "+media+" gradi");
        return media;
    }

    public static int sottoMedia(int len, float media, int [] a){
        int i = 0;
        int minGiorni = 0;
        //trovo i giorni con la temperatura al di sotto della media
        while (i<len) {
            if (a[i] < media) {
                minGiorni = minGiorni + 1;
                System.out.println("Il "+(i+1)+" giorno ha un temperatura di "+a[i]+" gradi");
            }
            i = i + 1;
        }
        return minGiorni;
    }

    public static void output(int gg){
        //output
        if (gg > 1) {
            System.out.println("Il numero di giorni con la temperatura al di sotto della media è "+gg);
        } else if (gg == 1){
            System.out.println("C'è solo un giorno con la temperatura al di sotto della media");
        } else {
            System.out.println("Non c'è nessuna temperatura al di sotto della media");
        }
    }
}
