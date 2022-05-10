package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int sizeX, sizeY;
        System.out.print("Inserisci la dimensione X: ");
        sizeX = input.nextInt();

        System.out.print("Inserisci la dimensione Y: ");
        sizeY = input.nextInt();

        Life vita;

        if (sizeX == sizeY) {
            vita = new Life(sizeX);
        } else {
            vita = new Life(sizeX, sizeY);
        }


        String lastCommand;

        int opzioneScelta = 1;

        while (opzioneScelta != 0) {
            System.out.println("1. Stampa la matrice");
            System.out.println("2. Inserisci valori personalizzati");
            System.out.println("3. Rigenera la matrice casualmente");
            System.out.println("4. Vai alla generazione successiva");
            System.out.println("0. Esci\n");

            opzioneScelta = input.nextInt();

            switch (opzioneScelta) {
                case 1:
                    System.out.println("Generazione: " + vita.getCurrentGeneration());
                    System.out.print(vita);

                    // vita.nextGeneration();
                    break;

                case 2:
                    for (int iy = 0; iy < sizeY; iy++) {
                        for (int ix = 0; ix < sizeX; ix++) {
                            System.out.print("Inserisci il valore per la cella [" + iy + "][" + ix + "]: ");
                            if (input.nextInt() == 1) {
                                vita.setState(ix, iy, true);
                            } else {
                                vita.setState(ix, iy, false);
                            }
                        }
                    }
                    break;

                case 3:
                    vita.generateInitialRandom();
                    break;

                case 4:
                    vita.nextGeneration();

                    System.out.println("Generazione: " + vita.getCurrentGeneration());
                    System.out.print(vita);

                    break;

                case 0:
                    break;
            }
        }
    }
}
