
import org.junit.Test;
import static org.junit.Assert.*;

public class SizeTestStudent {
    
    @Test
    public void testSmall() {
        Size size = Size.SMALL;
        assertEquals("Size should be SMALL", size, Size.SMALL);
    }
    
    @Test
    public void testMedium() {
        Size size = Size.MEDIUM;
        assertEquals("Size should be MEDIUM", size, Size.MEDIUM);
    }
    
    @Test
    public void testLarge() {
        Size size = Size.LARGE;
        assertEquals("Size should be LARGE", size, Size.LARGE);
    }
    
}
