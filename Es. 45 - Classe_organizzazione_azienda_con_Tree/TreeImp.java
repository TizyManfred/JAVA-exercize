public class TreeImp <T> implements Tree<T>{
    private TreeNode<T> root;
    private int numNode;

    public TreeImp(T data){
        root = new TreeNode<>(data, null, 0);
        numNode = 0;
    }

    public void add(T e, TreeNode<T> parent) {
        numNode = numNode + 1;
        TreeNode<T> node = new TreeNode<>(e, parent, numNode);
        parent.addChildren(node);
    }

    public TreeNode<T> read(int pos) throws Exception {
        if(posizioneValida(pos)){
            throw new Exception("Posizione non valida");
        } else if(root.getNumber() == pos){
            return root;
        } else {
            TreeNode<T> nodo = root;
            TreeNode<T> corrente;



            for(int i = 0; i < numNode; i++){
                for(int j = 0; j < nodo.numChildren(); j++){
                    corrente = nodo.getChildren(j);
                    if(corrente.getNumber() == pos){
                        return corrente;
                    }
                }
                nodo = nodo.getChildren(i);
            }
        }
        throw new Exception("Posizione non trovata");
    }

    private boolean posizioneValida(int pos){
        if(pos < 0 || pos >= numNode){
            return false;
        } else {
            return true;
        }
    }

    public int getNumNode() {
        return numNode;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void remove(int pos) throws Exception {
        if(root.getNumber() == pos){
            throw new Exception("Impossibile eliminare il root");
        } else {
            TreeNode<T> nodo = root;
            TreeNode<T> corrente;

            for(int i = 1; i <= numNode; i++){
                for(int j = 0; j < nodo.numChildren(); j++){
                    corrente = nodo.getChildren(j);
                    if(corrente.getNumber() == pos){
                        corrente = null;
                        numNode = numNode - 1;
                    }
                }
                nodo = nodo.getChildren(i);
            }
        }
    }

    public String toString(){
        String str = "Livello 1: \n"+root.toString();
        TreeNode<T> nodo = root;
        TreeNode<T> corrente;

        for(int i = 1; i <= numNode; i++){
            str = str + "\nLivello "+(i+1)+": \n";
            for(int j = 0; j < nodo.numChildren(); j++){
                corrente = nodo.getChildren(j);
                str = str + corrente.toString();
            }
            nodo = nodo.getChildren(i);
        }
        return str;
    }
}
