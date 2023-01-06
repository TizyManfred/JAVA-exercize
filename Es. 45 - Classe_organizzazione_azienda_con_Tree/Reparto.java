public class Reparto {
    private String nome;
    private int numeroDipendenti;
    private float stipendio;

    public Reparto(String nome, int numeroDipendenti, float stipendio) {
        this.nome = nome;
        this.numeroDipendenti = numeroDipendenti;
        this.stipendio = stipendio;
    }
    public Reparto(Reparto rep){
        nome = rep.nome;
        numeroDipendenti = rep.numeroDipendenti;
        stipendio = rep.stipendio;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroDipendenti() {
        return numeroDipendenti;
    }

    public float getStipendio() {
        return stipendio;
    }

    public void setNumeroDipendenti(int numeroDipendenti) {
        this.numeroDipendenti = numeroDipendenti;
    }

    public void setStipendio(float stipendio) {
        this.stipendio = stipendio;
    }

    public String toString(){
        String str = "Il nome del reparto è: "+nome+"\nIl numero dei dipendenti che vi lavora al suo interno è: "+numeroDipendenti+"\nLo stipendio per le persone che lavorano in questo reparto è di: "+stipendio+" euro";
        return str;
    }
}
