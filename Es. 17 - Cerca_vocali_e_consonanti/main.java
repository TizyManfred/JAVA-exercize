package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int i, x, len, nVocali, nConsonanti, lenSpazi;
        char c;
        char [] vocali = {'a','e','i','o','u'};

        Scanner input;
        input = new Scanner(System.in);

        //chiedo in input la stringa
        System.out.print("Inserisci la stringa: ");
        String stringa = input.nextLine();

        //calcolo la lunghezza della stringa
        lenSpazi = stringa.length();
        String stringaElab = stringa.replaceAll("\\s+","");
        len = stringaElab.length();

        //restituisco all'utente il valore della  lunghezza della stringa
        if (len != lenSpazi){
            System.out.println("La lunghezza della stringa con gli spazi è di: "+lenSpazi);
        } else {
            System.out.println("La lunghezza della stringa è: "+len);
        }

        //assegnazione
        i = 0;
        x = 0;
        nVocali = 0;

        //calcolo il numero delle vocali
        while (i < len){
            c = stringaElab.charAt(i);
            while (x < 5){
                if (c == vocali[x]){
                    nVocali = nVocali + 1;
                }
                x = x + 1;
            }
            i = i + 1;
            x = 0;
        }

        //trovo il numero delle consonanti
        nConsonanti = len - nVocali;

        //output
        System.out.println("Il numero delle vocali è: "+nVocali);
        System.out.println("Il numero delle consonanti è: "+nConsonanti);
    }
}
