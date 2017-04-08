import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


public class JarTest {
    Jar jar ;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        jar= new Jar("Cats" , 5);
    }

    @Test
    public void fillingTheJarMakesTheNumberOfItemsInTheJarGreaterThan0() throws Exception {
        jar.fill();

        assertTrue(jar.getNumberOfitems()>0);
    }

    @Test
    public void choosingNumberHigherThanTheMaximumNumberOfItemsIsNotAllowed() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Your guess is too high");

        jar.applyGuess(6);


    }
    @Test
    public void choosingNumberLessThanOneIsNotAllowed()throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Your guess is too low");

        jar.applyGuess(0);
    }
    @Test
    public void guessingTheRightNumberOfItemsInTheJarReturnsTrue() throws  Exception {
        jar.fill();

        assertTrue(jar.applyGuess(jar.getNumberOfitems()));
    }

}