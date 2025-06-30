package com.andynator.models;

import com.andynator.config.Expression;
import com.andynator.services.LangueService;

import java.time.LocalTime;

    public class DetectionDePalindrome {

        private final String SALUTATIONS;
        private final String FELICITATIONS;


        public DetectionDePalindrome(LangueService langueService, LocalTime heure) {

            // Initialisation des messages en fonction de la période du jour

            this.SALUTATIONS = langueService.saluer(heure);
            this.FELICITATIONS = langueService.feliciter();
        }

        public String inverser(String saisie) {
            // Afficher la salutation selon la période
            System.out.println(SALUTATIONS);

            // Renverser la saisie
            String miroir = new StringBuilder(saisie).reverse().toString();

            // Félicitations si c’est un palindrome
            if(miroir.equals(saisie)){
                return SALUTATIONS + System.lineSeparator()
                        + miroir +  System.lineSeparator()
                        + FELICITATIONS + System.lineSeparator()
                        + Expression.ACQUITTANCE;
            }
            return SALUTATIONS + System.lineSeparator()
                    +  miroir +  System.lineSeparator()
                    + Expression.ACQUITTANCE;

        }



}
