package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int scelta = 0;
        String key, value;
        Scanner input = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);
        ArrayDictionary<String, String> dictionary = new ArrayDictionary<String, String>();

        do{
            System.out.println("\n\nMenù");
            System.out.println("---");
            System.out.println("1) Inserisci una parola e la definizione");
            System.out.println("2) Cerca la definizione tramite una parola");
            System.out.println("3) Controlla quante parole ci sono nel dizionario");
            System.out.println("4) Stampa tutto il dizionario");
            System.out.println("5) Riordina in ordine alfabetico");
            System.out.println("0) Esci");
            System.out.println("---");
            System.out.print("Opzione: ");
            scelta = inputInt.nextInt();

            switch(scelta){
                case 0: {
                    System.out.println("Grazie e arrivederci!");
                    break;
                }

                case 1: {
                    System.out.print("Inserisci una parola: ");
                    key = input.nextLine();
                    System.out.print("Inserisci la sua definizione: ");
                    value = input.nextLine();

                    try {
                        dictionary.insert(key, value);
                        System.out.println("Parola inserita con successo!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 2: {
                    System.out.print("Inserisci una parola: ");
                    key = input.nextLine();

                    try {
                        System.out.println(key + ": " + dictionary.search(key));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 3: {
                    System.out.println("Le parole presenti nel dizionario sono: " + dictionary.count());
                    break;
                }

                case 4: {
                    System.out.println(dictionary.toString());
                    break;
                }

                case 5: {
                    dictionary.alphaOrder();
                    break;
                }

                default: {
                    System.out.println("Errore! Riprova");
                    break;
                }
            }
        }while(scelta!=0);
    }
}
