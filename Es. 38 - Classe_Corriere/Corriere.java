package com.company;

public class Corriere {
    //attributi
    private float[] kmPercorsi;
    private int ggAttuale;
    private int ggPeriodo;

    //costruttore
    public Corriere(int ggPeriodo) {
        if(ggPeriodo == 0){
            kmPercorsi = new float[30];
        } else {
            kmPercorsi = new float[ggPeriodo];
            ggAttuale = 0;
            this.ggPeriodo = ggPeriodo;
        }
    }

    //metodi
    public void inserisciKm(float km) throws Exception {
        if (km >= 0) {
            if (ggAttuale < ggPeriodo) {
                kmPercorsi[ggAttuale] = km;
                ggAttuale = ggAttuale + 1;
            } else {
                tieneMemoria(km);
            }
        } else {
            throw new Exception("Distanza percorsa non valida");
        }
    }


    private void tieneMemoria(float km){
        for (int i = 1; i < ggPeriodo; i++) {
            kmPercorsi[i - 1] = kmPercorsi[i];
        }
        kmPercorsi[ggPeriodo-1] = km;
    }

    public float totKm() throws Exception{
        if(ggAttuale != 0) {
            float somma = 0;
            for (int i = 0; i < ggAttuale; i++) {
                somma = somma + kmPercorsi[i];
            }
            return somma;
        } else {
            throw new Exception("Non hai inserito alcun valore");
        }
    }

    public float media() throws Exception{
        float media;
        if(ggAttuale == 0){
            throw new Exception("Impossibile calcolare la media! 0 valori inseriti");
        }else
            try {
                media = totKm()/ggAttuale;
            } catch (Exception e){
                throw new Exception(e.getMessage());
            }

        return media;
    }

    public float kmPercorsi(int gg) throws Exception{
        int posizione = gg - 1;
        if(posizione < 0){
            throw new Exception("Non puoi inserire valori minori di 0");
        } else if(posizione < ggAttuale){
            return kmPercorsi[posizione];
        } else {
            throw new Exception("Giorno non valido");
        }
    }

    public float maxDifferenza() throws Exception{
        if(ggAttuale != 0) {
            float scarto = max() - min();
            return scarto;
        } else {
            throw new Exception("Non hai  inserito alcun valore");
        }
    }

    private float max(){
        float maggiore = kmPercorsi[0];

        for(int i = 0; i < ggAttuale; i++){
            if(kmPercorsi[i] > maggiore){
                maggiore = kmPercorsi[i];
            }
        }
        return maggiore;
    }

    private float min(){
        float minore = kmPercorsi[0];

        for(int i = 0; i < ggAttuale; i++){
            if(kmPercorsi[i] < minore){
                minore = kmPercorsi[i];
            }
        }
        return minore;
    }

    public int getGGAttuale(){
        return ggAttuale;
    }

    public String toString(){
        String str = "";
        for(int i = 0; i < ggAttuale; i++){
            str = str + "Il " + (i+1) + "° giorno ha percorso " + kmPercorsi[i] + " km\n";
        }
        return str;
    }
}

