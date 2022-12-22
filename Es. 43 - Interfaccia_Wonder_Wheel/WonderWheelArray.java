public class WonderWheelArray <T> implements WonderWheel <T> {
    private T[] carriages;
    private int bottom;
    private boolean[] full;

    public WonderWheelArray(int maxValori) {
        this.bottom = 0;
        this.carriages = (T[])new Object[maxValori];
        full = new boolean[maxValori];
        for(int i = 0; i < maxValori; i++){
            full[i] = false;
        }
    }

    public void add(T element) throws Exception{
        if(!full[bottom]){
            carriages[bottom] = element;
            full[bottom] = true;
        } else {
            throw new Exception("La carrozza è gia piena");
        }
    }

    public void remove() throws Exception{
        if(!full[bottom]){
            throw new Exception("La carrozza è già vuota");
        } else {
            full[bottom] = false;
        }
    }

    public void rotation(){
        bottom=(bottom+1)%carriages.length;
    }

    public int numElement(){
        int num = 0;
        for(int i = 0; i < full.length; i++){
            if(full[i]){
                num = num + 1;
            }
        }
        return num;
    }

    public int getBottom(){
        return bottom+1;
    }
    public String toString(){
        String str="";
        for(int i = 0; i < carriages.length; i++){
            if(full[i]){
                str+="Carrozza numero "+(i+1)+": "+carriages[i].toString()+"\n ---\n";
            } else{
                str+="Carrozza numero "+(i+1)+ ": vuota \n ---\n";
            }
        }
        return str;
    }

    public T read() throws Exception{
        if(!full[bottom]){
            throw new Exception("La posizione è vuota");
        } else {
            return carriages[bottom];
        }

    }
}
