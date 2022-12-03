

public class GestoreVoti {

    private Studente[] studenti;
    private int nStudenti;

    GestoreVoti(int maxStud) {
        studenti = new Studente[maxStud];
        nStudenti = 0;
    }

    public void inseriscistudente(Studente stud) throws Exception{
        if (pieno()) {
            throw new Exception("Il numero massimo di studenti è stato raggiunto.");
        }
        for (int i = 0;i < nStudenti;i++) {
            if (stud.getNome().equals(studenti[i].getNome())) {
                throw new Exception("Lo studente esiste già.");
            }
        }
        studenti[nStudenti] = new Studente(stud);
        nStudenti++;

    }

    public double leggiVoto(String nome) throws Exception {
        double voto = -1;
        for (int i = 0;i < nStudenti;i++) {
            if (studenti[i].getNome().equals(nome)) {
                voto = studenti[i].getVoto();
            }
        }
        if (voto == -1) {
            throw new Exception("Nessuno studente trovato.");
        }
        return voto;
    }

    public double media() throws Exception{

        if (vuoto()) {
            throw new Exception("Non ci sono studenti.");
        }
        double media = 0;

        for (int i = 0;i < nStudenti;i++) {
            media += studenti[i].getVoto();
        }

        media /= nStudenti;

        return media;
    }

    public double votoMaggiore() throws Exception{
        if (vuoto()) {
            throw new Exception("Non ci sono studenti.");
        }
        double maxVoto = 3;
        for (int i = 0;i < nStudenti;i++) {
            if (studenti[i].getVoto() > maxVoto) {
                maxVoto = studenti[i].getVoto();
            }
        }
        return maxVoto;
    }

    public String stampaStudente(int indice) throws  Exception {
        validIndex(indice);
        return studenti[indice - 1].toString();
    }

    public void eliminaStudente(int indice) throws  Exception {
        validIndex(indice);
        studenti[indice - 1] = null;

        for(int j = indice; j < nStudenti; j++) {
            studenti[j - 1] = studenti[j];
        }

        studenti[nStudenti - 1] = null;
        nStudenti--;
    }

    public void modificastudente(double voto, int indice) throws Exception { //non credo cambi il nome
        validIndex(indice);
        studenti[indice - 1].setVoto(voto);
    }

    private void validIndex(int ind) throws Exception {
        if (ind > nStudenti || studenti[ind - 1] == null || ind < 1) {
            throw new Exception("Non esistono studenti a quell'indice");
        }
    }

    public String toString() {
        String str = "";
        if (!vuoto()) {
            for (int i = 0;i < nStudenti;i++) {
                str += studenti[i].toString() + "\n";
            }
        }
        else {
            str = "Non ci sono studenti.";
        }


        return str;
    }
    public boolean pieno() {
        boolean pieno = true;
        for (int i = 0;i < studenti.length && pieno;i++) {
            if (studenti[i] == null) {
                pieno = false;
            }
        }
        return pieno;
    }
    public boolean vuoto() {
        boolean vuoto = true;
        for (int i = 0;i < studenti.length && vuoto;i++) {
            if (studenti[i] != null) {
                vuoto = false;
            }
        }
        return vuoto;
    }

    public int getnStudenti() {
        return nStudenti;
    }

    public Studente[] getStudenti() {
        return studenti;
    }
}
