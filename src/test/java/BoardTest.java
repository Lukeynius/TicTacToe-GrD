import example.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    // test the method "isCellEmpty"
    @Test
    public void testCellemptyTrue(){
        Board board = new Board();
        assertTrue(board.isCellEmpty(0,0));
    }

    @Test
    public void testCellemptyFalse(){
        Board board = new Board();
        board.place(0,0,'X');
        assertFalse(board.isCellEmpty(0,0));
    }


    // test the method "isFull"
    @Test
    public void testFullTrue(){
        Board board = new Board();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board.place(i,j,'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testFullFalse(){
        Board board = new Board();
        assertFalse(board.isFull());
    }

}
