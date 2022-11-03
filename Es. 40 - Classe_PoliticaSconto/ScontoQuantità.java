package com.company;

public class ScontoQuantità extends PoliticaSconto{
    private int minimo;
    private float sconto;

    public ScontoQuantità(int numeroArticoli, float prezzoArticolo, int minimo, float sconto) {
        super(numeroArticoli, prezzoArticolo);
        this.minimo = minimo;
        this.sconto = sconto;
    }

    public float calcolaSconto(){
        float prezzoFinale;
        if(getNumeroArticoli() > minimo){
            prezzoFinale = calcolaPrezzo() * ((100 - sconto)/100);
        } else {
            prezzoFinale = calcolaPrezzo();
        }
        return prezzoFinale;
    }

    @Override
    public String toString() {
        String str = super.toString()+"Il numero minimo di articoli minimo da acquistare per avere lo sconto è di: "+minimo+" articoli\nLo sconto applicato è del: "+sconto+"%\nIl prezzo finale è: "+calcolaSconto();
        return str;
    }
}
