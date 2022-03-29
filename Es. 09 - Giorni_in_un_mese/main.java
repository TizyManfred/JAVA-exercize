package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        //Dichiarazione
        int giorni, mese, anno;
        Scanner input = new Scanner(System.in);

        //Input del mese
        System.out.print("Inserisci il mese: ");
        mese = input.nextInt();

        //Elaborazione
        //Controlle se il mese esiste
        while (mese <= 0 || mese > 13 ) {
            System.out.println("Mese errato. Riprova!");
            System.out.print("Inserisci il mese: ");
            mese = input.nextInt();
        }

    //costrutto di selezione multipla
    switch(mese){
        case 4:
        case 6:
        case 9:
        case 11:
            giorni = 30;
            break;

         case 2:
             //input anno
             System.out.print("Inserisci l'anno: ");
             anno = input.nextInt();

             //controllo se bisestile
             if (anno % 4 == 0){
                 if (anno % 100 == 0) {
                     if (anno % 400 == 0) {
                         giorni = 29;
                     } else {
                         giorni = 28;
                     }
                 }
                 else{
                     giorni = 29;
                 }
             }
             else{
                 giorni = 28;
             }

        default:
            giorni = 31;
            break;
         }

        //output del numero di giorni
        System.out.print("Il mese "+ mese +" ha "+ giorni);
    }
}
