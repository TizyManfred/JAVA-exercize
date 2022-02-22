package com.company;

import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        int numOggetti, i, num, ris;

        i = 0;
        numOggetti = 15;
        int [] array;
        array = new int[numOggetti];

        Scanner input;
        input = new Scanner(System.in);

        Random random = new Random();

        while(i < numOggetti) {
            int temp = random.nextInt();
            array[i] = temp;
            i = i + 1;
        }

        System.out.print("Inserisci il numero da cercare: ");
        num = input.nextInt();
        i = 0;
        ris = 0;

        while (i < numOggetti) {
            if (array[i] == num){
                ris = ris + 1;
            }
            i = i + 1;
        }

        if (ris == 0){
            System.out.print("Il numero "+num+" non è presente nell'array");
        } else {
            System.out.print("Ci sono " + ris + " numeri ");
        }

    }
}
