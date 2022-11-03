package com.company;

public class GestorePoligoni {
    private int numeroPoligoni;
    private PoligoniRegolari[] poligoni;

    public GestorePoligoni(int numeroMaxPoligoni) {
        numeroPoligoni = 0;
        poligoni = new PoligoniRegolari[numeroMaxPoligoni];
    }

    private boolean isPentagono(int pos) {
        return poligoni[pos] instanceof Pentagono;
    }

    private boolean isEsagono(int pos) {
        return poligoni[pos] instanceof Esagono;
    }


    public float stampaApotema(int pos) throws Exception{
        float apotema;
        if(isPentagono(pos)){
            apotema = ((Pentagono) poligoni[pos]).apotema();
        } else if(isEsagono(pos)){
            apotema = ((Esagono) poligoni[pos]).apotema();
        } else {
            throw new Exception("Impossibile stampare l'apotema di questo poligono");
        }
        return apotema;
    }



/*
    aggregazione lasca
    public void inserisciPoligono(PoligoniRegolari p) throws Exception{
        if(numeroPoligoni < poligoni.length){
            poligoni[numeroPoligoni] = p;
            numeroPoligoni = numeroPoligoni + 1;
        } else {
            throw new Exception("Non puoi più inserire poligoni!");
        }
    }

 */


    //aggregazione stretta
    public void inserisciPoligono(PoligoniRegolari p) throws Exception{
        if(numeroPoligoni < poligoni.length){
            poligoni[numeroPoligoni] = p.copy();
            numeroPoligoni = numeroPoligoni + 1;
        } else {
            throw new Exception("Non puoi più inserire poligoni!");
        }
    }

    public float area(int pos) throws Exception{
        float a;
        if(pos > 0 && pos <= numeroPoligoni){
            a = poligoni[pos-1].area();
        } else {
            throw new Exception("Posizione non valida!");
        }
        return a;
    }

    public float perimetro(int pos) throws Exception{
        float p;
        if(pos > 0 && pos <= numeroPoligoni){
            p = poligoni[pos-1].area();
        } else {
            throw new Exception("Posizione non valida!");
        }
        return p;
    }

    public String stampaValoriPoligono(int pos) throws Exception{
        String str;
        if(pos > 0 && pos <= numeroPoligoni){
            str = poligoni[pos-1].toString();
        } else {
            throw new Exception("Posizione non valida!");
        }
        return str;
    }

    public String toString(){
        String str = "";
        if(numeroPoligoni > 0){
            for(int i = 0; i < numeroPoligoni; i++) {
                str = str + "\n"+(i+1)+"° poligono\n" +poligoni[i].toString();
            }
        } else {
            throw new RuntimeException("Non hai inserito alcun valore!");
        }
        return str;
    }
}
