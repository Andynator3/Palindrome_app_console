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
        outContent.reset();
    }

    @Test
    public void testPalindromeSimple() {
        // ÉTANT DONNÉ le mot palindrome "radar"
        // QUAND on appelle la méthode palindrome
        String result = ohce.palindrome("radar");

        // ALORS il retourne le mot inversé
        assertEquals("radar", result);

        // ET il affiche bonjour, bien dit, au revoir
        String output = outContent.toString();
        assertTrue(output.contains("Bonjour"));
        assertTrue(output.contains("radar"));
        assertTrue(output.contains("Bien dit !"));
        assertTrue(output.contains("Au revoir"));
    }

    @Test
    public void testNonPalindrome() {
        // ÉTANT DONNÉ un mot non palindrome "java"
        // QUAND on appelle la méthode palindrome
        String result = ohce.palindrome("java");

        // ALORS il retourne le mot inversé
        assertEquals("avaj", result);

        // ET il affiche bonjour et au revoir, mais pas "Bien dit !"
        String output = outContent.toString();
        assertTrue(output.contains("Bonjour"));
        assertTrue(output.contains("avaj"));
        assertFalse(output.contains("Bien dit !"));
        assertTrue(output.contains("Au revoir"));
    }

    @Test
    public void testPalindromeWithCase() {
        // ÉTANT DONNÉ un palindrome insensible à la casse "Kayak"
        // QUAND on appelle la méthode palindrome
        String result = ohce.palindrome("Kayak");

        // ALORS il retourne "kayaK"
        assertEquals("kayaK", result);

        // ET il reconnaît que c'est un palindrome
        String output = outContent.toString();
        assertTrue(output.contains("Bien dit !"));
    }

    @Test
    public void testEmptyString() {
        // ÉTANT DONNÉ une chaîne vide
        // QUAND on appelle la méthode palindrome
        String result = ohce.palindrome("");

        // ALORS il retourne une chaîne vide
        assertEquals("", result);

        // ET affiche "Bien dit !" car une chaîne vide est un palindrome
        String output = outContent.toString();
        assertTrue(output.contains("Bonjour"));
        assertTrue(output.contains("Bien dit !"));
        assertTrue(output.contains("Au revoir"));
    }
}

