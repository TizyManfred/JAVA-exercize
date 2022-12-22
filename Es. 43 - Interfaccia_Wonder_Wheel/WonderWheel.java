public interface WonderWheel <T>{
    public abstract void add(T element) throws Exception;
    public abstract void remove() throws Exception;
    public abstract void rotation();
    public abstract int numElement();
    public abstract int getBottom();
}
