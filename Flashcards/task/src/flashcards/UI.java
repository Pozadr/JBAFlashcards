package flashcards;

import javax.swing.*;
import java.util.*;

public class UI {
    private final Scanner scanner = new Scanner(System.in);
    private final Log log = new Log();
    Flashcards flashcards = new Flashcards();


    public void menuLoop() {
        String userInput;
        do {
            System.out.println("Input the action (add, remove, import, export, ask," +
                    " exit, log, hardest card, reset stats):");
            log.appendLog("Input the action (add, remove, import, export, ask," +
                    " exit, log, hardest card, reset stats):\n");
            userInput = scanner.nextLine().trim();
            switch (userInput) {
                case "add": {
                    addFlashcard();
                    break;
                }
                case "remove": {
                    removeFlashcard();
                    break;
                }
                case "import": {
                    importFlashcards();
                    break;
                }
                case "export": {
                    exportFlashcards();
                    break;
                }
                case "ask": {
                    askUser();
                    break;
                }
                case "exit": {
                    System.out.println("Bye bye!");
                    break;
                }
                case "log": {
                    saveLog();
                    break;
                }
                case "hardest card": {
                    printHardestCards();
                    break;
                }
                case "reset stats": {
                    resetStats();
                    break;
                }
                default:
                    System.out.println("Wrong input try again!");
                    log.appendLog("Wrong input try again!\n");
            }
        } while (!userInput.equals("exit"));
    }

    private void addFlashcard() {
        // Term
        System.out.println("The card:");
        log.appendLog("The card:\n");
        String term = scanner.nextLine().trim();
        log.appendLog(term + "\n");
        if (flashcards.isTermExist(term)) {
            System.out.println("The card \"" + term + "\" already exists.\n");
            log.appendLog("The card \"" + term + "\" already exists.\n\n");
            return;
        }

        // Definition
        System.out.println("The definition for card:");
        log.appendLog("The definition for card:\n");
        String definition = scanner.nextLine().trim();
        log.appendLog(definition + "\n");
        if (flashcards.isDefinitionExist(definition)) {
            System.out.println("The definition \"" + definition + "\" already exists.\n");
            log.appendLog("The definition \"" + definition + "\" already exists.\n\n");
            return;
        }

        flashcards.addFlashcardUser(term, definition);
        System.out.println("The pair (\"" + term + "\":\"" + definition + "\") has been added.\n");
        log.appendLog("The pair (\"" + term + "\":\"" + definition + "\") has been added.\n\n");
    }

    private void removeFlashcard() {
        System.out.println("The card:");
        log.appendLog("The card:\n");
        String term = scanner.nextLine().trim();
        log.appendLog(term + "\n");
        if (flashcards.isTermExist(term)) {
            flashcards.removeFlashcard(term);
            System.out.println("The card has been removed.\n");
            log.appendLog("The card has been removed.\n\n");
        } else {
            System.out.println("Can't remove \"" + term + "\": there is no such card.\n");
            log.appendLog("Can't remove \"" + term + "\": there is no such card.\n\n");
        }
    }

    private void importFlashcards() {
        System.out.println("File name:");
        String pathToFile = scanner.nextLine().trim();
        FileFlashcards.readFlashcardsFromFile(pathToFile, flashcards); // "./Flashcards/task/DB_Flashcards/" +
    }

    private void exportFlashcards() {
        System.out.println("File name:");
        log.appendLog("File name:\n");
        String pathToFile = scanner.nextLine().trim();
        FileFlashcards.writeFlashcardsToFile(pathToFile, flashcards); //"./Flashcards/task/DB_Flashcards/" +
    }

    private void saveLog() {
        System.out.println("File name:");
        log.appendLog("File name:\n");
        String pathToFile = scanner.nextLine().trim();
        log.appendLog(pathToFile + "\n");
        log.writeLogToFile(pathToFile);

    }

    private void printHardestCards() {
        try {
            HashMap<String, Integer> hardestCards = flashcards.getHardestCards(); // throws NoSuchElementException

            StringBuilder message = new StringBuilder();
            int sizeOfSet = hardestCards.keySet().size();
            int highestScore = 0;

            for (String term : hardestCards.keySet()) {
                if(sizeOfSet > 1) {
                    message.append("\"").append(term).append("\"").append(", ");
                } else {
                    message.append("\"").append(term).append("\"").append(". ");
                }
                highestScore = hardestCards.get(term);
                sizeOfSet--;
            }
            if (hardestCards.size() == 1){
                System.out.println("The hardest card is " + message + "You have " + highestScore +
                        " errors answering it.\n");
            } else {
                System.out.println("The hardest cards are " + message + "You have " + highestScore +
                        " errors answering it.\n");

            }

        } catch (NoSuchElementException | NullPointerException e) {
            System.out.println("There are no cards with errors.\n");
        }

    }

    private void resetStats() {
        flashcards.resetStats();
        System.out.println("Card statistics have been reset.\n");
    }


    private void askUser() {
        System.out.println("How many times to ask?");
        int howManyQuestions;
        try {  // input validation
            howManyQuestions = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage().toLowerCase());
            return;
        }

        // terms to String[] to use them with Random
        String[] terms = flashcards.getFlashcardsTermsArray();

        Random random = new Random();
        for (int i = 0; i < howManyQuestions; i++) {
            int randomTerm = random.nextInt(terms.length); // draw the random term
            System.out.println("Print the definition of \"" + terms[randomTerm] + "\":");
            String userDefinition = scanner.nextLine().trim();

            // check answer
            // correct
            if (userDefinition.equals(flashcards.getFlashcardDefinition(terms[randomTerm]))) {
                System.out.println("Correct!");
            }
            // wrong but definition is in DB
            else if (flashcards.isDefinitionExist(userDefinition)) {
                String goodTerm = flashcards.getTermToDefinition(userDefinition);
                flashcards.addFlashcardScore(terms[randomTerm]);
                System.out.println("Wrong. The right answer is \"" +
                        flashcards.getFlashcardDefinition(terms[randomTerm]) + "\"" +
                        ", but your definition is correct for \"" + goodTerm + "\".");
            }
            // wrong definition isn't in DB
            else {
                flashcards.addFlashcardScore(terms[randomTerm]);
                System.out.println("Wrong. The right answer is \"" +
                        flashcards.getFlashcardDefinition(terms[randomTerm]) + "\"");
            }
        }
    }






}
