public interface List<T> {
    public void add(T e);
    public void remove(int pos) throws Exception;
    public int nElements();
    public void change(int pos, T newElement) throws Exception;
    public T read(int pos) throws Exception;
}


