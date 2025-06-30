import com.andynator.config.Expression;
import org.junit.jupiter.api.Test;
import utils.DetectionDePalindromeBuilder;
import utils.LangueMock;
import utils.LangueSpy;
import utils.LangueStub;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DetectionDePalindromeTest {

    @Test
    void palindrome_affiche_felicitations() {
        var dp = DetectionDePalindromeBuilder
                .avecLangue(new LangueStub("Salut", "Bravo"))
                .avecHeure(10, 0)
                .construire();

        String result = dp.inverser("radar");

        String attendu = "Salut" + System.lineSeparator()
                + "radar" + System.lineSeparator()
                + "Bravo" + System.lineSeparator()
                + Expression.ACQUITTANCE;

        assertEquals(attendu, result);
    }

    @Test
    void non_palindrome_ne_donne_pas_de_felicitations() {
        var dp = DetectionDePalindromeBuilder
                .avecLangue(new LangueStub("Bonjour", "Bravo"))
                .avecHeure(15, 0)
                .construire();

        String result = dp.inverser("bonjour");

        String attendu = "Bonjour" + System.lineSeparator()
                + "ruojnob" + System.lineSeparator()
                + Expression.ACQUITTANCE;

        assertEquals(attendu, result);
    }

    @Test
    void langue_est_appellee_avec_heure_exacte() {
        LangueSpy spy = new LangueSpy();

        var dp = DetectionDePalindromeBuilder
                .avecLangue(spy)
                .avecHeure(8, 30)
                .construire();

        dp.inverser("radar");

        assertEquals(LocalTime.of(8, 30), spy.derniereHeureAppel);
    }

    @Test
    void langue_mock_valide_nombre_appels() {
        LangueMock mock = new LangueMock();

        var dp = DetectionDePalindromeBuilder
                .avecLangue(mock)
                .avecHeure(11, 11)
                .construire();

        dp.inverser("hello");

        mock.verifier();
    }

    @Test
    void salutation_matin() {
        var dp = DetectionDePalindromeBuilder
                .avecLangue(new LangueStub("bonjour_am", "Bravo"))
                .avecHeure(7, 0)
                .construire();

        assertTrue(dp.inverser("radar").contains("bonjour_am"));
    }

    @Test
    void salutation_apres_midi() {
        var dp = DetectionDePalindromeBuilder
                .avecLangue(new LangueStub("bonjour_pm", "Bravo"))
                .avecHeure(14, 0)
                .construire();

        assertTrue(dp.inverser("radar").contains("bonjour_pm"));
    }

    @Test
    void salutation_soiree() {
        var dp = DetectionDePalindromeBuilder
                .avecLangue(new LangueStub("bonjour_soir", "Bravo"))
                .avecHeure(19, 0)
                .construire();

        assertTrue(dp.inverser("radar").contains("bonjour_soir"));
    }

    @Test
    void salutation_nuit() {
        var dp = DetectionDePalindromeBuilder
                .avecLangue(new LangueStub("bonjour_nuit", "Bravo"))
                .avecHeure(23, 0)
                .construire();

        assertTrue(dp.inverser("radar").contains("bonjour_nuit"));
    }

    @Test
    void acquittement_est_toujours_present() {
        var dp = DetectionDePalindromeBuilder
                .avecLangue(new LangueStub("Bonjour", "Félicitations"))
                .avecHeure(9, 0)
                .construire();

        String resultat = dp.inverser("hello");
        assertTrue(resultat.endsWith(Expression.ACQUITTANCE));
    }

}

