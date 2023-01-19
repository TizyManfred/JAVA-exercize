package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    boolean continua = true;
        int scelta;
        Integer numero;
        String parola;

        Scanner input = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);
        LinkedSet<Object> set = new LinkedSet<Object>();

        while(continua){
            do {
                System.out.println("Menu");
                System.out.println("---");
                System.out.println("1. Inserisci");
                System.out.println("2. Rimuovi");
                System.out.println("3. Numero elementi");
                System.out.println("4. Contenuto");
                System.out.println("5. Stampa");
                System.out.println("0. Esci");
                System.out.println("---");
                System.out.print("Inserisci la tua scelta: ");
                scelta = input.nextInt();
            } while (scelta < 0 || scelta > 5);

            switch (scelta){
                case 1: {
                    do{
                        System.out.println("\nMenu inserisci");
                        System.out.println("---");
                        System.out.println("1. Intero");
                        System.out.println("2. Stringa");
                        System.out.println("---");
                        System.out.print("Inserisci la tua scelta: ");
                        scelta = input.nextInt();
                    } while (scelta < 1 || scelta > 2);

                    switch (scelta){
                        case 1: {
                            System.out.print("Inserisci il numero: ");
                            numero = input.nextInt();
                            try {
                                set.add(numero);
                            } catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                        case 2: {
                            System.out.print("Inserisci una stringa: ");
                            parola = inputStr.nextLine();
                            try {
                                set.add(parola);
                            } catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                    }
                    break;
                }


                case 2: {
                    do{
                        System.out.println("\nMenu rimuovi");
                        System.out.println("---");
                        System.out.println("1. Intero");
                        System.out.println("2. Stringa");
                        System.out.println("---");
                        System.out.print("Inserisci la tua scelta: ");
                        scelta = input.nextInt();
                    } while (scelta < 1 || scelta > 2);

                    switch (scelta){
                        case 1: {
                            System.out.print("Inserisci il numero: ");
                            numero = input.nextInt();
                            try {
                                set.remove(numero);
                            } catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                        case 2: {
                            System.out.print("Inserisci una stringa: ");
                            parola = inputStr.nextLine();
                            try {
                                set.remove(parola);
                            } catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                    }
                    break;
                }


                case 3: {
                    System.out.println("Il set contiene "+set.cardinality()+" elementi");
                    break;
                }


                case 4: {
                    do{
                        System.out.println("\nMenu cerca");
                        System.out.println("---");
                        System.out.println("1. Intero");
                        System.out.println("2. Stringa");
                        System.out.println("---");
                        System.out.print("Inserisci la tua scelta: ");
                        scelta = input.nextInt();
                    } while (scelta < 1 || scelta > 2);

                    switch (scelta){
                        case 1: {
                            System.out.print("Inserisci il numero: ");
                            numero = input.nextInt();
                            if(set.isIncluded(numero)){
                                System.out.println("Il numero è presente");
                            } else {
                                System.out.println("Il numero non è presente");
                            }
                            break;
                        }
                        case 2: {
                            System.out.print("Inserisci una stringa: ");
                            parola = inputStr.nextLine();
                            if(set.isIncluded(parola)){
                                System.out.println("La parola è presente");
                            } else {
                                System.out.println("la parola non è presente");
                            }
                            break;
                        }
                    }
                    break;
                }


                case 5: {
                    System.out.println("Gli elementi presenti nel set sono: \n"+set.toString());
                    break;
                }


                case 0: {
                    System.out.println("Grazie e arrivederci");
                    continua = false;
                    break;
                }
            }
            System.out.println("\n");
        }
    }
}
