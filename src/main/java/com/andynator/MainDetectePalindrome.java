package com.andynator;

import com.andynator.models.DetectionDePalindrome;
import com.andynator.services.LangueFrServiceImpl;
import com.andynator.services.LangueService;

import java.time.LocalTime;
import java.util.Scanner;

public class MainDetectePalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(" ");
            String input = scanner.nextLine();

            if (input == null || input.isEmpty()) {
                throw new IllegalStateException("Aucune saisie");
            }

            LangueService langue = new LangueFrServiceImpl(); // Implémentation française
            LocalTime heure = LocalTime.now();


            DetectionDePalindrome dePalindrome = new DetectionDePalindrome(langue, heure);
            String résultat = dePalindrome.inverser(input);

            System.out.println(input + " => " + résultat);
        }
    }
}
