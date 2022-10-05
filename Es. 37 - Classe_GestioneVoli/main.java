package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean cont = true;
        String nome;
        int scelta, capienza;

        /*
        boolean cond = true;
        Voli v1;

        do {
            System.out.print("Inserisci la capienza dell'aereo: ");
            capienza = input.nextInt();
            try {
                v1 = new Voli(capienza);
                cond = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while(cond);
         */

        do{
            System.out.print("Inserisci la capienza dell'aereo: ");
            capienza = input.nextInt();
        }while(capienza < 1);
        Voli v1 = new Voli(capienza);


        while(cont) {
            do {
                System.out.println("Menù:");
                System.out.println("---");
                System.out.println("1. Prenota volo");
                System.out.println("2. Disdici volo");
                System.out.println("3. Posti disponibili");
                System.out.println("4. Posti disponibili in attesa");
                System.out.println("5. Stampare la situazione attuale");
                System.out.println("0. Esci");
                System.out.println("---");
                System.out.print("Inserisci la tua scelta: ");
                input = new Scanner(System.in);
                scelta = input.nextInt();
            } while (scelta < 0 || scelta > 5);

            switch (scelta){
                case 1: {
                    System.out.print("Inserisci il nome a cui vuoi effettuare la prenotazione: ");
                    input = new Scanner(System.in);
                    nome = input.nextLine();
                    try {
                        v1.prenotaVolo(nome);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    System.out.print("Inserisci il nome a cui hai effettuato la prenotazione che vuoi disdire: ");
                    input = new Scanner(System.in);
                    nome = input.nextLine();
                    try {
                        v1.cancellaPrenotazione(nome);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    System.out.println("Ci sono ancora "+(capienza-v1.getNumPosti())+" posti disponibili sull'aereo");
                    break;
                }
                case 4: {
                    System.out.println("Ci sono ancora "+(capienza-v1.getNumAttesa())+" posti disponibili in attesa");
                    break;
                }
                case 5: {
                    System.out.println(v1.toString());
                }
                case 0: {
                    System.out.println("Grazie e arrivederci");
                    cont = false;
                    break;
                }
            }
        }
    }
}
