package com.company;

public class Voli {
    private Cliente posti[];
    private Cliente attesa[];
    private int numPosti;
    private int numAttesa;

    /*
    public Voli(int maxPasseggeri) throws Exception{
        if(maxPasseggeri > 0) {
            posti = new Cliente[maxPasseggeri];
            attesa = new Cliente[maxPasseggeri];
            numPosti = 0;
            numAttesa = 0;
        } else {
            throw new Exception("Capienza non valida!\n Riprova!");
        }
    }

     */

    public Voli(int maxPasseggeri){
        posti = new Cliente[maxPasseggeri];
        attesa = new Cliente[maxPasseggeri];
        numPosti = 0;
        numAttesa = 0;
        }


    public void prenotaVolo(String nome) throws Exception{
        try{
            checkNome(nome);
            inserisciValore(nome);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void inserisciValore(String nome) throws Exception{
        if(numPosti == posti.length){
            if(numAttesa == attesa.length){
                throw new Exception("Impossibile confermare la prenotazione, tutti i posti sia quelli prenotati sia quelli in attesa sono prenotati");
            } else {
                attesa[numAttesa] = new Cliente(nome, false);
                numAttesa = numAttesa + 1;
            }
        } else {
            posti[numPosti] = new Cliente(nome, true);
            numPosti = numPosti + 1;
        }
    }

    private void checkNome(String nome) throws Exception {
        int i = 0;
        boolean cond = true;
        if (numPosti != 0) {
            if(numPosti == posti.length) {
                while (i < numPosti && cond) {
                    if ((posti[i].getNome()).equals(nome)) {
                        cond = false;
                        throw new Exception("Nome già inserito");
                    }
                    i = i + 1;
                }
                i = 0;
                while (i < numAttesa && cond) {
                    if ((attesa[i].getNome()).equals(nome)) {
                        cond = false;
                        throw new Exception("Nome già inserito");
                    }
                    i = i + 1;
                }
            } else {
                while (i < numPosti && cond) {
                    if ((posti[i].getNome()).equals(nome)) {
                        cond = false;
                        throw new Exception("Nome già inserito");
                    }
                    i = i + 1;
                }
            }
        }
    }

    public void cancellaPrenotazione(String nome) throws Exception{
        try {
            cancellaCella(trovaPosizione(nome));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void cancellaCella(int[] pos){
        int i;
        if(pos[1] == 0){
            if(pos[0] != numPosti){
                i = pos[0];
                while((i+1) < numPosti) {
                    posti[i].setNome(posti[i+1].getNome());
                    posti[i].setPrenotato(posti[i+1].getPrenotato());
                    i = i + 1;
                }
            }
            if(numAttesa == 0) {
                numPosti = numPosti - 1;
            } else {
                posti[numPosti-1].setNome(attesa[0].getNome());
                posti[numPosti-1].setPrenotato(attesa[0].getPrenotato());
                i = 0;
                while((i+1) < numAttesa) {
                    attesa[i].setNome(attesa[i+1].getNome());
                    attesa[i].setPrenotato(attesa[i+1].getPrenotato());
                    i = i + 1;
                }
                numAttesa = numAttesa - 1;
            }

        } else {
            if(pos[0] != numAttesa){
                i = pos[0];
                while((i+1) < numAttesa) {
                    attesa[i].setNome(attesa[i+1].getNome());
                    attesa[i].setPrenotato(attesa[i+1].getPrenotato());
                    i = i + 1;
                }
            }
            numAttesa = numAttesa - 1;
        }
    }

    private int[] trovaPosizione(String nome) throws Exception{
        int i = 0;
        boolean found = false;
        int[] pos = new int[2];

        while (i < numPosti && !found) {
            if ((posti[i].getNome()).equals(nome)) {
                found = true;
                pos[0] = i;
                pos[1] = 0;
            }
            i = i + 1;
        }

        if(numPosti == posti.length) {
            i = 0;
            while (i < numAttesa && !found) {
                if (attesa[i].getNome().equals(nome)) {
                    found = true;
                    pos[0] = i;
                    pos[1] = 1;
                }
                i = i + 1;
            }
        }

        if(!found){
            throw new Exception("Nome non trovato");
        } else {
            return pos;
        }
    }

    public int getNumPosti() {
        return numPosti;
    }

    public int getNumAttesa() {
        return numAttesa;
    }

    public String toString(){
        String str = "";
        for(int i = 0; i < numPosti; i++){
            str = str+"Prenotazione numero "+(i+1)+" ---> "+posti[i].toString()+"\n";
        }
        for(int i = 0; i < numAttesa; i++){
            str = str+"Prenotazione numero "+(i+1+numPosti)+" ---> "+attesa[i].toString()+"\n";
        }
        return str;
    }
}
