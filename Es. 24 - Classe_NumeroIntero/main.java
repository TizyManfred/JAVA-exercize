package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numero, agg, dec, cond;
        boolean condizione = true;
        boolean pari, primo;
        String numeroStr;

        Scanner input = new Scanner(System.in);

        System.out.print("Inserisci il numero da elaborare: ");
        numero = input.nextInt();
        NumeroIntero n1 = new NumeroIntero(numero);

        do {
            do {
                System.out.println("\n1) Inserisci un nuovo numero \n2) Incrementa il numero \n3) Decrementa il numero \n4) Il numero è pari? \n5) Il numero è un numero primo? \n6) Visualizza il numero\n0) Esci " );
                System.out.print("Inserisci la tua SCELTA: " );
                cond = input.nextInt();
            } while (cond <= 0 && cond > 7);

            switch (cond) {
                case 1: {
                    System.out.print("Inserisci il numero da elaborare: ");
                    numero = input.nextInt();
                    n1.setNumero(numero);
                    break;
                }
                case 2: {
                    System.out.print("Inserisci il numero da aggiungere: ");
                    agg = input.nextInt();
                    n1.aggiungi(agg);
                    break;
                }
                case 3: {
                    System.out.print("Inserisci il numero da decrementare: ");
                    dec = input.nextInt();
                    n1.togli(dec);
                    break;
                }
                case 4: {
                    pari = n1.pari();
                    if (pari){
                        System.out.println("Il numero è pari");
                    } else {
                        System.out.println("Il numero è dispari");
                    }
                    break;
                }
                case 5: {
                    primo = n1.primo();
                    if (primo) {
                        System.out.println("Il numero è primo");
                    } else {
                        System.out.println("Il numero NON è primo");
                    }
                    break;
                }
                case 6: {
                    numeroStr = n1.stampa();
                    System.out.println("Il numero è: "+numeroStr);
                    break;
                }
                case 0: {
                    System.out.println("Arrivederci" );
                    condizione = false;
                    break;
                }
            }
        } while (condizione);
    }
}
