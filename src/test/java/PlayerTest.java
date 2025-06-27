import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    // test the method "getMarker"
    @Test
    public void testGetMarkerTrue(){
        Player player = new Player('X');
        assertEquals('X',player.getMarker());
    }
    @Test
    public void testGetMarkerFalse(){
        Player player = new Player('X');
        assertNotEquals('Y',player.getMarker());
    }

}
