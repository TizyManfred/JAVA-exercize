package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int scelta, totStudenti, numRegistro = 0;
        float voto;
        String nome;
        boolean condizione = true;

        Scanner input = new Scanner(System.in);

        //istanziare l'oggetto
        do {
            System.out.print("Inserisci il numero degli studenti della classe: ");
            totStudenti = input.nextInt();
        } while(totStudenti <= 0);

        GestioneVoti classe = new GestioneVoti(totStudenti);

        while (condizione) {
            do {
                System.out.println("\nMenù:");
                System.out.println("---");
                System.out.println("1. Inserisci un nuovo studente");
                System.out.println("2. Leggere il voto di uno studente");
                System.out.println("3. Calcolare la media");
                System.out.println("4. Trovare il voto maggiore");
                System.out.println("5. Stampare i dati di uno studente");
                System.out.println("6. Eliminare i dati di uno studente");
                System.out.println("7. Modificare i dati di un studente");
                System.out.println("8. Sapere se sono stati inseriti tutti gli studenti della classe");
                System.out.println("9. Sapere se non è stato inserito alcun studente");
                System.out.println("10. Stampare il resoconto della classe");
                System.out.println("0. Esci");
                System.out.println("---");
                System.out.print("Inserisci la tua scelta: ");
                scelta = input.nextInt();
            } while (scelta < 0 || scelta > 10);

            switch (scelta) {
                case 1: {
                    try {

                        System.out.print("Inserisci il nome: ");
                        input = new Scanner(System.in);
                        nome = input.nextLine();
                        System.out.print("Inserisci il voto: ");
                        input = new Scanner(System.in);
                        voto = input.nextInt();
                        classe.inserisciStudente(nome, voto);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }

                case 2: {
                    System.out.print("Inserisci il nome dello studente che voi sapere il voto: ");
                    input = new Scanner(System.in);
                    nome = input.nextLine();

                    try {
                        System.out.println("Il voto dello studente è: "+classe.leggiVoto(nome));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }

                case 3: {
                    try {
                        System.out.println("La media è: "+classe.media());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }

                case 4: {
                    try {
                        System.out.println("Il voto maggiore è: "+classe.votoMaggiore());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }

                case 5: {
                    System.out.print("Inserisci il numero di registro dello studente che voi stampare: ");
                    input = new Scanner(System.in);
                    numRegistro = input.nextInt();

                    try {
                        System.out.println(classe.stampaStudente(numRegistro));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }

                case 6: {
                    boolean cond = true;
                    boolean continua = true;

                    while(continua) {
                        System.out.print("Inserisci il numero di registro dello studente che voi eliminare: ");
                        input = new Scanner(System.in);
                        numRegistro = input.nextInt();
                        System.out.println("---");

                        try {
                            String scelta1;
                            System.out.println(classe.stampaStudente(numRegistro));

                            do {
                                System.out.print("Sei sicuro di voler eliminare questo studente? (si/no) ");
                                input = new Scanner(System.in);
                                scelta1 = input.nextLine();
                            } while (!(scelta1.equals("si") || scelta1.equals("no")));

                            if (scelta1.equals("si")) {
                                try {
                                    classe.eliminaStudente(numRegistro);
                                    continua = false;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            } else {
                                do {
                                    System.out.print("Per uscire da questa modalità scrivi (esci) altrimenti scrivi (continua) per inserire un altro valore: ");
                                    input = new Scanner(System.in);
                                    scelta1 = input.nextLine();
                                }while (!(scelta1.equals("esci") || scelta1.equals("continua")));

                                if(scelta1.equals("esci")){
                                    continua = false;
                                }
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                }

                case 7: {
                    boolean cond = true;
                    boolean continua = true;

                    while(cond && continua) {
                        System.out.print("Inserisci il numero di registro dello studente che voi modificare: ");
                        input = new Scanner(System.in);
                        numRegistro = input.nextInt();
                        System.out.println("---");

                        try {
                            String scelta1;
                            System.out.println(classe.stampaStudente(numRegistro));

                            do {
                                System.out.print("Sei sicuro di voler modificare questo studente? (si/no) ");
                                input = new Scanner(System.in);
                                scelta1 = input.nextLine();
                            } while (!(scelta1.equals("si") || scelta1.equals("no")));

                            if (scelta1.equals("si")) {
                                cond = false;
                            } else {
                                do {
                                    System.out.print("Per uscire da questa modalità scrivi (esci) altrimenti scrivi (continua) per inserire un altro valore: ");
                                    input = new Scanner(System.in);
                                    scelta1 = input.nextLine();
                                }while (!(scelta1.equals("esci") || scelta1.equals("continua")));

                                if(scelta1.equals("esci")){
                                    continua = false;
                                }
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    if(!cond && continua) {
                        try {
                            System.out.print("Inserisci il nuovo nome: ");
                            input = new Scanner(System.in);
                            nome = input.nextLine();
                            System.out.print("Inserisci il nuovo voto: ");
                            input = new Scanner(System.in);
                            voto = input.nextInt();
                            classe.modificaStudente(numRegistro, nome, voto);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                }

                case 8: {
                    if(classe.pieno()) {
                        System.out.println("Hai inserito tutti gli studenti");
                    } else {
                        System.out.println("Non hai inserito tutti gli studenti");
                    }
                    break;
                }

                case 9: {
                    if(classe.vuoto()) {
                        System.out.println("Non hai inserito alcuno studente");
                    } else {
                        if(classe.pieno()) {
                            System.out.println("Hai inserito tutti gli studenti");
                        } else {
                            System.out.println("Non hai inserito tutti gli studenti");
                        }
                    }
                    break;
                }

                case 10: {
                    System.out.println(classe.stampaClasse());
                    break;
                }

                case 0: {
                    condizione = false;
                    System.out.println("Grazie e arrivederci");
                    break;
                }
            }
        }
    }
}
