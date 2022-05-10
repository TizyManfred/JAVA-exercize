package com.company;

public class Valutazione {
    //attributi
    private String nomeStudente;
    private int puntiEsercizio1;
    private int puntiEsercizio2;
    private int puntiIntermedio1;
    private int puntiIntermedio2;
    private int puntiFinale;
    private float media;
    private char votolettera;

    //costruttore
    public Valutazione(String nomeStudente, int puntiEsercizio1, int puntiEsercizio2, int puntiIntermedio1, int puntiIntermedio2, int puntiFinale) {
        this.nomeStudente = nomeStudente;
        this.puntiEsercizio1 = puntiEsercizio1;
        this.puntiEsercizio2 = puntiEsercizio2;
        this.puntiIntermedio1 = puntiIntermedio1;
        this.puntiIntermedio2 = puntiIntermedio2;
        this.puntiFinale = puntiFinale;
    }

    //metodi
    private int calcoloVotoEsercizi(int punti){
        int voto;
        voto = punti * 10;

        return voto;
    }

    public float mediaFinale(){
        int votoEsercizio1, votoEsercizio2, pesoEsercizi, pesoIntermedi, pesoFinale;
        float valutazioneGenEsercizi, valutazioneGenIntermedi, valutazioneGenFinale, sommaVotoEsercizi, sommaVotoIntermedi;

        pesoEsercizi = 25;
        pesoIntermedi = 25;
        pesoFinale = 50;

        votoEsercizio1 = calcoloVotoEsercizi(puntiEsercizio1);
        votoEsercizio2 = calcoloVotoEsercizi(puntiEsercizio2);
        sommaVotoEsercizi = (votoEsercizio1 + votoEsercizio2)/2;

        valutazioneGenEsercizi = calcoloPeso(pesoEsercizi, sommaVotoEsercizi);

        sommaVotoIntermedi = (puntiIntermedio1 + puntiIntermedio2)/2;
        valutazioneGenIntermedi = calcoloPeso(pesoIntermedi, sommaVotoIntermedi);

        valutazioneGenFinale = calcoloPeso(pesoFinale, puntiFinale);

        media = (valutazioneGenEsercizi + valutazioneGenIntermedi + valutazioneGenFinale);
        return media;
    }

    public char votoLettera(){
        if (media >= 60 && media <= 69){
            votolettera = 'D';
        } else if (media >= 70 && media <= 79){
            votolettera = 'C';
        } else if (media >= 80 && media <= 89){
            votolettera = 'B';
        } else if(media >= 90){
            votolettera = 'A';
        } else {
            votolettera = 'F';
        }
        return votolettera;
    }



    private float calcoloPeso(int peso, float punti){
        float risultato;

        risultato = (punti * peso)/100;

        return risultato;
    }

    public String toString(){
        String str;
        str = "Il nome dello studente: "+nomeStudente+"I punti totalizzati nell'esercizio 1 sono: "+puntiEsercizio1+"/10 \nI punti totalizzati nell'esercizio 2 sono : "+puntiEsercizio2+"/10 \nI punti totalizzati nell'intermedio 1 sono: "+puntiIntermedio1+"/100" +
                "\nI punti totalizzati nell'intermedio 2 sono: "+puntiIntermedio2+"/100 \nI punti totalizzati nella finale sono: "+puntiFinale+"/100 \n--- \nLa media pesata è : "+media+" \nIl voto in lettera è : "+votolettera;

        return str;
    }

    public char getVotolettera() {
        return votolettera;
    }
}
