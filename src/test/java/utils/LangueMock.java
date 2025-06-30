package utils;

import com.andynator.services.LangueService;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class LangueMock implements LangueService {
    private int appelSaluer = 0;
    private int appelFeliciter = 0;

    @Override
    public String saluer(LocalTime heure) {
        appelSaluer++;
        return "mock_saluation";
    }

    @Override
    public String feliciter() {
        appelFeliciter++;
        return "mock_felicitation";
    }

    public void verifier() {
        assertEquals(1, appelSaluer, "saluer() doit être appelé une seule fois");
        assertEquals(1, appelFeliciter, "feliciter() doit être appelé une seule fois si palindrome");
    }
}
