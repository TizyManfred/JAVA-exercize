package com.company;

public abstract class PoliticaSconto {
    private int numeroArticoli;
    private float prezzoArticolo;

    public PoliticaSconto(int numeroArticoli, float prezzoArticolo) {
        this.numeroArticoli = numeroArticoli;
        this.prezzoArticolo = prezzoArticolo;
    }

    public abstract float calcolaSconto();

    public float calcolaPrezzo(){
        float prezzo;
        prezzo = getPrezzoArticolo() * getNumeroArticoli();
        return prezzo;
    }

    public int getNumeroArticoli() {
        return numeroArticoli;
    }

    public float getPrezzoArticolo() {
        return prezzoArticolo;
    }

    public String toString(){
        String str = "Hai acquistato: "+numeroArticoli+" articoli\nIl prezzo di ogni articolo è di: "+prezzoArticolo+" $\n";
        return str;
    }
}
