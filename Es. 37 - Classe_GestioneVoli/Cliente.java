package com.company;

public class Cliente {
    private String nome;
    private boolean prenotato;

    public Cliente(String nome, boolean prenotato) {
        this.nome = nome;
        this.prenotato = prenotato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getPrenotato() {
        return prenotato;
    }

    public void setPrenotato(boolean prenotato) {
        this.prenotato = prenotato;
    }


    public String toString() {
        String str;
        if(prenotato) {
            str = "Nome: "+nome + " ---> Stato prenotazione: prenotato";
        } else {
            str = "Nome: "+nome+" ---> Stato prenotazione: in attesa";
        }
        return str;
    }
}
