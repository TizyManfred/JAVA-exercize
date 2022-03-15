package com.company;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
      
        System.out.print("Inserisci la base del primo rettangolo: ");
        float b1 = input.nextFloat();
      
        System.out.print("Inserisci l'altezza del primo rettangolo: ");
        float a1 = input.nextFloat();
      
        Rettangolo r1 = new Rettangolo();
        r1.setBase(b1);
        r1.setAltezza(a1);
      
        System.out.println("Il perimetro è: " + r1.perimetroCalcolo());
        System.out.println("L'area è: " + r1.areaCalcolo());
      
        System.out.print("Inserisci la base del secondo rettangolo: ");
        float b2 = input.nextFloat();
      
        System.out.print("Inserisci l'altezza del secondo rettangolo: ");
        float a2 = input.nextFloat();
      
        Rettangolo r2 = new Rettangolo();
        r2.setBase(b2);
        r2.setAltezza(a2);
      
        System.out.println("Il perimetro è: " + r2.perimetroCalcolo());
        System.out.println("L'area è: " + r2.areaCalcolo());
    }
}
