package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	    float resto;
	    int numMoneteDueEuro, numMoneteUnEuro, numMoneteCinquantaCent, numMoneteVentiCent, numMoneteDieciCent, numMoneteCinqueCent, numMoneteDueCent, numMoneteUnCent;

	    final int dueEuro = 2;
        final int unEuro = 1;
        final float cinquantaCent = (float) 0.5;
        final float ventiCent = (float) 0.2;
        final float dieciCent = (float) 0.1;
        final float cinqueCent = (float) 0.05;
        final float dueCent = (float) 0.02;
        final float unCent = (float) 0.01;

        numMoneteDueEuro = 0;
        numMoneteUnEuro = 0;
        numMoneteCinquantaCent = 0;
        numMoneteVentiCent = 0;
        numMoneteDieciCent = 0;
        numMoneteCinqueCent = 0;
        numMoneteDueCent = 0;
        numMoneteUnCent = 0;

        Scanner input = new Scanner(System.in);

        //Input del resto
        System.out.print("Inserisci il resto: ");
        resto = input.nextFloat();

        /*
        if (resto % 2 == 0) {
            numMoneteUnCent = 1;
        }
        else {
            numMoneteUnCent = 0;
        }
         */

	   while (resto >= dueEuro) {
            resto = resto - dueEuro;
            numMoneteDueEuro = numMoneteDueEuro + 1;
       }

        while (resto >= unEuro) {
            resto = resto - unEuro;
            numMoneteUnEuro = numMoneteUnEuro + 1;
        }

        while (resto >= cinquantaCent) {
            resto = resto - cinquantaCent;
            numMoneteCinquantaCent = numMoneteCinquantaCent + 1;
        }

        while (resto >= ventiCent) {
            resto = resto - ventiCent;
            numMoneteVentiCent = numMoneteVentiCent + 1;
        }

        while (resto >= dieciCent) {
            resto = resto - dieciCent;
            numMoneteDieciCent = numMoneteDieciCent + 1;
        }

        while (resto >= cinqueCent) {
            resto = resto - cinqueCent;
            numMoneteCinqueCent  = numMoneteCinqueCent + 1;
        }

        while (resto >= dueCent) {
            resto = resto - dueCent;
            numMoneteDueCent = numMoneteDueCent + 1;
        }

        if (resto > 0) {
            resto = resto - unCent;
            numMoneteUnCent = numMoneteUnCent + 1;
        }

        System.out.println("Monete 2 € = " + numMoneteDueEuro);
        System.out.println("Monete 1 € = " + numMoneteUnEuro);
        System.out.println("Monete 0,50 € = " + numMoneteCinquantaCent);
        System.out.println("Monete 0,20 € = " + numMoneteVentiCent);
        System.out.println("Monete 0,10 € = " + numMoneteDieciCent);
        System.out.println("Monete 0,05 € = " + numMoneteCinqueCent);
        System.out.println("Monete 0,02 € = " + numMoneteDueCent);
        System.out.println("Monete 0,01 € = " + numMoneteUnCent);
        //System.out.println("Il resto è = " + resto);
}
}
