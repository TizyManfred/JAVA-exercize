package com.company;

public class Main {

    public static void main(String[] args) {
        Numeri elemento= new Numeri();
        elemento.inserisciNumero(10);
        elemento.inserisciNumero(20);
        elemento.inserisciNumero(30);

        //Stampa a video degl elementi dell'array
        System.out.println(elemento.toString());
        //Memorizza nel file prova.txt sovrascrivendo
        //elemento.memorizza();
        //Legge i dati dal file prova.txt e visualizza video
        elemento.leggi();

        elemento.inserisciNumero(100);
        //Memorizza nel file prova.txt senza sovrascrivere
        elemento.memorizzaSenzaSovrascrivere();
        System.out.println(elemento.toString());
        /*elemento.inserisciNumero(200);
        elemento.memorizzaSenzaSovrascrivere();
        System.out.println(elemento.toString());*/
    }
}
