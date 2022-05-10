package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String nomeStudente;
        int puntiEsercizio1, puntiEsercizio2, puntiIntermedio1, puntiIntermedio2, puntiFinale, condizione;
        boolean controllo = true;
        float media1, media2, media3;
        char lettera1, lettera2, lettera3;
        condizione =  1;

        Valutazione studente1 = null;
        Valutazione studente2 = null;
        Valutazione studente3 = null;

        while(controllo) {
            switch (condizione) {
                case 1: {
                    System.out.println("Studente 1: ");

                    System.out.print("Inserisci il nome dello studente: ");
                    nomeStudente = input.nextLine();

                    do {
                        System.out.print("Inserisci il punteggio dell'esercizio 1: ");
                        puntiEsercizio1 = input.nextInt();
                    } while (puntiEsercizio1 > 10 || puntiEsercizio1 < 0);

                    do {
                        System.out.print("Inserisci il punteggio dell'esercizio 2: ");
                        puntiEsercizio2 = input.nextInt();
                    } while (puntiEsercizio2 > 10 || puntiEsercizio2 < 0);

                    do {
                        System.out.print("Inserisci il punteggio dell'intermedio 1: ");
                        puntiIntermedio1 = input.nextInt();
                    } while (puntiIntermedio1 > 100 || puntiIntermedio1 < 0);

                    do {
                        System.out.print("Inserisci il punteggio dell'intermedio 2: ");
                        puntiIntermedio2 = input.nextInt();
                    } while (puntiIntermedio2 > 100 || puntiIntermedio2 < 0);

                    do {
                        System.out.print("Inserisci il punteggio della finale: ");
                        puntiFinale = input.nextInt();
                    } while (puntiFinale > 100 || puntiFinale < 0);

                    studente1 = new Valutazione(nomeStudente, puntiEsercizio1, puntiEsercizio2, puntiIntermedio1, puntiIntermedio2, puntiFinale);


                    System.out.println("Studente 2: ");
                    input = new Scanner(System.in);

                    System.out.print("Inserisci il nome dello studente: ");
                    nomeStudente = input.nextLine();

                    do {
                        System.out.print("Inserisci il punteggio dell'esercizio 1: ");
                        puntiEsercizio1 = input.nextInt();
                    } while (puntiEsercizio1 > 10 || puntiEsercizio1 < 0);

                    do {
                        System.out.print("Inserisci il punteggio dell'esercizio 2: ");
                        puntiEsercizio2 = input.nextInt();
                    } while (puntiEsercizio2 > 10 || puntiEsercizio2 < 0);

                    do {
                        System.out.print("Inserisci il punteggio dell'intermedio 1: ");
                        puntiIntermedio1 = input.nextInt();
                    } while (puntiIntermedio1 > 100 || puntiIntermedio1 < 0);

                    do {
                        System.out.print("Inserisci il punteggio dell'intermedio 2: ");
                        puntiIntermedio2 = input.nextInt();
                    } while (puntiIntermedio2 > 100 || puntiIntermedio2 < 0);

                    do {
                        System.out.print("Inserisci il punteggio della finale: ");
                        puntiFinale = input.nextInt();
                    } while (puntiFinale > 100 || puntiFinale < 0);

                    studente2 = new Valutazione(nomeStudente, puntiEsercizio1, puntiEsercizio2, puntiIntermedio1, puntiIntermedio2, puntiFinale);


                    System.out.println("Studente 3: ");
                    input = new Scanner(System.in);

                    System.out.print("Inserisci il nome dello studente: ");
                    nomeStudente = input.nextLine();

                    do {
                        System.out.print("Inserisci il punteggio dell'esercizio 1: ");
                        puntiEsercizio1 = input.nextInt();
                    } while (puntiEsercizio1 > 10 || puntiEsercizio1 < 0);

                    do {
                        System.out.print("Inserisci il punteggio dell'esercizio 2: ");
                        puntiEsercizio2 = input.nextInt();
                    } while (puntiEsercizio2 > 10 || puntiEsercizio2 < 0);

                    do {
                        System.out.print("Inserisci il punteggio dell'intermedio 1: ");
                        puntiIntermedio1 = input.nextInt();
                    } while (puntiIntermedio1 > 100 || puntiIntermedio1 < 0);

                    do {
                        System.out.print("Inserisci il punteggio dell'intermedio 2: ");
                        puntiIntermedio2 = input.nextInt();
                    } while (puntiIntermedio2 > 100 || puntiIntermedio2 < 0);

                    do {
                        System.out.print("Inserisci il punteggio della finale: ");
                        puntiFinale = input.nextInt();
                    } while (puntiFinale > 100 || puntiFinale < 0);

                    studente3 = new Valutazione(nomeStudente, puntiEsercizio1, puntiEsercizio2, puntiIntermedio1, puntiIntermedio2, puntiFinale);
                    break;
                }
                case 2: {
                    media1 = studente1.mediaFinale();
                    media2 = studente2.mediaFinale();
                    media3 = studente3.mediaFinale();
                    System.out.println("Media ponderata studente 1: "+media1);
                    System.out.println("Media ponderata studente 2: "+media2);
                    System.out.println("Media ponderata studente 3: "+media3);
                    break;
                }

                case 3: {
                    lettera1 = studente1.votoLettera();
                    lettera2 = studente2.votoLettera();
                    lettera3 = studente3.votoLettera();
                    System.out.println("La valutazione in lettera dello studente 1 è: "+lettera1);
                    System.out.println("La valutazione in lettera dello studente 2 è: "+lettera2);
                    System.out.println("La valutazione in lettera dello studente 3 è: "+lettera3);
                    break;
                }


                case 4: {
                    System.out.println(studente1.toString());
                    System.out.println(studente2.toString());
                    studente3.toString();

                    break;
                }


                case 5: {
                    media1 = studente1.mediaFinale();
                    media2 = studente2.mediaFinale();
                    media3 = studente3.mediaFinale();

                    if(media1 > media2 && media1 > media3){
                        System.out.println(studente1.toString());

                        if(media2 > media3){
                            System.out.println(studente2.toString());
                            System.out.println(studente3.toString());
                        } else {
                            System.out.println(studente3.toString());
                            System.out.println(studente2.toString());
                        }

                    } else if(media2 > media1 && media2 > media3){
                        System.out.println(studente2.toString());

                        if(media1 > media3){
                            System.out.println(studente1.toString());
                            System.out.println(studente3.toString());
                        } else {
                            System.out.println(studente3.toString());
                            System.out.println(studente1.toString());
                        }

                    } else if(media3 > media1 && media3 > media2){
                        System.out.println(studente3.toString());

                        if(media1 > media2){
                            System.out.println(studente1.toString());
                            System.out.println(studente2.toString());
                        } else {
                            System.out.println(studente2.toString());
                            System.out.println(studente1.toString());
                        }

                    } else if(media1 == media2){
                        if(media2 > media3) {
                            System.out.println(studente1.toString());
                            System.out.println(studente2.toString());

                            System.out.println(studente3.toString());
                        } else {
                            System.out.println(studente3.toString());

                            System.out.println(studente1.toString());
                            System.out.println(studente2.toString());
                        }

                    } else if(media2 == media3){
                        if(media2 > media1) {
                            System.out.println(studente2.toString());
                            System.out.println(studente3.toString());

                            System.out.println(studente1.toString());
                        } else {
                            System.out.println(studente1.toString());

                            System.out.println(studente2.toString());
                            System.out.println(studente3.toString());
                        }

                    } else if(media1 == media3){
                        if(media1 > media2) {
                            System.out.println(studente1.toString());
                            System.out.println(studente3.toString());

                            System.out.println(studente2.toString());
                        } else {
                            System.out.println(studente2.toString());

                            System.out.println(studente1.toString());
                            System.out.println(studente3.toString());
                        }

                    } else {
                        System.out.println(studente1.toString());
                        System.out.println(studente2.toString());
                        System.out.println(studente3.toString());
                    }
                    break;
                }

                case 6:{
                    controllo = false;
                    break;
                }

            }
            do{
                System.out.println("Menu");
                System.out.println("1. Inserimento dei voti dei tre studenti\n" +
                        "2. Visualizza la Media Ponderata dei tre studenti\n" +
                        "3. Voto in lettera dei tre studenti\n" +
                        "4. Voti, media e lettera dei tre studenti\n" +
                        "5. Stampare a video lo stato degli oggetti in ordine decrescente di media totale.\n" +
                        "6. Esci dal programma");
                condizione = input.nextInt();
            }while(condizione >= 6 || condizione <=1);
        }
    }
}
