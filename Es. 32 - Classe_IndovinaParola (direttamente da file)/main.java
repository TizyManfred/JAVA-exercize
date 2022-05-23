import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);

        int modalitaGioco;

        System.out.println("Gioco dell'impiccato");
        System.out.println("--------------------");
        System.out.println("Seleziona modalita' di gioco:");
        System.out.println("     1. Parola generata casualmente.");
        System.out.println("     2. Parola inserita dall'utente.");
        System.out.print("Opzione scelta: ");
        modalitaGioco = input.nextInt();

        if(modalitaGioco == 1) {
            IndovinaParola indovinaParola = new IndovinaParola();

            do {
                System.out.println(indovinaParola.toString());

                System.out.print("Inserisci la lettera: ");
                String lettera = stringInput.next();

                indovinaParola.indovina(lettera);
            } while (!indovinaParola.isIndovinata());

            System.out.println("Hai vinto :)");
        } else {
            System.out.print("Inserisci la parola con cui giocare: ");
            String parola = stringInput.next();

            IndovinaParola indovinaParola = new IndovinaParola(parola);

            do {
                System.out.println(indovinaParola.toString());

                System.out.print("Inserisci la lettera: ");
                String lettera = stringInput.next();

                indovinaParola.indovina(lettera);
            } while (!indovinaParola.isIndovinata());

            System.out.println("Hai vinto :)");
        }
    }
}
