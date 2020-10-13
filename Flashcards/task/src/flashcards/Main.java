package flashcards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Flashcards flashcards = new Flashcards();

        // ---------- UI ----------
        System.out.println("Input the number of cards:");
        int howManyCards = 0;
        try {
            howManyCards = Integer.parseInt(scanner.nextLine().trim());


        } catch (NumberFormatException e) {
            System.out.println("You need to type numbers!");
        }

        for (int i = 0; i < howManyCards; i++) {
            String term = "";
            String definition = "";

            System.out.println("Card #" + (i + 1) + ":");
            boolean finishLoop = true;
            while (finishLoop) {
                term = scanner.nextLine().trim();
                finishLoop = flashcards.isTermExist(term);
                if (finishLoop) {
                    System.out.println("The term " + term + " already exists. Try again:");
                }
            }

            System.out.println("The definition for card #1:");
            finishLoop = true;
            while (finishLoop) {
                definition = scanner.nextLine().trim();
                finishLoop = flashcards.isDefinitionExist(definition);
                if (finishLoop) {
                    System.out.println("The definition " + definition + " already exists. Try again:");
                }
            }

            flashcards.addFlashcard(term, definition);
        }


        flashcards.printFlashcards();

    }
}
