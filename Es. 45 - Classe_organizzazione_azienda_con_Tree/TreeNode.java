public class TreeNode<T> extends ListArray <T>{
    private T data;
    private int number;
    private TreeNode<T> parent;
    private ListArray<TreeNode<T>> children;

    public TreeNode(T data, TreeNode<T> parent, int number) {
        super(1);
        this.data = data;
        this.parent = parent;
        this.number = number;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public TreeNode<T> getChildren(int pos) {
        TreeNode<T> element;
        try {
            element = children.read(pos);
        } catch (Exception e){
            element = null;
        }
        return element;
    }

    public void addChildren(TreeNode<T> child) {
        children.add(child);
    }

    public int numChildren(){
        return children.nElements();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String toString(){
        if(parent == null && children == null){
            return "Dati: "+data+"\nNumero Identificativo: "+number+"\nNon ha alcun genitore(root)"+"\nE non ha alcun figlio";
        }else if(children == null){
            return "Dati: "+data+"\nNumero Identificativo: "+number+"\n"+parent.toString()+"\nNon ha alcun figlio";
        } else if (parent == null){
            return "Dati: "+data+"\nNumero Identificativo: "+number+"\nNon ha alcun genitore(root)"+"\n"+children.toString();
        } else {
            return "Dati: "+data+"\nNumero Identificativo: "+number+"\n"+parent.toString()+"\n"+children.toString();
        }
    }
}