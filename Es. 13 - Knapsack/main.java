package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int maxPeso, peso, valore, scambio, pesoElab;
        int numOggetti, i, x, valoreRefurtiva, pesoZainoEffettivo;
        boolean condizione;

        //Definizione di un array
        int [] valori;
        int [] pesi;
        int [] valoriElab;


        Scanner input;
        input = new Scanner(System.in);

        System.out.print("Inserisci il peso massimo: ");
        maxPeso = input.nextInt();
        System.out.print("Inserisci il numero di oggetti che possiamo rubare: ");
        numOggetti = input.nextInt();

        //Allocazione di memoria
        valori = new int[numOggetti];
        pesi = new int[numOggetti];
        valoriElab = new int[numOggetti];

        i = 0;
        while (i < numOggetti){
            System.out.print("Inserisci il peso dell'oggetto: ");
            peso = input.nextInt();
            pesi[i] = peso;

            System.out.print("Inserisci il valore dell'oggetto: ");
            valore = input.nextInt();
            valori[i] = valore;

            i = i +1;
        }


        for (i = 0; i < numOggetti; i++) {
            valoriElab[i] = valori[i];
        }

        i = 0;
        x = 0;

        while (i < (numOggetti - 1)) {
            x = i + 1;
            while (x < numOggetti) {
                if (valoriElab[i] > valoriElab[x]) {
                    scambio = valoriElab[x];
                    valoriElab[x] = valoriElab[i];
                    valoriElab[i] = scambio;
                }
                x = x + 1;
            }
            i = i + 1;
        }

        i = 0;
        pesoElab = maxPeso;
        x = numOggetti - 1;
        valoreRefurtiva = 0;
        condizione = true;

        while ((condizione != false)||(pesoElab > 0)) {
            while (valoriElab[x] != valori[i]) {
                i = i + 1;
            }
            if (pesi[i] <= pesoElab) {
                System.out.println("sono dentro");
                valoreRefurtiva = valoreRefurtiva + valori[i];
                pesoElab = pesoElab - pesi[i];
            }

            if (x > 0) {
                x = x - 1;
            }
            else {
                condizione = false;
            }
            i = 0;
        }

        pesoZainoEffettivo  = maxPeso - pesoElab;
        System.out.println("Il valore della refuriva è: "+ valoreRefurtiva);
        System.out.println("Il peso della refuriva è: "+ pesoElab);

    }
}
