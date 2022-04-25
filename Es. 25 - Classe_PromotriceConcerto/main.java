package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int capacita, scelta2, persone;
        float prezzoTelefono, prezzoPosto;
        String scelta1, nome, scelta3;
        boolean condizione1, condizione2, condizione3, telefono;

        Scanner input = new Scanner(System.in);

	    System.out.println("Sezione organizzatore");
        System.out.println("---");
        System.out.print("Inserisci la capacita di posti per il concerto: ");
        capacita = input.nextInt();
        System.out.print("Inserisci il costo del biglietto se prenotato al telefono: ");
        prezzoTelefono = input.nextFloat();
        System.out.print("Inserisci il costo del biglietto se comperato sul posto: ");
        prezzoPosto = input.nextFloat();

        PromotriceConcerto con1 = new PromotriceConcerto(capacita, prezzoTelefono, prezzoPosto);

        System.out.println("\nInizio programma");
        System.out.println("---");

        condizione1 = true;
        condizione2 = true;

        while(condizione1) {
            do {
                System.out.println("Sei un cliente o un organizzatore? Se vuoi uscire scrivi esci");
                input = new Scanner(System.in);
                scelta1 = input.nextLine();
            } while (scelta1.equals("organizzatore") && scelta1.equals("cliente") && scelta1.equals("esci"));

            if (scelta1.equals("organizzatore")) {
                while (condizione2) {
                    do {
                        System.out.println("Menù: ");
                        System.out.println("1) Visualizza il numero di biglietti venduti");
                        System.out.println("2) Visualizza il numero di biglietti disponibili");
                        System.out.println("3) Totale guadagno attuale");
                        System.out.println("0) Cambia operatore");
                        input = new Scanner(System.in);
                        scelta2 = input.nextInt();
                    } while (scelta2 < 0 && scelta2 > 4);

                    input = new Scanner(System.in);

                    switch (scelta2) {
                        case 1: {
                            System.out.println("Sono stati venduti: " + con1.getNumeroBigliettiVenduti());
                            break;
                        }

                        case 2: {
                            System.out.println("Sono ancora disponibili: " + con1.getNumeroBigliettiRimanenti());
                            break;
                        }

                        case 3: {
                            System.out.println("Guadagno attuale: " + con1.getRicavoTotale());
                            break;
                        }

                        default: {
                            condizione2 = false;
                            break;
                        }
                    }
                }
            } else if (scelta1.equals("cliente")) {
                while(condizione2) {
                    do {
                        System.out.println("Menù: ");
                        System.out.println("1) Registra una vendita");
                        System.out.println("2) Modifica lo stato di una vendita");
                        System.out.println("3) Visualizza il numero di biglietti venduti");
                        System.out.println("0) Cambia operatore");
                        input = new Scanner(System.in);
                        scelta2 = input.nextInt();
                    } while (scelta2 < 0 && scelta2 > 4);

                    input = new Scanner(System.in);

                    switch (scelta2) {
                        case 1: {
                            if(con1.getNumeroBigliettiRimanenti() == 0){
                                System.out.println("Impossibile eseguire");
                            } else {
                                do {
                                    System.out.print("Inserisci il numero di persone: ");
                                    persone = input.nextInt();
                                    condizione3 = con1.azioneEseguibile(persone);
                                } while (condizione3);

                                input = new Scanner(System.in);
                                System.out.print("Inserisci il nome del gruppo: ");
                                nome = input.nextLine();

                                do {
                                    input = new Scanner(System.in);
                                    System.out.print("Inserisci la modalità di vendita (telefono/posto): ");
                                    scelta3 = input.nextLine();
                                } while (scelta3.equals("telefono") && scelta3.equals("posto"));

                                if (scelta3.equals("telefono")) {
                                    telefono = true;
                                } else {
                                    telefono = false;
                                }

                                con1.registra(nome, telefono, persone);
                            }
                            break;
                        }

                        case 2: {
                            System.out.print("Inserire il nome del gruppo da cambiare stato: ");
                            nome = input.nextLine();

                            con1.modificaStato(nome);
                            break;
                        }

                        case 3: {
                            System.out.println("Sono stati venduti: " + con1.getNumeroBigliettiVenduti());
                            break;
                        }

                        default: {
                            condizione2 = false;
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Grazie e arrivederci");
                condizione1 = false;
            }
            condizione2 = true;
        }

    }
}
