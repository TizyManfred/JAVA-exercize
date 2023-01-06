public class QueueArray<T> implements Queue <T>{
    private T[] element;
    private int numElement;

    public QueueArray(int max) {
        this.element = (T[])new Object[max];
        numElement = 0;
    }

    public void enqueue1(T nuovo){
        if(pieno()){
            doubleUp();
        }

        element[numElement] = nuovo;
        numElement = numElement + 1;
    }

    private void doubleUp(){
        T[] arr = (T[])new Object[element.length*2];
        for(int i = 0; i < numElement; i++){
            arr[i] = element[i];
        }
        element = arr;
    }

    private boolean vuoto(){
        if(numElement == 0){
            return true;
        } else {
            return false;
        }
    }

    private boolean pieno(){
        if(element.length == numElement){
            return true;
        } else {
            return false;
        }
    }

    public int numElement(){
        return numElement;
    }

    /*
    public void dequeue(int pos) throws Exception{
        try{
            posizioneValida(pos);
            shift(pos);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    private void posizioneValida(int pos) throws Exception {
        if (vuoto()) {
            throw new Exception("Non hai inserito alcun valore");
        } else {
            if (pos >= numElement) {
                throw new Exception("Posizione non valida");
            }
        }
    }
    */

    public T getContenuto(){
        return element[0];
    }

    private void shift(int pos){
        numElement = numElement - 1;
        if(numElement != 0){
            for (int i = pos; i < numElement; i++) {
                element[i] = element[i + 1];
            }
        }
    }


    public void dequeue() throws Exception {
        if(numElement > 0){
            shift(0);
        } else {
            throw new Exception("Posizione non valida");
        }
    }

    public int postiDisp(){
        return (element.length - numElement);
    }


    public String toString() {
        String str = "";
        for(int i = 0; i < numElement; i++){
            str = str+"Prenotazione attesa numero "+(i+1)+" ---> "+element[i].toString()+"\n";
        }
        return str;
    }
}
