package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int num = rand.nextInt() % 2;
        Scanner input = new Scanner(System.in);
        boolean firstPlayer;
        if (num == 1) {
            firstPlayer = true;
        } else {
            firstPlayer = false;
        }

        Tris game = new Tris(firstPlayer, true);
        System.out.println("Benvenuti nel gioco del tris. Il numero di giocatori richiesti è due. Prima di iniziare decidete quale sarà il vostro simbolo tra 'X' e 'O. Ora possiamo continuare\nChi inizierà la prima partita per primo verrà estratto a caso, per le altre chi perderà, o in caso di pareggio, chi non ");

        int temp;
        do {
            do {
                do {
                    System.out.println("Scegli una tra le voci qui sotto:\n1) Inizia la partita\n2) Contatore delle vittorie\n0) Esci");
                    temp = input.nextInt();
                } while(temp < 0);
            } while(temp > 2);

            int move;
            switch(temp) {
            case 1:
                move = 1;
                if (game.getPlayer()) {
                    System.out.println("Il tuo segno è 'X'");
                } else {
                    System.out.println("Il tuo segno è 'O'");
                }
                break;
            case 2:
                System.out.println("Il giocatore X ha vinto " + game.getWin(1) + " volte");
                System.out.println("Il giocatore O ha vinto " + game.getWin(0) + " volte");
                System.out.println("Ci sono stati " + game.getWin(2) + " pareggi");
            default:
                continue;
            }

            for(; !game.checkTris() && move < 10; move += 2) {
                System.out.println("E' il tuo turno");

                int i;
                int j;
                do {
                    System.out.println(game.toString());
                    System.out.print("Inserisci la tua scelta: ");

                    do {
                        System.out.println("Riga:");
                        i = input.nextInt() - 1;
                        if (i < 0 || i > 2) {
                            System.out.println("Hai sbagliato riprova");
                        }
                    } while(i < 0 || i > 2);

                    do {
                        System.out.println("Colonna:");
                        j = input.nextInt() - 1;
                        if (j < 0 || j > 2) {
                            System.out.println("Hai sbagliato riprova");
                        }
                    } while(j < 0 || j > 2);

                    if (game.getTable(i, j)) {
                        System.out.println("La casella che hai scelto è occupata. Riprova!");
                    }
                } while(game.getTable(i, j));

                game.move(i, j);
                if (move < 9 && !game.checkTris()) {
                    System.out.println("E' il turno del computer");
                    System.out.println(game.toString());
                    game.mossaRandom();
                }
            }

            System.out.println(game.toString());
            if (game.getPlayer() && move < 9) {
                System.out.println("Ha vinto il giocatore O");
                game.setWin(0);
            } else if (!game.getPlayer() && move < 9) {
                System.out.println("Ha vinto il giocatore X");
                game.setWin(1);
            } else {
                System.out.println("Pareggio");
                game.setWin(2);
            }

            game.newGame();
        } while(temp != 0);

    }
}
