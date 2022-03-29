package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int maxPeso, peso, valore, numOggetti, num, out;
        int  i, x, y, n, resto, pos, valoreElab, pesoElab, posElab, maxValoreElab, maxPesoElab;

        //Definizione di un array
        int [] valori;
        int [] pesi;
        int [] binario;
        int [] oggettiPresiV;
        int [] oggettiPresiP;

        Scanner input;
        input = new Scanner(System.in);

        //input
        System.out.print("Inserisci il peso massimo: ");
        maxPeso = input.nextInt();
        System.out.print("Inserisci il numero di oggetti che possiamo rubare: ");
        numOggetti = input.nextInt();

        //Allocazione di memoria
        valori = new int[numOggetti];
        pesi = new int[numOggetti];
        binario = new int[numOggetti];
        oggettiPresiV = new int[numOggetti];
        oggettiPresiP = new int[numOggetti];


        i = 0;
        //caricamento del peso e del valore degli oggetti inelle rispettive liste
        while (i < numOggetti){
            System.out.print("Inserisci il peso dell'oggetto: ");
            peso = input.nextInt();
            pesi[i] = peso;

            System.out.print("Inserisci il valore dell'oggetto: ");
            valore = input.nextInt();
            valori[i] = valore;

            i = i + 1;
        }

        //assegnazione
        x = 1;
        num = 1;
        maxValoreElab = 0;
        maxPesoElab = 0;
        pos = 1;
        posElab = 0;

        //calcolo quante possibili combinazioni ci sono (potenza)
        while (x <= numOggetti){
            pos = pos * 2;
            x = x + 1;
        }
        x = 0;

        //elaborazione
        while (posElab < pos) {
            //l'array binario viene portato a zero tutte le volte che si esegue il ciclo
            while (x < numOggetti){
                binario[x] = 0;
                x = x + 1;
            }

            //assegnamento
            x = 0;
            i = numOggetti - 1;
            n = num;

            //converto il numero da decimale a binario
            while (n > 0 && i >=0) {
                resto = n % 2;
                n = n/2;
                binario[i] = resto;
                i = i - 1;
            }

            //assegnazione
            num = num + 1;
            valoreElab = 0;
            pesoElab = 0;


            while (x < numOggetti){
                if (binario[x] == 1){
                    valoreElab = valoreElab + valori[x];
                    pesoElab = pesoElab + pesi[x];
                }
                x = x + 1;
            }

            //assegnazione
            x = 0;
            y = 0;

            //controllo che il peso degli oggetti sia minore del peso massimo
            if (pesoElab <= maxPeso){
                //verifico quale è il valore massimo
                if (valoreElab > maxValoreElab){
                    maxValoreElab = valoreElab;
                    maxPesoElab = pesoElab;
                    while (x < numOggetti){
                        //sposto nelle liste degli oggetti da prendere gli oggetti alla posizione dove è presente il numero 1 nella lista binaria
                        if (binario[x] == 1){
                            oggettiPresiV[y] = valori[x];
                            oggettiPresiP[y] = pesi[x];
                            y = y + 1;
                        }
                        x = x + 1;
                    }
                }
            }
            x = 0;
            posElab = posElab + 1;
        }

        //output
        System.out.println("Il valore della refuriva è: " + maxValoreElab);
        System.out.println("Il peso della refuriva è: " + maxPesoElab);

        System.out.println("Gli oggetti da prendere sono: ");
        System.out.print("Il valore degli oggetti è: ");
        //output del valore degli oggetti da prenderee
        while (x < numOggetti){
            out = oggettiPresiV[x];
            if (out != 0){
                if (x == 0){
                    System.out.print(out);
                } else {
                    System.out.print(", "+out);
                }
            }
            x = x + 1;
        }

        x = 0;
        System.out.println(" ");
        //output del peso degli oggetti da prendere
        System.out.print("Il peso degli oggetti è: ");
        while (x < numOggetti) {
            out = oggettiPresiP[x];
            if (out != 0){
                if (x == 0){
                    System.out.print(out);
                } else {
                    System.out.print(", "+out);
                }
            }
            x = x + 1;
        }
    }
}


