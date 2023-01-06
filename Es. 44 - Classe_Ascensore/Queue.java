public interface Queue <T>{
    abstract public void enqueue1(T element);
    abstract public void dequeue() throws Exception;
    abstract public int numElement();
}
