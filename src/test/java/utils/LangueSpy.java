package utils;

import com.andynator.services.LangueService;
import java.time.LocalTime;

public class LangueSpy implements LangueService {
    public LocalTime derniereHeureAppel;

    @Override
    public String saluer(LocalTime heure) {
        this.derniereHeureAppel = heure;
        return "spy";
    }

    @Override
    public String feliciter() {
        return "spy";
    }
}
