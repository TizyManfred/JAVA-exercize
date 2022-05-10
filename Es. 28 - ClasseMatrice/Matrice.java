public class Matrice {
    public int righe;
    public int colonne;
    public int[][] matrix;

    //costruttore
    public Matrice(int righe, int colonne) {
        this.righe = righe;
        this.colonne = colonne;

        matrix = new int[righe][colonne];
        // valorizzaMatrice(0)
    }

    // Setta un valore specifico x ogni cella della matrice
    public void valorizzaMatrice(int num) {
        int x, y;
        for (x = 0; x < righe; x++) {
            for (y = 0; y < colonne; y++) {
                matrix[x][y] = num;
            }
            y = 0;
        }
    }

    // Data una riga ne somma tutti i suoi valori
    public int sommaRiga(int riga) {
        int somma = 0;

        for (int i = 0; i < colonne; i++) {
            somma = somma + matrix[riga][i];
        }

        return somma;
    }

    // Imposta per ogni riga sull'ultima cella la somma dei valori della riga
    public void impostaUltimoValoreSomma() {
        int sommaRiga;

        for (int i = 0; i < righe; i++) {
            sommaRiga = sommaRiga(i) - matrix[i][colonne - 1];
            matrix[i][colonne - 1] = sommaRiga;
        }
    }

    // Imposta a 1 ogni cella della matrice in diagonale
    public void settaDiagonale(int valoreDiagonale, int valoreMatrice) {
        valorizzaMatrice(valoreMatrice);

        if (righe == colonne) {
            for (int x = 0; x < righe; x++) {
                for (int y = 0; y < colonne; y++) {
                    if (x == y) {
                        matrix[x][y] = valoreDiagonale;
                    } else if (x == (colonne - y - 1)) {
                        matrix[x][y] = valoreDiagonale;
                    }
                }
            }
        }
    }

    // Restituisce il numero di righe della matrice
    public int getRighe() {
        return this.righe;
    }

    // Restituisce il numero di colonne della matrice
    public int getColonne() {
        return this.colonne;
    }

    // Restituisce la matrice
    public int[][] getMatrice() {
        return this.matrix;
    }

    // Dati due valori imposta il 1o come valore interno e il 2o come esterno
    public void cornice(int valoreCornice, int valoreInterno) {
        valorizzaMatrice(valoreInterno);

        for (int x = 0; x < righe; x++) {
            for (int y = 0; y < colonne; y++) {
                if (x == 0 || y == 0) {
                    matrix[x][y] = valoreCornice;
                } else if (x == (righe - 1) || y == (colonne - 1)) {
                    matrix[x][y] = valoreCornice;
                }
            }
        }
    }

    //trova il valore massimo all'interno della matrice
    int massimo() {
        int max;
        max = matrix[0][0];

        for (int x = 0; x < righe; x++) {
            for (int y = 0; y < colonne; y++) {
                if (matrix[x][y] > max) {
                    max = matrix[x][y];
                }

            }
        }

        return max;
    }

    // Restituisce il numero di cifre di un numero
    public int numeroCifre(int numero) {
        String numeroStringa;
        int numeroCifre;

        numeroStringa = Integer.toString(numero);
        numeroCifre = numeroStringa.length();

        return numeroCifre;
    }
}
