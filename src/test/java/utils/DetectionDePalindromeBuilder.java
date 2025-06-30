package utils;

import com.andynator.models.DetectionDePalindrome;
import com.andynator.services.LangueService;
import java.time.LocalTime;

public class DetectionDePalindromeBuilder {

    private LangueService langue = new LangueStub("par defaut", "par defaut");
    private LocalTime heure = LocalTime.of(10, 0);

    public static DetectionDePalindromeBuilder avecLangue(LangueService langue) {
        DetectionDePalindromeBuilder builder = new DetectionDePalindromeBuilder();
        builder.langue = langue;
        return builder;
    }

    public DetectionDePalindromeBuilder avecHeure(int h, int m) {
        this.heure = LocalTime.of(h, m);
        return this;
    }

    public DetectionDePalindrome construire() {
        return new DetectionDePalindrome(langue, heure);
    }
}

