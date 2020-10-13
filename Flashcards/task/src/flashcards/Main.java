package flashcards;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Flashcards flashcards = new Flashcards();

        // Get flashcards
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
                    System.out.println("The card \"" + term + "\" already exists. Try again:");
                }
            }

            System.out.println("The definition for card #" + (i + 1) + ":");
            finishLoop = true;
            while (finishLoop) {
                definition = scanner.nextLine().trim();
                finishLoop = flashcards.isDefinitionExist(definition);
                if (finishLoop) {
                    System.out.println("The definition \"" + definition + "\" already exists. Try again:");
                }
            }

            flashcards.addFlashcard(term, definition);
        }

        // Get answers
        for (String term : flashcards.getFlashcardsTerms()) {
            System.out.println("Print the definition of \"" + term + "\":");
            String userDefinition = scanner.nextLine().trim();
            if (userDefinition.equals(flashcards.getFlashcardDefinition(term))) {
                System.out.println("Correct!");
            } else if (flashcards.isDefinitionExist(userDefinition)){
                String goodTerm = flashcards.getTermToDefinition(userDefinition);
                System.out.println("Wrong. The right answer is \""+
                        flashcards.getFlashcardDefinition(term)+ "\"" +
                        ", but your definition is correct for \"" + goodTerm + "\".");
            } else {
                System.out.println("Wrong. The right answer is \""+
                        flashcards.getFlashcardDefinition(term)+ "\"");
            }
        }


    }
}
