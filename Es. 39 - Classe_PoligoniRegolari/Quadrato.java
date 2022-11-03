package com.company;

public class Quadrato extends PoligoniRegolari{
    public Quadrato(float lunghezzaLati){
        super(4, lunghezzaLati);
    }

    public float area(){
        float lato = getLunghezzaLati();
        return lato*lato;
    }

    /*
    public float apotema(){
        return getLunghezzaLati()/2;
    }
    */

    @Override
    public Quadrato copy() {
        return new Quadrato(getLunghezzaLati());
    }

    @Override
    public String toString() {
        return super.toString()+"\nL'area è di "+area()+" cm^2\n";
    }
}
