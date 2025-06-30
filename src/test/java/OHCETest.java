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
    public void testPalindromeInFrench() {
        // ÉTANT DONNÉ un mot palindrome "radar" et la langue "fr"
        // QUAND on appelle palindrome
        String result = ohce.palindrome("radar", "fr");

        // ALORS il retourne "radar"
        assertEquals("radar", result);

        // ET les bons messages sont affichés
        String output = outContent.toString();
        assertTrue(output.contains("Bonjour"));
        assertTrue(output.contains("Bien dit !"));
        assertTrue(output.contains("Au revoir"));
    }

    @Test
    public void testNonPalindromeInFrench() {
        // ÉTANT DONNÉ un mot non palindrome "voiture" et la langue "fr"
        // QUAND on appelle palindrome
        String result = ohce.palindrome("voiture", "fr");

        // ALORS il retourne "erutiov"
        assertEquals("erutiov", result);

        // ET seul Bonjour et Au revoir sont affichés
        String output = outContent.toString();
        assertTrue(output.contains("Bonjour"));
        assertFalse(output.contains("Bien dit !"));
        assertTrue(output.contains("Au revoir"));
    }

    @Test
    public void testPalindromeInEnglish() {
        // ÉTANT DONNÉ un palindrome "madam" et la langue "en"
        // QUAND on appelle palindrome
        String result = ohce.palindrome("madam", "en");

        // ALORS il retourne "madam"
        assertEquals("madam", result);

        // ET les messages sont affichés en anglais
        String output = outContent.toString();
        assertTrue(output.contains("Hello"));
        assertTrue(output.contains("Well said!"));
        assertTrue(output.contains("Goodbye"));
    }

    @Test
    public void testNonPalindromeInEnglish() {
        // ÉTANT DONNÉ un mot non palindrome "world" et la langue "en"
        // QUAND on appelle palindrome
        String result = ohce.palindrome("world", "en");

        // ALORS il retourne "dlrow"
        assertEquals("dlrow", result);

        // ET les bons messages sont affichés
        String output = outContent.toString();
        assertTrue(output.contains("Hello"));
        assertFalse(output.contains("Well said!"));
        assertTrue(output.contains("Goodbye"));
    }

    @Test
    public void testEmptyInput() {
        // ÉTANT DONNÉ une chaîne vide et la langue "fr"
        // QUAND on appelle palindrome
        String result = ohce.palindrome("", "fr");

        // ALORS il retourne une chaîne vide
        assertEquals("", result);

        // ET "Bien dit !" est affiché (car vide = palindrome)
        String output = outContent.toString();
        assertTrue(output.contains("Bonjour"));
        assertTrue(output.contains("Bien dit !"));
        assertTrue(output.contains("Au revoir"));
    }

    @Test
    public void testDefaultToFrenchIfLangUnknown() {
        // ÉTANT DONNÉ un mot palindrome et une langue inconnue "de"
        // QUAND on appelle palindrome
        String result = ohce.palindrome("radar", "de");

        // ALORS les messages sont en français par défaut
        String output = outContent.toString();
        assertTrue(output.contains("Bonjour"));
        assertTrue(output.contains("Bien dit !"));
        assertTrue(output.contains("Au revoir"));
    }
}

