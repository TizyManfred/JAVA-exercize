package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numero1, numero2, somma;

        Scanner input;
        input = new Scanner(System.in);

        System.out.print("Inserisci il primo numero: ");
        numero1 = input.nextInt();
        System.out.print("Inserisci il secondo numero: ");
        numero2 = input.nextInt();

        somma = numero1 + numero2;
        System.out.print("la somma è: " + somma);
    }
}
