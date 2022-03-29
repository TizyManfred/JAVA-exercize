package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String targhe[];//dichiarazione delle variabili
        String modelli[];
        String nomi[];
        int scelta=0;
        int i;
        boolean exit=false;
        Scanner input=new Scanner(System.in);
        int len=100;
        int len_logica=0;
        targhe=new String[len];
        modelli=new String[len];
        nomi=new String[len];

        //creazione menù
        while (scelta !=4) {
            System.out.println("Buongiorno cosa si desidera fare");
            System.out.println("1)inserire dati sulle automobili(ATTENZIONE così facendo i dati inseriti in precedenza saranno sovrascritti)");
            System.out.println("2)ordina le liste per numero di targa");
            System.out.println("3)trova le macchine appartenenti a una determinata persone");
            System.out.println("4)uscire dal programma");
            System.out.print("cosa si desidera fare:");
            scelta= input.nextInt();
            switch (scelta){
                case 1:
                    len_logica=carica_array(targhe,modelli,nomi,len);
                    break;
                case 2:
                    if (riordina_lista(targhe,modelli,nomi,len_logica)){
                        System.out.println("Gli array sono stati ordinati con successo");
                    }
                    else {
                        System.out.println("spiacente devi prima caricare dei dati");
                    }
                    break;
                case 3:
                    System.out.println("inserisci il nome da cercare:");
                    String nome = input.nextLine();
                    int indici[]=new int[len_logica];
                    int logica_indici=cerca_proprietario(nomi,len_logica,nome,indici);
                    if (logica_indici==0){
                        System.out.println("nome assente");
                    }
                    else {
                        for (i=0;i<logica_indici;i++){
                            System.out.println((nome)+" possiede il modello "+(modelli[indici[i]])+" targato "+(targhe[indici[i]]));
                        }
                    }
                    break;
                case  4:
                    System.out.println("Grazie e arrivederci");
            }
        }
    }

    public static int cerca_proprietario(String[] n,int l,String  nome,int [] indici){
        int i=0;
        int j=0;
        for (i=0;i<l;i++){
            if (n[i].equals(nome)){
                indici[j]=i;
                j=j+1;
            }
        }
        
        return j;
    }
    

    public static int carica_array(String[] t,String[] m,String[] n,int len){
        Scanner input= new Scanner(System.in);
        int i;
        int l=len+1;
        while (l > len) {
            System.out.print("Quanti dati vuoi inserire (<=100):");
            l = input.nextInt();
        }
        for (i=0;i<l;i++){
            System.out.print("Inserisci la targa del " + (i + 1) + "° veicolo: ");
            t[i]=input.nextLine();
            System.out.print("Inserisci il modello del " + (i + 1) + "° veicolo: ");
            input= new Scanner(System.in);
            m[i]=input.nextLine();
            System.out.print("Inserisci il nome del proprietario del " + (i + 1) + "° veicolo: ");
            n[i]=input.nextLine();
        }
        return l;
    }

    public static boolean riordina_lista(String[] t,String[] m,String[] n,int l){
         boolean riordino;
        if (l==0){
            riordino=false;
            
        }
        else {
            int i = 0;
            int j = 0;
            String tmp_str;
            for (i=0;i < l;i++) {
                for (j=0;j < l;j++) {
                    if (t[j].compareTo(t[i]) < 0) {
                        tmp_str = t[i];
                        t[i] = t[j];
                        t[j] = tmp_str;

                        tmp_str=m[i];
                        m[i]=m[j];
                        m[j]=tmp_str;

                        tmp_str=n[i];
                        n[i]=n[j];
                        n[j]=tmp_str;
                    }
                }
            }
            riordino=true;
        }
        return riordino;
    }
}
