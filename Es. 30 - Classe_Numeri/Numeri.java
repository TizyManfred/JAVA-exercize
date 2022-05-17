package com.company;

import java.io.*;
import java.net.URL;

public class Numeri {
    private int[] numeri;
    private int nElementi;

    public Numeri() {
        this.numeri = new int[5];
        this.nElementi = 0;
    }

    //**** METODO CHE PERMETTE DI INSERIRE UN NUMERO NELL'ARRAY
    public boolean inserisciNumero(int numero){
        boolean registrato= false;
        try{
            numeri[nElementi]= numero;
            nElementi++;
            registrato= true;
        }
        catch(Exception e){
            registrato= false;
        }

        return registrato;
    }

    public String toString(){
        String output= "";

        for(int i=0;i<nElementi;i++){
            output= output + numeri[i] + "\n";
        }

        return output;
    }

    //*** Memorizza gli elementi dell'array nel file prova.txt sovrascrivendo
    public boolean memorizza(){
        boolean memorizzato= false;

        try
        {
            FileOutputStream prova = new FileOutputStream("file/prova.txt");
              /*
              effettuiamo così il collegamento logico tra il file e l'operazione
              di scrittura, generando l'oggetto scrivi.
              */
            PrintStream scrivi = new PrintStream(prova);
            for(int i=0;i<nElementi;i++)
            {
                scrivi.println(numeri[i]+";");
            }
        }
        catch (IOException e)
        {
            memorizzato= false;
        }
        return memorizzato;
    }

    //*** Memorizza gli elementi dell'array nel file prova.txt senza sovrascrivere
    public boolean memorizzaSenzaSovrascrivere(){
        boolean memorizzato= false;

        String path = "file/prova.txt";

        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for(int i=0;i<nElementi;i++)
            {
                bw.write(numeri[i] +";"+"\n");
            }
            bw.flush();
            bw.close();
        }
        catch(IOException e) {
            memorizzato= false;
        }

        return memorizzato;
    }


    //*** Legge dal file prova.txt e visualizza video gli elementi
    public boolean leggi(){
        boolean letto= false;

        // definizione il percorso al file da leggere
        File doc= new File("file/prova.txt");
        /*
        La classe Url() funge da rappresentazione di un Uniform Resource Locator
        che può essere un qualsiasi punto in cui è reperibile una risorsa;
        grazie ad essa l'applicazione localizza il file da passare in lettura.
        */
        URL path=null;

        try
        {
            // mostriamo il percorso al file
            path=doc.toURL();
            System.out.println("Il doc si trova nel percorso" + path);

            //mostriamo il nome del file
            doc= new File(path.getFile());
            System.out.println("Nome del file " + doc);
            String riga;

            // apriamo lo stream di input...
            InputStream is=path.openStream();
            /*
            BufferedReader() serve per la lettura del flusso di dati,
            questa classe legge un stringa di testo sulla base di uno stream di
            input formato da caratteri; attraverso ciò che viene letto dalla
            classe, l'applicazione proporrà in output tutti i caratteri che sono
            passati per il flusso di dati, cioè il contenuto del file.
            */
            BufferedReader br= new BufferedReader(new InputStreamReader(is));

            // ...e avviamo la lettura del file con un ciclo
            do
            {
                riga= br.readLine();
                System.out.println(riga);
            }
            while (riga!=null);
            is.close();
            letto= true;
        }

        // intercettiamo eventuali eccezioni
        catch (IOException e)
        {
            letto= false;
        }

        return letto;
    }
}
