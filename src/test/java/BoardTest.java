import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    // test the method "isCellEmpty"
    @Test
    public void testCellemptyTrue(){
        Board board = new Board();
        assertEquals(' ', board.isCellEmpty(0,0));
    }

    @Test
    public void testCellemptyFalse(){
        Board board = new Board();
        board.place(0,0,'X');
        assertNotEquals('Y', board.isCellEmpty(0,0));
    }

}
