import java.util.LinkedList;

public class LinkedSet<T> implements Set<T>{
    private LinkedList<T> elements;

    public LinkedSet() {
        elements = new LinkedList<T>();
    }

    public void add(T element) throws Exception{
        if(isIncluded(element)){
            throw new Exception("L'elemento è gia presente");
        } else {
            elements.add(element);
        }
    }

    public void remove(T element) throws Exception {
        if(isEmpty()){
            throw new Exception("Impossibile rimuovere l'elemento perche non è presente alcun elemento");
        } else if(isIncluded(element)){
            elements.remove(element);
        } else {
            throw new Exception("Impossibile rimuovere l'elemento perche non è presente");
        }
    }

    public boolean isIncluded(T element) {
        return elements.contains(element);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int cardinality() {
        return elements.size();
    }

    public String toString(){
        return elements.toString();
    }
}
