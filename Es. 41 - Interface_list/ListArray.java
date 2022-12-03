public class ListArray implements List{
    private int pos;
    private int[] array;

    public ListArray() {
        pos = 0;
        array = new int[10];
    }

    public void add(int ele){
        if(pos == array.length){
            doubleUp();
        }
        array[pos] = ele;
        pos = pos + 1;
    }

    private void doubleUp(){
        int[] arr = new int[pos*2];

        for(int i = 0; i < pos; i++){
            arr[i] = array[i];
        }

        array = arr;
    }
    private void shift(int p){
        pos = pos - 1;
        for(int i = p; i < pos; i++){
            array[i] = array[i+1];
        }
    }

    private void vuoto() throws Exception{
        if(pos == 0){
            throw new Exception("L'array è vuoto");
        }
    }

    public void remove(int p) throws Exception{
        try {
            vuoto();
            if (p > 0 && p <= pos) {
                shift(p-1);
            } else {
                throw new Exception("Posizione non valida");
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public int nElements(){
        return pos;
    }

    public void change(int position, int newElement) throws Exception{
        try{
            vuoto();
            array[position] = newElement;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public int read(int p) throws Exception{
        try{
            return array[p];
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public String toString(){
        String str = "<html>";
        try{
            vuoto();
            str = str + "Gli elementi sono: <br>";
            for(int i = 0; i < pos; i++){
                str = str + "Posizione "+(i+1)+": "+array[i]+"<br>";
            }
        } catch (Exception e){
            str = str + "La lista è vuota";
        }
        str = str + "</html>";
        return  str;
    }

}
