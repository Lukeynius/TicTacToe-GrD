public class TicTacToe {

    //#########################################################################
    // variables
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;


    //#########################################################################
    // Constructor
    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

}
