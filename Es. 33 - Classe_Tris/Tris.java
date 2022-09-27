package com.company;

import java.util.Random;

public class Tris {
    private char[][] tabellone = new char[3][3];
    private boolean giocatore;
    private boolean modalita;
    private int[] win;

    public Tris(boolean giocatore, boolean modalita) {
        this.giocatore = giocatore;
        this.modalita = modalita;
        this.win = new int[3];

        for(int i = 0; i < 3; ++i) {
            this.win[i] = 0;
        }

        this.newGame();
    }

    public int getWin(int i) {
        return this.win[i];
    }

    public boolean getPlayer() {
        return this.giocatore;
    }

    public boolean checkTris() {
        byte temp;
        if (this.giocatore) {
            temp = 79;
        } else {
            temp = 88;
        }

        return this.tabellone[0][0] == temp && this.tabellone[0][1] == temp && this.tabellone[0][2] == temp || this.tabellone[1][0] == temp && this.tabellone[1][1] == temp && this.tabellone[1][2] == temp || this.tabellone[2][0] == temp && this.tabellone[2][1] == temp && this.tabellone[2][2] == temp || this.tabellone[0][0] == temp && this.tabellone[1][0] == temp && this.tabellone[2][0] == temp || this.tabellone[0][1] == temp && this.tabellone[1][1] == temp && this.tabellone[2][1] == temp || this.tabellone[0][2] == temp && this.tabellone[1][2] == temp && this.tabellone[2][2] == temp || this.tabellone[0][0] == temp && this.tabellone[1][1] == temp && this.tabellone[2][2] == temp || this.tabellone[0][2] == temp && this.tabellone[1][1] == temp && this.tabellone[2][0] == temp;
    }

    public boolean getTable(int i, int j) {
        return this.tabellone[i][j] == 'X' || this.tabellone[i][j] == 'O';
    }

    public void setWin(int i) {
        int var10002 = this.win[i]++;
    }

    public boolean getModalita() {
        return this.modalita;
    }

    public void newGame() {
        for(int x = 0; x < 3; ++x) {
            for(int y = 0; y < 3; ++y) {
                this.tabellone[x][y] = '-';
            }
        }

    }

    public boolean move(int x, int y) {
        boolean mossaInserita = false;
        if (!this.isCellaOccupata(x, y) && this.isCellaValida(x, y)) {
            if (this.giocatore) {
                this.tabellone[x][y] = 'X';
                this.giocatore = false;
            } else {
                this.tabellone[x][y] = 'O';
                this.giocatore = true;
            }

            mossaInserita = true;
        }

        return mossaInserita;
    }

    private boolean isCellaOccupata(int x, int y) {
        boolean isOccupata;
        try {
            isOccupata = this.tabellone[x][y] != '-';
        } catch (Exception var5) {
            isOccupata = false;
        }

        return isOccupata;
    }

    private boolean isCellaValida(int x, int y) {
        return x <= 3 && y <= 3;
    }

    private void movePC() {
        for(int x = 0; x < 3; ++x) {
            for(int y = 0; y < 3; ++y) {
            }
        }

    }

    public void mossaRandom() {
        Random ran = new Random();
        boolean isValid = false;
        int x = false;
        boolean var4 = false;

        int x;
        int y;
        do {
            x = ran.nextInt(3);
            y = ran.nextInt(3);
            isValid = this.isCellaValida(x, y) && !this.isCellaOccupata(x, y);
        } while(!isValid);

        this.move(x, y);
    }

    public String toString() {
        char var10000 = this.tabellone[0][0];
        String table = "\tA\tB\tC\n1\t" + var10000 + "\t" + this.tabellone[0][1] + "\t" + this.tabellone[0][2] + "\n2\t" + this.tabellone[1][0] + "\t" + this.tabellone[1][1] + "\t" + this.tabellone[1][2] + "\n3\t" + this.tabellone[2][0] + "\t" + this.tabellone[2][1] + "\t" + this.tabellone[2][2];
        return table;
    }
}
