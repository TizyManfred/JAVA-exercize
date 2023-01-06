public class ListArray <T> implements List<T>{
    private int numElement;
    private T[] element;

    public ListArray(int posti) {
        numElement = 0;
        element = (T[])new Object[posti];
    }

    public void add(T c) {
        if(pieno()){
            doubleUp();
        }
        element[numElement] = c;
        numElement = numElement + 1;
    }

    private boolean pieno(){
        if(element.length == numElement){
            return true;
        } else {
            return false;
        }
    }

    private void doubleUp(){
        T[] arr = (T[])new Object[(element.length)*2];

        for(int i = 0; i < numElement; i++){
            arr[i] = element[i];
        }

        element = arr;
    }


    private void shift(int p){
        numElement = numElement - 1;
        for(int i = p; i < numElement; i++){
            element[i] = element[i+1];
        }
    }

    private boolean vuoto(){
        if(numElement == 0){
            return true;
        } else {
            return false;
        }
    }

    public void remove(int p) throws Exception{
        if(posizioneValida(p)){
            shift(p);
        } else {
            throw new Exception("Posizione non valida");
        }
    }

    private boolean posizioneValida(int pos){
        boolean valida;
        if(vuoto()){
            valida = false;
        } else if(pos >= numElement){
            valida = false;
        } else {
            valida = true;
        }
        return valida;
    }

    public int nElements(){
        return numElement;
    }

    public void change(int pos, T newElement) throws Exception{
        if(posizioneValida(pos)){
            element[pos] = newElement;
        } else {
            throw new Exception("Posizione non valida");
        }
    }

    public T read(int p) throws Exception{
        if(posizioneValida(p)){
            return element[p];
        } else {
            throw new Exception("Posizione non valida");
        }
    }


    public String toString(){
        String str = "";
        if(!vuoto()){
            for(int i = 0; i < numElement; i++){
                str = str + "Posizione numero "+(i+1)+": "+element[i].toString()+"\n";
            }
        } else {
            str = str+"Tutte le posizioni sono libere";
        }
        return  str;
    }
}
