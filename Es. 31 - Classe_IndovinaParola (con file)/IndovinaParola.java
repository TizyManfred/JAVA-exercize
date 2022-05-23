import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.io.*;
import java.net.URL;
import java.util.stream.Stream;

public class IndovinaParola {
    private String parolaDaIndovinare;
    private int numeroLettereParola;
    private int numeroTentetivi;
    private int numeroTentativiCorretti;
    private boolean parolaIndovinata;
    private char[] arrayParola;

    // private String[] arrayParole = {"ciao" , "domani" , "claudio" , "leonardo" , "cavallo" , "salame" , "cane" , "gatto" , "scuola" , "compiti" , "computer", "python" , "giacomo", "giuseppe"};
    private String[] arrayParole;

    // Costruttore - Ver. 1 (il chiamante passa la parola)
    public IndovinaParola(String parolaDaIndovinare) {
        this.parolaDaIndovinare = parolaDaIndovinare;
        creaArrayParola();
    }

    // Costruttore - Ver. 2 (la parola viene scelta casualmente)
    public IndovinaParola() {
        caricaParole();

        this.parolaDaIndovinare = parolaCasuale();
        creaArrayParola();
    }

    // Boolean - carica nell'array arrayParole le parole lette da un file
    public boolean caricaParole() {
        this.arrayParole = new String[numeroParoleFile()];
        boolean fileLetto = false;

        File fileLocation = new File("files/parole.txt");

        try {
            URL filePath = fileLocation.toURL();
            InputStream fileStream = filePath.openStream();

            BufferedReader fileBuffer = new BufferedReader(new InputStreamReader(fileStream));
            int i = 0;

            do {
                String parola = fileBuffer.readLine();
                this.arrayParole[i] = parola;

                i++;
            } while (i < numeroParoleFile());
        } catch (IOException e) {
            fileLetto = false;
        }

        return fileLetto;
    }

    private int numeroParoleFile() {
        int lineCount;
        int i = 0;

        File fileLocation = new File("files/parole.txt");

        try {
            URL filePath = fileLocation.toURL();
            InputStream fileStream = filePath.openStream();

            BufferedReader fileBuffer = new BufferedReader(new InputStreamReader(fileStream));

            String parola;

            do {
                i = i + 1;
                parola = fileBuffer.readLine();
            } while (parola != null);
        } catch (IOException e) {
            lineCount = -1;
        }

        lineCount = i;

        return lineCount;
    }

    // String - sceglie e restituisce una parola scelta casualmente tra quelle presenti
    public String parolaCasuale() {
        int numeroParole = arrayParole.length;
        int numeroParola = (int) ((Math.random() * numeroParole) + 0);

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
