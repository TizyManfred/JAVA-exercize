public interface List {
    public void add(int e);
    public void remove(int p) throws Exception;
    public int nElements();
    public void change(int index, int newElement) throws Exception;
    public int read(int index) throws Exception;
}
