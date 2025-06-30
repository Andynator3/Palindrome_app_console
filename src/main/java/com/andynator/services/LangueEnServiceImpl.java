package com.andynator.services;

import com.andynator.config.Expression;

import java.time.LocalTime;

public class LangueEnServiceImpl implements LangueService {
    @Override
    public String saluer(LocalTime heure) {
        return Expression.HELLO;
    }

    @Override
    public String feliciter() {
        return Expression.CONGRATULATIONS;
    }
}
