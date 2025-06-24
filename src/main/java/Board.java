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

}
