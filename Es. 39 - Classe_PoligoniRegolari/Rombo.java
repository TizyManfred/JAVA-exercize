package com.company;

public class Rombo extends PoligoniRegolari{
    private float diagonale;

    public Rombo(float lunghezzaLati, float diagonale){
        super(4, lunghezzaLati);
        this.diagonale = diagonale;
    }

    public float area(){
        return (diagonale*calcoloDiagonale2())/2;
    }

    /*
    public float apotema(){
        return 2*area()/perimetro();
    }
     */

    private float calcoloDiagonale2(){
        float diagonale2;
        diagonale2 = (float) Math.sqrt(Math.pow(getLunghezzaLati(),2) - Math.pow(diagonale/2, 2))*2;
        return diagonale2;
    }

    public float getDiagonale() {
        return diagonale;
    }

    @Override
    public Rombo copy() {
        return new Rombo(getLunghezzaLati(), diagonale);
    }

    @Override
    public String toString() {
        if(diagonale > calcoloDiagonale2()) {
            return super.toString() + "\nL'area è di " + area() + " cm^2\nLa diagonale maggiore è lunga "+diagonale+"cm\nLa diagonale minore è lunga "+calcoloDiagonale2()+" cm\n";
        } else if (diagonale == calcoloDiagonale2()){
            return super.toString() + "\nL'area è di " + area() + " cm^2\nLe diagonali sono lunga "+calcoloDiagonale2()+"cm\n";
        } else {
            return super.toString() + "\nL'area è di " + area() + " cm^2\nLa diagonale maggiore è lunga "+calcoloDiagonale2()+"cm\nLa diagonale minore è lunga "+diagonale+" cm\n";
        }
    }
}

