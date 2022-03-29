package com.company;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int giorni, mese, anno, aggiungi, annoAgg, giorniFineAnno;
        String  giorniAggStr, meseAggStr, condStr;

        Scanner input = new Scanner(System.in);

        System.out.print("Inserisci il giorni: ");
        giorni = input.nextInt();

        System.out.print("Inserisci il mese: ");
        mese = input.nextInt();

        System.out.print("Inserisci l'anno: ");
        anno = input.nextInt();

        Data data1 = new Data(giorni, mese, anno);

        input = new Scanner(System.in);
        System.out.print("Voi aggiungere dei giorni (si/no): ");
        condStr = input.nextLine();

        if (condStr.equals("si")){
            input = new Scanner(System.in);

            System.out.print("Inserisci il numero di giorni da aggiungere: ");
            aggiungi = input.nextInt();

            data1.aggiungiG(aggiungi);

            giorniAggStr = data1.getGGStr();
            meseAggStr = data1.getMMStr();
            annoAgg = data1.getAAAgg();

            System.out.println("Il numero di giorni aggiornato: "+ giorniAggStr+"/"+meseAggStr+"/"+annoAgg);
        }

        giorniFineAnno = data1.fineAnno();
        System.out.println("Mancano "+giorniFineAnno+" all'anno nuovo");
    }

}
