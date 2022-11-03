package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner((System.in));

        int max, scelta, pos, lati, sceltaQuad;
        float len, diag;
        boolean continua = true;

        PoligoniRegolari p;

        System.out.print("Inserisci il numero massimo di poligoni che vuoi inserire: ");
        max = input.nextInt();

        GestorePoligoni poli = new GestorePoligoni(max);

        while(continua) {
            do {
                System.out.println("\nMenù");
                System.out.println("---");
                System.out.println("1. Inserisci un nuovo poligono");
                System.out.println("2. Stampa l'area di un poligono a tua scelta");
                System.out.println("3. Stampa il perimetro di un poligono a tua scelta");
                System.out.println("4. Stampa tutti i dati di un poligono a tua scelta");
                System.out.println("5. Stampa tutti i poligoni inseriti");
                System.out.println("6. Stampa apotema di un determinato poligono");
                System.out.println("0. Esci dal programma");
                System.out.println("---");
                System.out.print("Inserisci la tua scelta: ");
                scelta = input.nextInt();
            } while (scelta < 0 || scelta > 6);

            switch (scelta){
                case 1: {
                    do {
                        System.out.print("Inserisci il numero di lati del poligono: ");
                        lati = input.nextInt();
                    }while(lati < 4 || lati > 6);

                    if(lati == 4){
                        do {
                            System.out.println("\nMenù poligoni a quattro lati");
                            System.out.println("---");
                            System.out.println("1. Se vuoi inserire un quadrato");
                            System.out.println("2. Se vuoi inserire un rombo");
                            System.out.println("---");
                            System.out.print("Inserisci la tua scelta: ");
                            sceltaQuad = input.nextInt();
                        } while(sceltaQuad < 1 || sceltaQuad > 2 );

                        do {
                            System.out.print("Inserisci la lunghezza del lato: ");
                            len = input.nextFloat();
                        }while(len <= 0);

                        if(sceltaQuad == 1){
                            Quadrato q = new Quadrato(len);
                            p = q;
                            try {
                                poli.inserisciPoligono(p);
                            } catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                        } else {
                            do {
                                System.out.print("Inserisci la lunghezza della diagonale: ");
                                diag = input.nextFloat();
                            }while(len <= 0);

                            Rombo r = new Rombo(len, diag);
                            p = r;
                            try {
                                poli.inserisciPoligono(p);
                            } catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                    } else {
                        do {
                            System.out.print("Inserisci la lunghezza del lato: ");
                            len = input.nextFloat();
                        }while(len <= 0);

                        if(lati == 5){
                            Pentagono pen = new Pentagono(len);
                            p = pen;
                            try {
                                poli.inserisciPoligono(p);
                            } catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                        } else {
                            Esagono es = new Esagono(len);
                            p = es;
                            try {
                                poli.inserisciPoligono(p);
                            } catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    break;
                }

                case 2: {
                    System.out.print("Inserisci la posizione del poligono che vuoi stampare l'area: ");
                    pos = input.nextInt();
                    pos = pos - 1;

                    try {
                        System.out.println(poli.area(pos));
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 3: {
                    System.out.print("Inserisci la posizione del poligono che vuoi stampare il perimetro: ");
                    pos = input.nextInt();
                    pos = pos - 1;

                    try {
                        System.out.println(poli.perimetro(pos));
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 4: {
                    System.out.print("Inserisci la posizione del poligono che vuoi stampare i valori: ");
                    pos = input.nextInt();
                    pos = pos - 1;

                    try {
                        System.out.println(poli.stampaValoriPoligono(pos));
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 5: {
                    System.out.println(poli.toString());
                    break;
                }

                case 6: {
                    System.out.print("Inserisci la posizione del poligono che vuoi stampare l'apotema: ");
                    pos = input.nextInt();
                    pos = pos - 1;

                    System.out.println("L'apotema è di " + poli.stampaApotema(pos) + "cm");

                    break;
                }

                case 0: {
                    System.out.println("Grazie e arrivederci");
                    continua = false;
                    break;
                }
            }
        }
    }
}
