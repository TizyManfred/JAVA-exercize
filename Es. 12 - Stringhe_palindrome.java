package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int lunghezza, i;
        String originale, reverse = ""; // Objects of String class

        Scanner input;
        input = new Scanner(System.in);

        System.out.print("Inserisci una parola o una frase: ");
        originale = input.nextLine();

        lunghezza = originale.length();
        i = lunghezza - 1;

        for ( ; i >= 0; i-- )
            reverse = reverse + originale.charAt(i);
            if (originale.equals(reverse)) {
                System.out.println("La stringa è palindroma");
            }
            else {
                System.out.println("La stringa non è palindroma");
            }
    }
}
