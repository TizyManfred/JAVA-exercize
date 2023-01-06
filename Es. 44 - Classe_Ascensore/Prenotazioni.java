public class Prenotazioni {
    private int numeroClienti;
    private int pianoDestinazione;
    private int pianoPartenza;

    public Prenotazioni(int numeroClienti, int pianoPartenza, int pianoDestinazione) {
        this.numeroClienti = numeroClienti;
        this.pianoDestinazione = pianoDestinazione;
        this.pianoPartenza = pianoPartenza;

    }

    public int getNumeroClienti() {
        return numeroClienti;
    }

    public int getPianoDestinazione() {
        return pianoDestinazione;
    }

    public int getPianoPartenza() {
        return pianoPartenza;
    }

    public String toString(){
        String str =  ""+numeroClienti+" persone hanno prenotato l'ascensore al "+pianoPartenza+" piano per andare al "+pianoDestinazione+" piano";
        return str;
    }
}
