package quentin.m;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testApp()  throws IOException
    {   
        
        App app = new App();
        App.sleepTime = 0;
        int[] terminalSize = app.getTerminalSize();
        assertEquals(app.printString(terminalSize, "this is a test"), true);
    }
}
