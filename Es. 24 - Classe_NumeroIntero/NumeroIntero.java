package com.company;

public class NumeroIntero {
    private int numero;

    //costruttore
    public NumeroIntero (int numero){
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    boolean pari (){
        boolean pari;
        if (numero%2 == 0){
            pari = true;
        } else {
            pari = false;
        }
        return pari;
    }

    void aggiungi (int agg) {
        numero = numero + agg;
    }

    void togli (int dec) {
        numero = numero - dec;
    }

    boolean primo () {
        boolean prime;
        boolean flag = false;

        for (int i = 2; i <= numero / 2; ++i) {
            if (numero % i == 0) {
                flag = true;
                break;
            }
        }

        if (flag == false) {
            prime = true;
        } else {
            prime = false;
        }
        return prime;
    }

    int cifreNumero() {
        int c = 0;

        while (numero > 0) {
            numero = numero / 10;
            c = c + 1;
        }
        return c;
    }

    int [] separa(){
        int [] num;
        num = new int[cifreNumero()];

        int i = 0;

        while(numero > 0){
            num[i] = numero % 10;
            numero = numero / 10;
            i = i + 1;
        }
        return num;
    }

    String stampa(){
        int i = 0;
        int n, len;
        String s;

        String [] mappaValori;
        mappaValori = new String[] {"Zero ", "Uno ", "Due ", "Tre ", "Quattro ", "Cinque ", "Sei ", "Sette ", "Otto ", "Nove "};

        StringBuilder numeroStr = new StringBuilder();

        len = cifreNumero();
        if (len > 1) {
            int[] num;
            num = new int[len];
            num = separa();

            while (i < cifreNumero()){
                n = num[i];
                s = mappaValori[n];
                numeroStr.append(s);
                i = i + 1;
            }

        } else {
            n = numero;
            s = mappaValori[n];
            numeroStr.append(s);
        }

        return numeroStr.toString();
    }
}
