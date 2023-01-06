public class Azienda {
    private String nome;
    private TreeImp<Reparto> gerarchia;

    public Azienda(String nome, Reparto rep) {
        this.nome = nome;
        Reparto dir = new Reparto(rep);
        gerarchia = new TreeImp<>(dir);
    }

    public void add1(Reparto rep){
        if(gerarchia.getNumNode() == 1){
            gerarchia.add(rep, gerarchia.getRoot());
        }
    }

    public void add2(Reparto rep, TreeNode<Reparto> livSup){
        gerarchia.add(rep, livSup);
    }

    public String toString(){
        String str = "Nome azienda: "+nome+"\nOrganizzazione: \n"+gerarchia.toString();
        return str;
    }

    public void rimuovi(int numeroIdentificativo) throws Exception{
        try{
            gerarchia.remove(numeroIdentificativo);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public int numReparti(){
        return gerarchia.getNumNode();
    }

    public TreeNode<Reparto> cerca(int pos) throws Exception{
        try {
            return gerarchia.read(pos);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public String leggi(int numeroIdentificativo){
        String str = "";
        try{
            str = str + (gerarchia.read(numeroIdentificativo)).toString();
        } catch (Exception e){
            str = str + e.getMessage();
        }
        return str;
    }
}
