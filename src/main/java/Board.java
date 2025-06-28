public class Board {

    //#########################################################################
    // variables
    private char[][] cells;


    //#########################################################################
    // Constructor
    public Board() {
        cells = new char[3][3];
        clear();
    }

    //#########################################################################
    //methods

    // clear the board
    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    // print the board
    public void print() {
        System.out.println("Current board:");
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
    }

    // check if the cell is empty
    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    // place a character on the given cell
    public void place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            cells[x][y] = marker;
        } else {
            System.out.println("Cell is already occupied.");
        }
    }

}
