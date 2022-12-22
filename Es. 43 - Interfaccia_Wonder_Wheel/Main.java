import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        WonderWheelArray<Persona> ww = new WonderWheelArray<Persona>(8);
        Scanner input = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);

        boolean continua = true;
        int scelta, eta;
        String nome, cognome;

        while(continua){
            do{
                System.out.println("Menù");
                System.out.println("---");
                System.out.println("1. Inserisci una nuova persona sulla ruota");
                System.out.println("2. Rivuovi le persone dalla ruota");
                System.out.println("3. Conta il numero di persone sulla ruota");
                System.out.println("4. Vedi quale carrozza è in fondo");
                System.out.println("5. Vedi il contenuto della gabina in fondo");
                System.out.println("6. Vedi il contenuto di tutte le gabine");
                System.out.println("7. Ruota");
                System.out.println("0. Esci dal programma");
                System.out.println("---");
                System.out.print("Inserisci la tua scelta: ");
                scelta = input.nextInt();
            }while(scelta < 0 || scelta > 7);

            switch (scelta){
                case 1: {
                    System.out.print("Inserisci il tuo nome: ");
                    nome = inputStr.nextLine();
                    System.out.print("Inserisci il tuo cognome: ");
                    cognome = inputStr.nextLine();
                    System.out.print("Inserisci la tua età: ");
                    eta = input.nextInt();
                    Persona p1 = new Persona(nome, cognome, eta);

                    try {
                        ww.add(p1);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    try{
                        ww.remove();
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    System.out.println("Il numero delle carrozze piene sulla ruota sono: "+ww.numElement());
                    break;
                }
                case 4: {
                    System.out.println("la carrozza in fondo è la numero: "+ww.getBottom());
                    break;
                }
                case 5: {
                    try{
                        System.out.println(ww.read());
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 6: {
                    System.out.println(ww.toString());
                    break;
                }
                case 7: {
                    ww.rotation();
                    break;
                }
                case 0: {
                    System.out.println("Grazie e arrivederci");
                    continua = false;
                    break;
                }
            }
        }
    }
}
