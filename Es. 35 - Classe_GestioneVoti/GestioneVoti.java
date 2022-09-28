package com.company;

import java.io.IOException;
import java.util.Arrays;

public class GestioneVoti {
    private int numStudente;
    private Studente[] studenti;

    //Costruttore
    public GestioneVoti(int parametro) {
        numStudente = 0;
        studenti = new Studente[parametro];
    }

    public void inserisciStudente(String nome, float voto) throws Exception {
        if(numStudente < studenti.length) {
            try{
                checkNome(nome);
                studenti[numStudente] = new Studente(nome, voto);
                numStudente = numStudente + 1;
            }
            catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        } else {
            throw new Exception("Hai inserito tutti gli studenti");
        }
    }


    private void checkNome(String nome) throws Exception {
        int i = 0;
        boolean cond = true;
        if (numStudente != 0) {
            while (i < numStudente && cond) {
                if ((studenti[i].getNome()).equals(nome)) {
                    cond = false;
                    throw new Exception("Nome già inserito");
                }
                i = i + 1;
            }
        }
    }

    public boolean pieno(){
        boolean pieno;
        if((numStudente + 1) < studenti.length){
            pieno = false;
        } else {
            pieno = true;
        }
        return pieno;
    }

    public boolean vuoto(){
        boolean vuoto;
        if((numStudente + 1) < studenti.length){
            vuoto = true;
        } else {
            vuoto = false;
        }
        return vuoto;
    }


    public float leggiVoto(String nomeStudente) throws Exception{
        float voto = -1;
        int posizione;

        try{
            posizione = cercaPosStudente(nomeStudente);
            voto = studenti[posizione].getVoto();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return voto;
    }


    private int cercaPosStudente(String nomeStudente) throws Exception{
        if(numStudente > 0) {
            int i = 0;
            int posizione = 0;
            boolean found = false;

            while(i < numStudente && !found){
                if(studenti[i].getNome().equals(nomeStudente)){
                    found = true;
                    posizione = i;
                }
                i = i + 1;
            }

            if(!found){
                throw new IOException("Nome non trovato. Riprova!");
            } else {
                return posizione;
            }
        } else {
            throw new Exception("Non hai ancora inserito alcun valore");
        }
    }

    public float media()  throws Exception{
        if(numStudente > 0) {
            float media;
            float somma = 0;

            for(int i = 0; i < numStudente; i++){
                somma = somma + studenti[i].getVoto();
            }

            media = somma/(numStudente);
            return  media;
        } else {
            throw new Exception("Non hai ancora inserito alcun valore");
        }
    }


    public float votoMaggiore() throws Exception{
        if(numStudente > 0) {
            float maggiore = studenti[0].getVoto();

            for (int i = 1; i < numStudente; i++) {
                if (studenti[i].getVoto() > maggiore) {
                    maggiore = studenti[i].getVoto();
                }
            }
            return maggiore;
        } else {
            throw new Exception("Non hai ancora inserito alcun valore");
        }
    }


    public String stampaStudente(int nRegistro) throws Exception{
        int posizione = nRegistro - 1;
        if(posizione <= numStudente){
            return studenti[posizione].ToString();
        } else {
            throw new Exception("Posizione non valida!");
        }
    }

    public String stampaClasse() {
        String str = "";

        for(int i = 0; i < numStudente; i++){
            str = str + "Numero registro "+(i+1)+"\nNome: "+studenti[i].getNome()+"\nVoto: "+studenti[i].getVoto()+"\n---\n";
        }
        return str;
    }


    public void eliminaStudente(int nRegistro) throws Exception{
        int posizione = nRegistro - 1;
        if(posizione < numStudente){
            int i = posizione;
            while((i+1) < numStudente) {
                studenti[i].setVoto(studenti[i+1].getVoto());
                studenti[i].setNome(studenti[i+1].getNome());
                i = i + 1;
            }
            cancellaCella(i);
        } else if(nRegistro == numStudente){
            cancellaCella(posizione);
        } else {
            throw new Exception("Posizione non valida!");
        }
    }


    private void cancellaCella(int posizione){
        numStudente = numStudente - 1;
        studenti[posizione].pulisciVoto();
        studenti[posizione].setNome("");
    }


    public void modificaStudente(int nRegistro, String nome, float voto) throws Exception{
        int posizione = nRegistro - 1;

        try {
            studenti[posizione].setVoto(voto);
            studenti[posizione].setNome(nome);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
