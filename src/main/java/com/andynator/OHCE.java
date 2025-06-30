package com.andynator;

public class OHCE {

    // Nouvelle version avec une unique méthode palindrome
    public String palindrome(String input) {
        System.out.println("Bonjour");

        // Inverser la chaîne directement ici
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        System.out.println(reversed);

        // Vérification du palindrome (insensible à la casse)
        String originalLower = input.toLowerCase();
        String reversedLower = reversed.toLowerCase();

        if (originalLower.equals(reversedLower)) {
            System.out.println("Bien dit !");
        }

        System.out.println("Au revoir");

        return reversed;
    }

}
