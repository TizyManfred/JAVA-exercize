package com.company;

public abstract class PoligoniRegolari {
    //attributi
    private int numeroLati;
    private float lunghezzaLati;


    public PoligoniRegolari(int numeroLati, float lunghezzaLati) {
        this.numeroLati = numeroLati;
        this.lunghezzaLati = lunghezzaLati;
    }
    /*
    //costruttore di copia
    public PoligoniRegolari(PoligoniRegolari p) {
        this.numeroLati = p.numeroLati;
        this.lunghezzaLati = p.lunghezzaLati;
    }


    //costruttore di copia 2
    public PoligoniRegolari(PoligoniRegolari p) {
        numeroLati = p.getNumeroLati();
        lunghezzaLati = p.getLunghezzaLati();
    }
     */
    public abstract PoligoniRegolari copy();

    public float perimetro(){
        float perimetro;
        perimetro = numeroLati * lunghezzaLati;
        return perimetro;
    }

    public abstract float area();

    public int getNumeroLati() {
        return numeroLati;
    }

    public float getLunghezzaLati() {
        return lunghezzaLati;
    }

    public String toString(){
        String str = "";
        str = "Il poligono ha "+numeroLati+" lati\nLa lunghezza del lato è di "+lunghezzaLati+" cm\nIl perimetro è di "+perimetro()+" cm";
        return str;
    }
}
