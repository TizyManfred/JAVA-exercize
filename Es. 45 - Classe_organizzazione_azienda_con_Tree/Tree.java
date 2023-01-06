public interface Tree<T> {
    public void add(T e, TreeNode<T> parent);
    public void remove(int number) throws Exception;
    public TreeNode<T> read(int pos) throws Exception;
    public int getNumNode();
}
