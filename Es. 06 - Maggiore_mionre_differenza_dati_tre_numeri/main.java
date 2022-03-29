package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float numero1, numero2, numero3, maggiore, minore, differenza;

        Scanner input;
        input = new Scanner(System.in);

        System.out.print("Inserisci il primo numero: ");
        numero1 = input.nextFloat();
        System.out.print("Inserisci il secondo numero: ");
        numero2 = input.nextFloat();
        System.out.print("Inserisci il terzo numero: ");
        numero3 = input.nextFloat();

        if(numero1>numero2 && numero1>numero3){
            maggiore = numero1;
            if(numero2>numero3){
                minore = numero3;
            }
            else{
                minore = numero2;
            }
        }
        else if(numero2>numero1 && numero2>numero3) {
            maggiore = numero2;
            if(numero1>numero3){
                minore=numero3;
            }
            else{
                minore = numero1;
            }
        }
        else if(numero3>numero1 && numero3>numero2){
            maggiore = numero3;
            if(numero1>numero2){
                minore = numero2;
            }
            else{
                minore = numero1;
            }
        }

        else if(numero1==numero2 && numero2==numero3){
            maggiore = numero1;
            minore = maggiore;
        }
        else if(numero1==numero2){
            if(numero1>numero3){
                maggiore = numero1;
                minore = numero3;
            }
            else{
                maggiore = numero3;
                minore = numero1;
            }
        }
        else if(numero1==numero3){
            if(numero1>numero2){
                maggiore = numero1;
                minore = numero2;
            }
            else{
                maggiore = numero2;
                minore = numero1;
            }
        }
        else if(numero2==numero3){
            if(numero2>numero1){
                maggiore = numero2;
                minore = numero1;
            }
            else{
                maggiore = numero1;
                minore = numero2;
            }
        }
        else{
            //lo asssegno a caso perchè il programma mi da dei problemi
            //comunque nelle condizioni precedenti ci sono tutte le possibili opzioni
            maggiore = numero1;
            minore = numero3;
        }


        System.out.println("Il maggiore è: "+maggiore);
        System.out.println("Il minore è: "+minore);

        differenza = maggiore - minore;
        System.out.print("La differenza è: " + differenza);
    }
}
