package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float numero, doppio;

        Scanner input;
        input = new Scanner(System.in);

        System.out.print("Inserisci il numero: ");
        numero = input.nextFloat();

        doppio = numero *2;
        System.out.print("Il doppio è: " + doppio);
    }
}
