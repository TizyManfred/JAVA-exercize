package com.company;

public class CompraNArticoliPrendiUnoGratis extends PoliticaSconto{
    public int n;

    public CompraNArticoliPrendiUnoGratis(int numeroArticoli, float prezzoArticolo, int n) {
        super(numeroArticoli, prezzoArticolo);
        this.n = n;
    }

    public float calcolaSconto(){
        float prezzoFinale;
        if (getNumeroArticoli() >= n){
            int i = getNumeroArticoli() - n;
            prezzoFinale = calcolaPrezzo() - getPrezzoArticolo();

            while(i >= n){
                prezzoFinale = prezzoFinale - getPrezzoArticolo();
                i = i - n;
            }
        } else {
            prezzoFinale = calcolaPrezzo();
        }
        return prezzoFinale;
    }

    @Override
    public String toString() {
        String str = super.toString()+"Il numero di articoli per qui uno ti viene regalato è "+n+"\nIl prezzo finale è: "+calcolaSconto();
        return str;
    }
}
