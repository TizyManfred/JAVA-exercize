import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);

        String nomeAzienda, nomeReparto;
        int numDip, scelta, pos;
        float stipendio;
        boolean continua = true;

        System.out.println("Questo programma ha dei bug di funzionamento\n");

        System.out.print("Inserisci il nome dell'azienda: ");
        nomeAzienda = inputStr.nextLine();
        System.out.print("Inserisci il nome del reparto più in alto nella scala gerarchica: ");
        nomeReparto = inputStr.nextLine();
        do{
            System.out.print("Inserisci il numero dei dipendenti: ");
            numDip = input.nextInt();
        }while(numDip < 1);
        do{
            System.out.print("inserisci lo stipendio: ");
            stipendio = input.nextFloat();
        } while (stipendio <= 0);

        Reparto rep = new Reparto(nomeReparto, numDip, stipendio);

        Azienda azienda = new Azienda(nomeAzienda, rep);

        while(continua){
            do{
                System.out.println("\n\nMenù");
                System.out.println("---");
                System.out.println("1. Inserisci");
                System.out.println("2. Rimuovi");
                System.out.println("3. Mostra situazione");
                System.out.println("4. Leggi singolo valore");
                System.out.println("0. Esci");
                System.out.println("---");
                System.out.print("Inserisci la tua scelta: ");
                scelta = input.nextInt();
            } while (scelta < 0 || scelta > 4);

            switch (scelta){
                case 1: {
                    System.out.print("Inserisci il nome del reparto che vuoi inserire: ");
                    nomeReparto = inputStr.nextLine();
                    do{
                        System.out.print("Inserisci il numero dei dipendenti: ");
                        numDip = input.nextInt();
                    }while(numDip < 1);
                    do{
                        System.out.print("inserisci lo stipendio: ");
                        stipendio = input.nextFloat();
                    } while (stipendio <= 0);

                    rep = new Reparto(nomeReparto, numDip, stipendio);

                    if(azienda.numReparti() == 0){
                        azienda.add1(rep);
                    } else {
                        boolean avanti = false;

                        while(!avanti) {
                            System.out.print("Inserisci il numero identificativo della posizione di grado superiore: ");
                            pos = input.nextInt();
                            try {
                                TreeNode<Reparto> genitore = azienda.cerca(pos);
                                avanti = true;
                                azienda.add2(rep, genitore);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    break;
                }

                case 2: {
                    System.out.print("Inserisci il numero identificativo della posizione che vuoi andare a eliminare: ");
                    pos = input.nextInt();
                    try{
                        azienda.rimuovi(pos);
                        System.out.println("Posizione rimossa con successo");
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 3: {
                    System.out.println(azienda.toString());
                    break;
                }

                case 4: {
                    System.out.print("Inserisci il numero identificativo della posizione che vuoi andare a leggere: ");
                    pos = input.nextInt();
                    System.out.println(azienda.leggi(pos));
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
