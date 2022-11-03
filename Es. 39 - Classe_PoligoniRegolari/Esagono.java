package com.company;

public class Esagono extends PoligoniRegolari{
    public Esagono(float lunghezzaLati){
        super(6, lunghezzaLati);
    }

    public float area(){
        float area;
        float costante = 2.598f;
        area = (float)Math.pow(getLunghezzaLati(), 2)*costante;
        return area;
    }

    public float apotema(){
        float costante = 0.866f;
        return getLunghezzaLati()*costante;
    }

    @Override
    public Esagono copy() {
        return new Esagono(getLunghezzaLati());
    }

    @Override
    public String toString() {
        return super.toString()+"\nL'area è di "+area()+" cm^2\nL'apotema è: "+apotema()+" cm\n";
    }
}
