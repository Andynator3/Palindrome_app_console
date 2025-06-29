package com.andynator;

public class OHCE {


    public String palindrome(String input) {
        System.out.println("Bonjour");

        String reversed = reverse(input);
        System.out.println(reversed);

        if (isPalindrome(input)) {
            System.out.println("Bien dit !");
        }

        System.out.println("Au revoir");
        return reversed;
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private boolean isPalindrome(String s) {
        String lower = s.toLowerCase();
        return lower.equals(reverse(lower));
    }



}
