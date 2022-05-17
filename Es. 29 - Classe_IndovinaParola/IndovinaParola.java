import java.util.Arrays;

public class IndovinaParola {
    private String parolaDaIndovinare;
    private int numeroLettereParola;
    private int numeroTentetivi;
    private int numeroTentativiCorretti;
    private boolean parolaIndovinata;
    private char[] arrayParola;

    private String[] arrayParole = {"ciao" , "domani" , "claudio" , "leonardo" , "cavallo" , "salame" , "cane" , "gatto" , "scuola" , "compiti" , "computer", "python" , "giacomo", "giuseppe"};


    // Costruttore - Ver. 1 (il chiamante passa la parola)
    public IndovinaParola(String parolaDaIndovinare) {
        this.parolaDaIndovinare = parolaDaIndovinare;
        creaArrayParola();
    }

    // Costruttore - Ver. 2 (la parola viene scelta casualmente)
    public IndovinaParola() {
        this.parolaDaIndovinare = parolaCasuale();
        creaArrayParola();
    }

    // String - sceglie e restituisce una parola scelta casualmente tra quelle presenti
    public String parolaCasuale() {
        int numeroParole = arrayParola.length;
        int numeroParola = (int) ((Math.random() * (numeroParole - 0)) + 0);

        return arrayParole[numeroParola];
    }

    // Void - Crea l'array di partenza con n caselle quante le lettere della parola
    private void creaArrayParola() {
        int numeroLettere = parolaDaIndovinare.length();
        this.numeroLettereParola = numeroLettere;

        arrayParola = new char[numeroLettere];

        for (int i = 0; i < numeroLettere; i++) {
            arrayParola[i] = '?';
        }
    }

    // Void - Controlla se il carattere passato dal chiamante è contenuto nella parola
    public void indovina(String lettera) {
        int i;
        // boolean trovato = false;
        char lettera2 = lettera.charAt(0);

        numeroTentetivi = numeroTentetivi + 1;

        for (i = 0; i < numeroLettereParola; i++) {
            if (lettera2 == parolaDaIndovinare.charAt(i)) {
                arrayParola[i] = lettera2;
                // trovato = true;

                numeroTentativiCorretti = numeroTentativiCorretti + 1;
            }
        }

        parolaIndovinata();
    }

    // Void - Verifica se la parola è stata indovinata completamente
    public void parolaIndovinata() {
        int i;
        for (i = 0; i < numeroLettereParola; i++) {
            if (arrayParola[i] != '?') {
                parolaIndovinata = true;
            } else {
                parolaIndovinata = false;
            }
        }
    }

    public String getParolaScoperta() {
        return arrayParola.toString();
    }

    public String getParolaDaIndovinare() {
        return this.parolaDaIndovinare;
    }

    public int getNumeroTentetivi() {
        return this.numeroTentetivi;
    }

    public boolean isIndovinata() {
        return this.parolaIndovinata;
    }

    @Override
    public String toString() {
        return Arrays.toString(arrayParola);
    }
}
