public class Ascensore {
    private final int numeroPiani;
    private int pianoCorrente;
    private final int capacitaAscensore;
    private int personeCorrenti;
    private QueueArray<Prenotazioni> listaPrenotazioni;

    public Ascensore(int numeroPiani, int capacitaAscensore) {
        this.numeroPiani = numeroPiani;
        this.capacitaAscensore = capacitaAscensore;
        pianoCorrente = 0;
        personeCorrenti = 0;
        listaPrenotazioni = new QueueArray<Prenotazioni>(1);
    }

    public void prenota(Prenotazioni p){
        listaPrenotazioni.enqueue1(p);
    }

    private String entra(Prenotazioni p){
        String str;
        if((p.getNumeroClienti() + personeCorrenti) <= capacitaAscensore){
            personeCorrenti = personeCorrenti + p.getNumeroClienti();
            str = "Persone entrate con successo";
        } else {
            int personeEntrate = capacitaAscensore - personeCorrenti;
            personeCorrenti = capacitaAscensore;
            str = "Numero persone superiori alla capienza! \nSono state fatte entrare solo "+personeEntrate+" persone \nPer le persone restanti rieffettuare la prenotazione";
        }
        return str;
    }

    public String muovi(){
        Prenotazioni p = listaPrenotazioni.getContenuto();
        String str = "";

        if(pianoCorrente != p.getPianoPartenza()){
            str = str + "L'ascensore sta andando dal "+pianoCorrente+" al "+p.getPianoPartenza()+" piano";
            pianoCorrente = p.getPianoPartenza();
        }

        str = str +"\n"+ entra(p);

        str = str + "\nL'ascensore sta andando dal "+pianoCorrente+" al "+p.getPianoDestinazione()+" piano";
        pianoCorrente = p.getPianoDestinazione();

        str = str +"\nLe persone sono scese";
        personeCorrenti = personeCorrenti - p.getNumeroClienti();
        if(personeCorrenti < 0){
            personeCorrenti = 0;
        }

        try {
            listaPrenotazioni.dequeue();
        } catch (Exception ignored) {

        }

        return str;
    }

    @Override
    public String toString() {
        String str = "Stato ascensore\n---\nPersone in ascensore: "+personeCorrenti+"\nPiano ascensore: "+pianoCorrente+"\nCapacità ascensore: "+capacitaAscensore+"\nNumero piani ascensore: "+numeroPiani;
        str = str +"\n"+ listaPrenotazioni.toString();
        return str;
    }
}
