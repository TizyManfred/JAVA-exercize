package com.company;

import java.util.Scanner;
import java.lang.Math;

/*
import java.util.ArrayList;
import java.util.List;
*/

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int len, resto;
        double numero1, numero2;
        boolean [] num1;
        boolean [] num2;

        System.out.print("Inserisci la lunghezza: ");
        len = input.nextInt();

        num1 = new boolean[len];
        num2 = new boolean[len];

        System.out.println("Numero 1");
        caricamentoInput(num1, len);

        System.out.println("Numero 2");
        caricamentoInput(num2, len);

        numero1 = binToDec(num1, len);
        System.out.println("Il primo numero è: "+ numero1);

        numero2 = binToDec(num2, len);
        System.out.println("Il secondo numero è: "+ numero2);

        System.out.println("Il MCD è: "+MCD(numero1, numero2));

    }


    public static void caricamentoInput(boolean a[], int valori) {
        Scanner input = new Scanner(System.in);

        int i, temp;
        i = 0;

        while (i < valori){
            System.out.print("Inserisci il numero binario: ");
            temp = input.nextInt();
            while (temp != 0 && temp != 1){
                System.out.print("Inserisci il numero binario: ");
                temp = input.nextInt();
            }

            if (temp == 0) {
                a[i] = false;
            } else if (temp == 1){
                a[i] = true;
            }
            i = i + 1;
        }
    }

    public static double binToDec(boolean n1[], int val){
        int i = 0;
        int x;
        double temp, numero1;

        x = val - 1;
        numero1 = 0;

        while(i<val){
            if (n1[i] == true){
                temp = Math.pow(2, x);
            } else {
                temp = 0;
            }

            numero1 = numero1 + temp;

            x = x - 1;
            i = i + 1;
        }
        return numero1;
    }


    public static double MCD(double num1, double num2){
        double max, min, resto;

        if (num1 > num2) {
            max = num1;
            min = num2;
        } else {
            max = num2;
            min = num1;
        }

        resto = max % min;

        while(resto != 0 && resto != 1){
            resto = min % resto;

        }

        if(resto == 0){
            resto = min;
        }

        return resto;
    }
}
