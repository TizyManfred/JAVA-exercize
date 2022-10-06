package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean continua = true;
        int periodo, scelta, giorno;
        float km;
        Scanner input = new Scanner(System.in);

        System.out.println("Inserisci il numero di giorni che vuoi elaborare: ");
        periodo = input.nextInt();
        Corriere c1 = new Corriere(periodo);

        while(continua) {
            do {
                System.out.println("\nMenù");
                System.out.println("---");
                System.out.println("1. Inserisci km percorsi");
                System.out.println("2. Calcola media km percorsi");
                System.out.println("3. Calcola totale km percorsi");
                System.out.println("4. Trova i km percorsi in un determinato giorno");
                System.out.println("5. Calcolo massimo scarto");
                System.out.println("6. Sapere giorno a cui siamo arrivati");
                System.out.println("7. Stampare i valori inseriti");
                System.out.println("0. Esci");
                System.out.println("---");
                System.out.print("Inserisci la tua scelta: ");
                scelta = input.nextInt();
            }while(scelta < 0 || scelta > 7);

            switch (scelta){
                case 1: {
                    System.out.print("Inserisci la distanza percorsa: ");
                    km = input.nextFloat();
                    try {
                        c1.inserisciKm(km);
                        System.out.println("Distanza inserita correttamente");
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 2: {
                    try {
                        System.out.println("La media è "+c1.media()+" km");
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 3: {
                    try {
                        System.out.println("La somma dei km percorsi è "+c1.totKm()+" km");
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 4: {
                    System.out.print("Inserisci il giorno di cui vuoi sapere i km: ");
                    giorno = input.nextInt();
                    try {
                        System.out.println("il "+giorno+"° giorno hai percorso "+c1.kmPercorsi(giorno)+" km");
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 5: {
                    try {
                        System.out.println("La differenza è di "+c1.maxDifferenza()+" km");
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 6: {
                    System.out.println("Hai inserito "+c1.getGGAttuale()+" giorni");
                    break;
                }

                case 7: {
                    System.out.println(c1.toString());
                    break;
                }

                case 0: {
                    continua = false;
                    System.out.println("Grazie e arrivederci");
                    break;
                }
            }
        }
    }
}
