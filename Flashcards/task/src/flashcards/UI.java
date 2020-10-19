package flashcards;

import java.util.Random;
import java.util.Scanner;

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
                    System.out.println("hardest card");
                    break;
                }
                case "reset stats": {
                    System.out.println("reset stats");
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

        flashcards.addFlashcard(term, definition);
        System.out.println("The pair (\"" + term + "\":\"" + definition + "\") has been added.\n");
        log.appendLog("The pair (\"" + term + "\":\"" + definition + "\") has been added.\n\n");
    }

    private void removeFlashcard() {
        System.out.println("The card:");
        String term = scanner.nextLine().trim();
        if (flashcards.isTermExist(term)) {
            flashcards.removeFlashcard(term);
            System.out.println("The card has been removed.\n");
        } else {
            System.out.println("Can't remove \"" + term + "\": there is no such card.\n");
        }
    }

    private void importFlashcards() {
        System.out.println("File name:");
        String pathToFile = scanner.nextLine().trim();
        flashcards.readFlashcardsFromFileDB(FileFlashcards
                .readFlashcardsFromFile(pathToFile)); // "./Flashcards/task/DB_Flashcards/" +
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
            if (userDefinition.equals(flashcards.getFlashcardDefinition(terms[randomTerm]))) {
                System.out.println("Correct!");
            } else if (flashcards.isDefinitionExist(userDefinition)) {
                String goodTerm = flashcards.getTermToDefinition(userDefinition);
                System.out.println("Wrong. The right answer is \"" +
                        flashcards.getFlashcardDefinition(terms[randomTerm]) + "\"" +
                        ", but your definition is correct for \"" + goodTerm + "\".");
            } else {
                System.out.println("Wrong. The right answer is \"" +
                        flashcards.getFlashcardDefinition(terms[randomTerm]) + "\"");
            }
        }
    }






}
