package com.company;

public class PromotriceConcerto {

    //attributi
    private String nomeGruppo;
    private int numeroBigliettiVenduti;
    private int numeroBigliettiRimanenti;
    private float ricavoTotale;


    //final rende il numero non modificabile
    private final float prezzoTelefono;
    private final float prezzoPosto;

    //costruttore
    public PromotriceConcerto(int numeroBigliettiRimanenti, float prezzoTelefono, float prezzoPosto){
        this.numeroBigliettiRimanenti = numeroBigliettiRimanenti;
        this.prezzoTelefono = prezzoTelefono;
        this.prezzoPosto = prezzoPosto;
    }

    //metodo che controlla se l'azione eseguibile dall'utente è fattibile
    public boolean azioneEseguibile(int num){
        boolean eseguibile;
        if (num <= numeroBigliettiRimanenti){
            eseguibile = false;
        } else {
            eseguibile = true;
        }

        return eseguibile;
    }

    //creazione array salvataggio biglietti
    int len = 10;
    private String [] nome = new String[len];
    private boolean [] telefono = new boolean[len];
    private int [] posti = new int[len];
    private int posizione = 0;

    //registra dati
    public void registra(String nomeGruppo, boolean tele, int num){
        nome[posizione] = nomeGruppo;
        posti[posizione] = num;
        telefono[posizione] = tele;

        posizione = posizione + 1;

        vendita(tele, num);
    }

    //modifica il metodo di acquisto del biglietto
    public void modificaStato(String name){
        int i = 0;
        boolean controllo = false;

        while (i <= posizione && controllo == false){
            if(name.equals(nome[i])){
                controllo = true;

                modificaRicavo(telefono[i], posti[i]);

                if (telefono[i]){
                    telefono[i] = false;
                } else {
                    telefono[i] = true;
                }
            }
            i = i + 1;
        }
    }

    //adegua il prezzo in base al cambiamento
    private void modificaRicavo (boolean telefono, int num){
        float sottrarre, sommare;

        if (telefono){
            sottrarre = num * prezzoTelefono;
            sommare = num * prezzoPosto;
        } else {
            sottrarre = num * prezzoPosto;
            sommare = num * prezzoTelefono;
        }

        ricavoTotale = ricavoTotale - sottrarre + sommare;
    }

    private void vendita(boolean telefono, int numVenduti){
        if (telefono) {
            venditeTelefono(numVenduti);
        } else {
            venditePosto(numVenduti);
        }
        biglietti(numVenduti);
    }

    private void venditeTelefono(int numeroBigliettiVendutiTelefono){
        float guadagno;
        guadagno = prezzoTelefono * numeroBigliettiVendutiTelefono;
        ricavoTotale = ricavoTotale + guadagno;
    }

    private void venditePosto(int numeroBigliettiVendutiTelefono){
        float guadagno;
        guadagno = prezzoPosto * numeroBigliettiVendutiTelefono;
        ricavoTotale = ricavoTotale + guadagno;
    }

    private void biglietti(int num){
        numeroBigliettiVenduti = numeroBigliettiVenduti + num;
        numeroBigliettiRimanenti = numeroBigliettiRimanenti - num;
    }


    //getter
    public int getNumeroBigliettiVenduti() {
        return numeroBigliettiVenduti;
    }

    public int getNumeroBigliettiRimanenti() {
        return numeroBigliettiRimanenti;
    }

    public float getRicavoTotale() {
        return ricavoTotale;
    }

}
