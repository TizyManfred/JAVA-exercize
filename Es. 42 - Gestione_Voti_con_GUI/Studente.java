public class Studente {
    private  String nome;
    private double voto;

    Studente(String nome, double voto) throws Exception {

        this.nome = nome;
        setVoto(voto);
    }

    Studente(Studente stud) throws Exception{
        nome = stud.nome;
        setVoto(stud.voto);
    }

    public String getNome() {
        return nome;
    }

    public double getVoto() {
        return voto;
    }

    public void setVoto(double voto) throws Exception {

        if (voto < 3 || voto > 10) {
            throw new Exception("Voto non valido. ඞ");
        }
        this.voto = voto;
    }

    public String toString() {
        return "Nome: " + nome + " | Voto: " + voto;
    }
}
