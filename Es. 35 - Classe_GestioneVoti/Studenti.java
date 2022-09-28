package com.company;

public class Studente {
    //attributi
    private String nome;
    private float voto;

    //costruttore
    public Studente(String nome, float voto) throws Exception {
        this.nome = nome;
        setVoto(voto);
    }

    //setter
    public void setVoto(float voto) throws Exception {
        if((voto > 0 && voto < 10) || (voto == 10)){
            this.voto = voto;
        } else {
            throw new Exception("Il voto non è valido");
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //getter
    public String getNome() {
        return nome;
    }

    public float getVoto() {
        return voto;
    }

    //metodi
    public void pulisciVoto(){
        voto = 0;
    }

    //tostring
    public  String ToString(){
        return "Lo studente di nome " + nome + " ha ottenuto il voto " + voto;
    }

}
