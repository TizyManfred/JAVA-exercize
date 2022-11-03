package com.company;

public class Pentagono extends PoligoniRegolari{
    public Pentagono(float lunghezzaLati){
        super(5, lunghezzaLati);
    }

    public float area(){
        float area;
        float costante = 1.72f;
        area = (float)Math.pow(getLunghezzaLati(), 2)*costante;
        return area;
    }

    public float apotema(){
        float costante = 0.688f;
        return getLunghezzaLati()*costante;
    }

    @Override
    public Pentagono copy() {
        return new Pentagono(getLunghezzaLati());
    }

    @Override
    public String toString() {
        return super.toString()+"\nL'area è di "+area()+" cm^2\nL'apotema è: "+apotema()+" cm\n";
    }
}
