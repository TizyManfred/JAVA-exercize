package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numero1, numero2, scambio;

        Scanner input;
        input = new Scanner(System.in);

        System.out.print("Inserisci il primo numero: ");
        numero1 = input.nextInt();
        System.out.print("Inserisci il secondo numero: ");
        numero2 = input.nextInt();

        scambio = numero2;
        numero2 = numero1;
        numero1 = scambio;

        System.out.println("Il primo numero é: " + numero1);
        System.out.println("Il secondo numero è: "+ numero2);
    }
}
