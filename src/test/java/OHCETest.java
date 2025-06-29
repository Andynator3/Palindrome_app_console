import static org.junit.jupiter.api.Assertions.*;

import com.andynator.OHCE;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OHCETest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private OHCE ohce;

    @BeforeEach
    public void setUp() {
        // ÉTANT DONNÉ une instance d’OHCE
        ohce = new OHCE();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testPalindromeDetection() {
        // ÉTANT DONNÉ une entrée palindrome "radar"

        // QUAND on appelle la méthode palindrome
        String result = ohce.palindrome("radar");

        // ALORS le mot inversé est identique
        assertEquals("radar", result);

        // ET le texte "Bonjour", "Bien dit !" et "Au revoir" apparaissent dans la sortie
        String output = outContent.toString().trim();
        assertTrue(output.contains("Bonjour"));
        assertTrue(output.contains("Bien dit !"));
        assertTrue(output.contains("Au revoir"));
    }

    @Test
    public void testNonPalindrome() {
        // ÉTANT DONNÉ une entrée non palindrome "bonjour"

        // QUAND on appelle la méthode palindrome
        String result = ohce.palindrome("bonjour");

        // ALORS le mot inversé est "ruojnob"
        assertEquals("ruojnob", result);

        // ET "Bien dit !" ne doit pas apparaître
        String output = outContent.toString().trim();
        assertTrue(output.contains("Bonjour"));
        assertFalse(output.contains("Bien dit !"));
        assertTrue(output.contains("Au revoir"));
    }

    @Test
    public void testEmptyString() {
        // ÉTANT DONNÉ une chaîne vide

        // QUAND on appelle la méthode palindrome
        String result = ohce.palindrome("");

        // ALORS la sortie retournée est aussi vide
        assertEquals("", result);

        // ET le message "Bien dit !" est affiché
        String output = outContent.toString().trim();
        assertTrue(output.contains("Bonjour"));
        assertTrue(output.contains("Bien dit !")); // chaîne vide = palindrome
        assertTrue(output.contains("Au revoir"));
    }

    @Test
    public void testCaseInsensitivePalindrome() {
        // ÉTANT DONNÉ une entrée palindrome avec majuscules/minuscules "Kayak"

        // QUAND on appelle la méthode palindrome
        String result = ohce.palindrome("Kayak");

        // ALORS la chaîne retournée est "kayaK"
        assertEquals("kayaK", result);

        // ET "Bien dit !" est bien affiché
        String output = outContent.toString().trim();
        assertTrue(output.contains("Bien dit !"));
    }
}

