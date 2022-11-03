package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);

        int scelta, numeroArticoli;
        float prezzoArticolo;

        System.out.print("Inserisci il numero di articoli che vuoi acquistare: ");
        numeroArticoli = input.nextInt();
        System.out.print("Inserisci il prezzo di un singolo articolo: ");
        prezzoArticolo = input.nextFloat();

        do{
            System.out.println("Menù sconto");
            System.out.println("---");
            System.out.println("1. Sconto superiore a quantita minima");
            System.out.println("2. Prendi uno gratis ogni n articoli");
            System.out.println("---");
            System.out.print("Inserisci la tua scelta: ");
            scelta = input.nextInt();
        }while(scelta < 1 || scelta > 2);

        switch (scelta){
            case 1: {
                int minimo;
                float sconto;

                System.out.print("Inserisci il numero minimo di articoli da aquistare per avere lo sconto: ");
                minimo = input.nextInt();
                System.out.print("Inserisci lo sconto applicato: ");
                sconto = input.nextFloat();

                ScontoQuantità prod = new ScontoQuantità(numeroArticoli, prezzoArticolo, minimo, sconto);

                System.out.println(prod.toString());
                break;
            }
            case 2: {
                int num;

                System.out.print("Inserisci il numero di articoli per averne uno gratis: ");
                num = input.nextInt();

                CompraNArticoliPrendiUnoGratis prod = new CompraNArticoliPrendiUnoGratis(numeroArticoli, prezzoArticolo, num);

                System.out.println(prod.toString());
                break;
            }
        }

    }
}
