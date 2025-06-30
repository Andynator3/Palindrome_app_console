package com.andynator.services;

import com.andynator.config.Expression;

import java.time.LocalTime;

public class LangueFrServiceImpl implements LangueService {
    @Override
    public String saluer(LocalTime heure) {
        return Expression.SALUTATIONS;
    }

    @Override
    public String feliciter() {
        return Expression.FELICITATIONS;
    }
}
