package example;//#########################################################################
// imports
import java.util.Scanner;


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


    //#########################################################################
    //methods

    //start the game
    public void start() {
        //local variables
        Scanner scanner = new Scanner(System.in);
        boolean continueGame = true;

        //gamestart
        while (continueGame) {
            board.clear();
            currentPlayer = player1;
            System.out.println("Spiel gestartet!");
            board.print();

            while (true) {
                System.out.println("Spieler (" + currentPlayer.getMarker() + ") ist am Zug.");
                int x, y;

                // loop the input till a vaild move was made
                while (true) {

                    System.out.print("Gib Zeile (0–2) ein: ");
                    x = scanner.nextInt();
                    System.out.print("Gib Spalte (0–2) ein: ");
                    y = scanner.nextInt();

                    if (x >= 0 && x < 3 && y >= 0 && y < 3) {
                        if (board.isCellEmpty(x, y)) {
                            board.place(x, y, currentPlayer.getMarker());
                            break;
                        } else {
                            System.out.println("Dieses Feld ist bereits belegt. Versuch es erneut.");
                        }
                    } else {
                        System.out.println("Ungültige Eingabe. Werte müssen zwischen 0 und 2 liegen.");
                    }

                }

                // show the current board state
                board.print();
                // check if the currentplayer has won
                if (hasWinner()) {
                    System.out.println("Spieler (" + currentPlayer.getMarker() + ") hat gewonnen!");
                    break;
                }
                // check if the board is full
                if (board.isFull()) {
                    System.out.println("Unentschieden!");
                    break;
                }
                // switch the current player
                switchCurrentPlayer();
            }

            // ask the players if they want to play again
            String antwort;
            while (true) {
                System.out.print("Möchtest du nochmal spielen? (j/n): ");
                antwort = scanner.next().trim().toLowerCase();
                // check players answer
                if (antwort.equals("j")) {
                    break;
                } else if (antwort.equals("n")) {
                    continueGame = false;
                    System.out.println("Spiel beendet.");
                    break;
                } else {
                    System.out.println("Ungültige Eingabe. Bitte nur 'j' oder 'n' eingeben.");
                }
            }

        }

        scanner.close();
    }


    // switch the current player
    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }


    // check if the current player has won
    private boolean hasWinner() {
        char m = currentPlayer.getMarker();

        // win combinations
        int[][][] kombis = {
                {{0, 0}, {0, 1}, {0, 2}},
                {{1, 0}, {1, 1}, {1, 2}},
                {{2, 0}, {2, 1}, {2, 2}},
                {{0, 0}, {1, 0}, {2, 0}},
                {{0, 1}, {1, 1}, {2, 1}},
                {{0, 2}, {1, 2}, {2, 2}},
                {{0, 0}, {1, 1}, {2, 2}},
                {{0, 2}, {1, 1}, {2, 0}}
        };

        for (int[][] kombi : kombis) {
            int x1 = kombi[0][0], y1 = kombi[0][1];
            int x2 = kombi[1][0], y2 = kombi[1][1];
            int x3 = kombi[2][0], y3 = kombi[2][1];

            if (!board.isCellEmpty(x1, y1) &&
                    !board.isCellEmpty(x2, y2) &&
                    !board.isCellEmpty(x3, y3)) {

                // placing on an occupied field will fail therefore is a marker here
                Board test = new Board();
                test.clear();
                test.place(x1, y1, m);
                test.place(x2, y2, m);
                test.place(x3, y3, m);

                if (test.isCellEmpty(x1, y1) &&
                        test.isCellEmpty(x2, y2) &&
                        test.isCellEmpty(x3, y3)) {
                    return true;
                }
            }
        }

        return false;
    }
}
