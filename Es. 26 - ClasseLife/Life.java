package com.company;

import java.util.Random;

public class Life {
    public static final int MAX_NEIGHBOUR_DISTANCE = 1;

    private boolean[][] grid;
    private int currentGeneration;

    // Costruttore principale
    public Life(int sizeX, int sizeY) {
        grid = new boolean[sizeY][sizeX];
        currentGeneration = 0;

        generateInitialRandom();
    }

    // Costruttore per griglia quadrata
    public Life(int size) {
        this(size, size);
    }

    private int countAliveNeighbours(int x, int y) {
        int alive = 0;

        for (int iy = y - MAX_NEIGHBOUR_DISTANCE; iy <= y + MAX_NEIGHBOUR_DISTANCE; iy++) {
            for (int ix = x - MAX_NEIGHBOUR_DISTANCE; ix <= x + MAX_NEIGHBOUR_DISTANCE; ix++) {
                if (!(ix == x && iy == y) && (ix >= 0 && ix < grid[0].length && iy >= 0 && iy < grid.length) && grid[iy][ix]) {
                    alive++;
                }
            }
        }

        return alive;
    }

    public void nextGeneration() {
        boolean[][] workGrid = new boolean[grid.length][grid[0].length];

        for (int iy = 0; iy < grid.length; iy++) {
            for (int ix = 0; ix < grid[iy].length; ix++) {
                int alive = countAliveNeighbours(ix, iy);
                if (getState(ix, iy)) {
                    if (alive <= 1) {
                        workGrid[iy][ix] = false;
                    } else {
                        workGrid[iy][ix] = alive == 2 || alive == 3;
                    }
                } else {
                    if (alive == 3) {
                        workGrid[iy][ix] = true;
                    }
                }
            }
        }

        currentGeneration++;
        grid = workGrid;
    }

    // Genera casualmente la prima generazione
    public void generateInitialRandom() {
        Random random = new Random();
        for (int iy = 0; iy < grid.length; iy++) {
            for (int ix = 0; ix < grid[iy].length; ix++) {
                grid[iy][ix] = random.nextBoolean();
            }
        }
    }

    //sovrascrive il metodo vecchio
    @Override
    public String toString() {
        String str = "";

        for (int iy = 0; iy < grid.length; iy++) {
            String subStr = "";
            for (int ix = 0; ix < grid[iy].length; ix++) {
                subStr += " " + (grid[iy][ix] ? "X" : " ") + " |";
            }

            str += subStr + "\n";
            for (int i = 0; i < subStr.length(); i++) {
                str += "-";
            }
            str += "\n";
        }
        return str;
    }

    //getter
    public boolean getState(int x, int y) {
        return grid[y][x];
    }

    public int getCurrentGeneration() {
        return currentGeneration;
    }

    public int getSizeX() {
        return grid[0].length;
    }

    public int getSizeY() {
        return grid.length;
    }

    //setter
    public void setState(int x, int y, boolean value) {
        grid[y][x] = value;
    }

}
