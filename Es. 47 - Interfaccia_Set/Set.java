public interface Set <T>{
    public void add(T element) throws Exception;
    public void remove(T element) throws Exception;
    public int cardinality();
    public boolean isEmpty();
    public boolean isIncluded(T element);
}
