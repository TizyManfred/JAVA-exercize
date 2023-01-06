import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int nPiani, capacitaAscensore, scelta, persone, pianoPart, pianoArr;
        boolean continua = true;

        System.out.println("Inserimento dati ascensore");
        System.out.println("---");
        do{
            System.out.print("Inserisci il numero di piani: ");
            nPiani = input.nextInt();
        } while (nPiani < 1);
        do {
            System.out.print("Inserisci la capienza dell'ascensore: ");
            capacitaAscensore = input.nextInt();
        } while (capacitaAscensore < 1);

        Ascensore a = new Ascensore(nPiani, capacitaAscensore);

        while(continua){
            do{
                System.out.println("\n\nMenù funzionamento");
                System.out.println("---");
                System.out.println("1. Prenota");
                System.out.println("2. Muovi");
                System.out.println("3. Mostra situazione");
                System.out.println("0. Termina servizio");
                System.out.println("---");
                System.out.print("Inserisci la tua scelta: ");
                scelta = input.nextInt();
            } while (scelta < 0 || scelta > 3);

            switch (scelta){
                case 1: {
                    do{
                        System.out.print("Inserisci il numero di persone: ");
                        persone = input.nextInt();
                    } while (persone < 1);
                    do{
                        System.out.print("Inserisci il piano di partenza: ");
                        pianoPart = input.nextInt();
                    }while (pianoPart < 0 || pianoPart > (nPiani-1));
                    do{
                        System.out.print("Inserisci il piano d'arrivo: ");
                        pianoArr = input.nextInt();
                    }while (pianoArr < 0 || pianoArr > (nPiani-1));

                    Prenotazioni p = new Prenotazioni(persone, pianoPart, pianoArr);

                    a.prenota(p);
                    System.out.println("Prenotazione avvenuta con successo");
                    break;
                }
                case 2: {
                    System.out.println(a.muovi());
                    break;
                }
                case 3: {
                    System.out.println(a.toString());
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
