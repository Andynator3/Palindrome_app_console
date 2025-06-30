package com.andynator;

public class OHCE {

    public String palindrome(String input, String lang) {
        // Définition des messages selon la langue
        String greeting;
        String wellSaid;
        String farewell;

        if ("en".equalsIgnoreCase(lang)) {
            greeting = "Hello";
            wellSaid = "Well said!";
            farewell = "Goodbye";
        } else { // par défaut : français
            greeting = "Bonjour";
            wellSaid = "Bien dit !";
            farewell = "Au revoir";
        }

        // Affichage
        System.out.println(greeting);

        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println(reversed);

        if (input.equalsIgnoreCase(reversed)) {
            System.out.println(wellSaid);
        }

        System.out.println(farewell);

        return reversed;
    }


}
