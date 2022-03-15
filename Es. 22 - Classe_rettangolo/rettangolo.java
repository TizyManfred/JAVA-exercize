package com.company;

public class Rettangolo {
    private float base;
    private float altezza;

     //definizione di Costruttore vuoto
    public Rettangolo(){
        
    }
    
    //definizione di un costruttore parametrizzato
    public Rettangolo(float base, float altezza){
        //la prima base è quella della classe la seconda invece è quella del main
        this.base = base;
        this.altezza = altezza;
    }
    
    public float getBase() {
        return this.base;
    }

    public float getAltezza() {
        return this.altezza;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public void setAltezza(float altezza) {
        this.altezza = altezza;
    }

    public float perimetroCalcolo() {
        float perimetro = (this.base + this.altezza) * 2.0F;
        return perimetro;
    }

    public float areaCalcolo() {
        float area = this.base * this.altezza;
        return area;
    }

    public float getPerimetro() {
        return this.perimetroCalcolo();
    }

    public float getArea() {
        return this.areaCalcolo();
    }
}
