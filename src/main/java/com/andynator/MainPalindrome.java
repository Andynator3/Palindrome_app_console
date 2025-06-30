package com.andynator;


public class MainPalindrome {
    public static void main(String[] args) {
        OHCE ohce = new OHCE();

        // Appel avec la langue française
        ohce.palindrome("kayak", "fr");

        System.out.println();

        // Appel avec la langue anglaise
        ohce.palindrome("hello", "en");
    }

}


