package utils;

import com.andynator.services.LangueService;
import java.time.LocalTime;

public class LangueStub implements LangueService {
    private final String salutation;
    private final String felicitation;

    public LangueStub(String salutation, String felicitation) {
        this.salutation = salutation;
        this.felicitation = felicitation;
    }

    @Override
    public String saluer(LocalTime heure) {
        return salutation;
    }

    @Override
    public String feliciter() {
        return felicitation;
    }
}
