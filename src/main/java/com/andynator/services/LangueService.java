package com.andynator.services;

import java.time.LocalTime;

public interface LangueService {
    String saluer(LocalTime heure);      // e.g. "Bonjour"
    String feliciter();
}
