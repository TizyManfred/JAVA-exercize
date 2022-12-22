public class Persona {
    private String nome;
    private String cognome;
    private int età;

    public Persona(String nome, String cognome, int età) {
        this.nome = nome;
        this.cognome = cognome;
        this.età = età;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }


    public int getEtà() {
        return età;
    }

    public void setEtà(int età) {
        this.età = età;
    }

    public String toString(){
        String str = "";
        str = "\nIl nome è: "+nome+"\nIl cognome è: "+cognome+"\nL'età è: "+età;
        return str;
    }
}
