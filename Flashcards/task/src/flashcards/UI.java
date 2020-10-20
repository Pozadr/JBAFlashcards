package flashcards;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class UI {
    private final Scanner scanner = new Scanner(System.in);
    private final Log log = new Log();
    Flashcards flashcards = new Flashcards();
    private boolean exitExportEnabled = false;
    private String exitExportPath = "";

    public void manageMainArgs(String[] args) {
        for (int i = 0; i < args.length; i = i + 2) {
            switch (args[i]) {
                case "-import": {
                    importFlashcards(args[i + 1]);
                    break;
                }
                case "-export": {
                    exitExportEnabled = true;
                    exitExportPath = args[i + 1];
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    public void menuLoop() {
        String userInput;
        do {
            log.appendLogAndPrintToConsole("Input the action (add, remove, import, export, ask," +
                    " exit, log, hardest card, reset stats):");
            userInput = scanner.nextLine().trim();
            log.appendLog(userInput);
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
                    log.appendLogAndPrintToConsole("Bye bye!");
                    if (exitExportEnabled) {
                        exportFlashcards(exitExportPath);
                    }
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
                    log.appendLogAndPrintToConsole("Wrong input try again!");
            }
        } while (!userInput.equals("exit"));
    }


    private void addFlashcard() {
        // Term
        log.appendLogAndPrintToConsole("The card:");
        String term = scanner.nextLine().trim();
        log.appendLog(term);
        if (flashcards.isTermExist(term)) {
            log.appendLogAndPrintToConsole("The card \"" + term + "\" already exists.\n");
            return;
        }

        // Definition
        log.appendLogAndPrintToConsole("The definition for card:");
        String definition = scanner.nextLine().trim();
        log.appendLog(definition);
        if (flashcards.isDefinitionExist(definition)) {
            log.appendLogAndPrintToConsole("The definition \"" + definition + "\" already exists.\n");
            return;
        }

        flashcards.addFlashcardUser(term, definition);
        log.appendLogAndPrintToConsole("The pair (\"" + term + "\":\"" + definition + "\") has been added.\n");
    }


    private void removeFlashcard() {
        log.appendLogAndPrintToConsole("The card:");
        String term = scanner.nextLine().trim();
        log.appendLog(term);
        if (flashcards.isTermExist(term)) {
            flashcards.removeFlashcard(term);
            log.appendLogAndPrintToConsole("The card has been removed.\n");
        } else {
            log.appendLogAndPrintToConsole("Can't remove \"" + term + "\": there is no such card.\n");
        }
    }


    private void importFlashcards() {
        log.appendLogAndPrintToConsole("File name:");
        String pathToFile = scanner.nextLine().trim();
        log.appendLog(pathToFile);
        int lineCounter =FileFlashcards.readFlashcardsFromFile(pathToFile, flashcards); // "./Flashcards/task/DB_Flashcards/" +
        log.appendLogAndPrintToConsole(lineCounter + " cards have been loaded.\n");
    }

    private void importFlashcards(String pathToFile) {
        int lineCounter =FileFlashcards.readFlashcardsFromFile(pathToFile, flashcards); // "./Flashcards/task/DB_Flashcards/" +
        log.appendLogAndPrintToConsole(lineCounter + " cards have been loaded.\n");
    }


    private void exportFlashcards() {
        log.appendLogAndPrintToConsole("File name:");
        String pathToFile = scanner.nextLine().trim();
        log.appendLog(pathToFile);
        int lineCounter = FileFlashcards.writeFlashcardsToFile(pathToFile, flashcards); //"./Flashcards/task/DB_Flashcards/" +
        log.appendLogAndPrintToConsole(lineCounter + " cards have been saved.\n");
    }

    private void exportFlashcards(String pathToFile) {
        int lineCounter = FileFlashcards.writeFlashcardsToFile(pathToFile, flashcards); //"./Flashcards/task/DB_Flashcards/" +
        log.appendLogAndPrintToConsole(lineCounter + " cards have been saved.\n");
    }


    private void saveLog() {
        log.appendLogAndPrintToConsole("File name:");
        String pathToFile = scanner.nextLine().trim();
        log.appendLog(pathToFile);
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
                log.appendLogAndPrintToConsole("The hardest card is " + message + "You have " + highestScore +
                        " errors answering it.\n");
            } else {
                log.appendLogAndPrintToConsole("The hardest cards are " + message + "You have " + highestScore +
                        " errors answering it.\n");

            }

        } catch (NoSuchElementException | NullPointerException e) {
            log.appendLogAndPrintToConsole("There are no cards with errors.\n");
        }

    }


    private void resetStats() {
        flashcards.resetStats();
        log.appendLogAndPrintToConsole("Card statistics have been reset.\n");
    }


    private void askUser() {
        log.appendLogAndPrintToConsole("How many times to ask?");
        int howManyQuestions;
        try {  // input validation
            howManyQuestions = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            log.appendLogAndPrintToConsole("Error: " + e.getMessage().toLowerCase());
            return;
        }
        log.appendLog(Integer.toString(howManyQuestions));

        // terms to String[] to use them with Random
        String[] terms = flashcards.getFlashcardsTermsArray();

        Random random = new Random();
        for (int i = 0; i < howManyQuestions; i++) {
            int randomTerm = random.nextInt(terms.length); // draw the random term
            log.appendLogAndPrintToConsole("Print the definition of \"" + terms[randomTerm] + "\":");
            String userDefinition = scanner.nextLine().trim();
            log.appendLog(userDefinition);

            // check answer
            // correct
            if (userDefinition.equals(flashcards.getFlashcardDefinition(terms[randomTerm]))) {
                log.appendLogAndPrintToConsole("Correct!\n");
            }
            // wrong but definition is in DB
            else if (flashcards.isDefinitionExist(userDefinition)) {
                String goodTerm = flashcards.getTermToDefinition(userDefinition);
                flashcards.addFlashcardScore(terms[randomTerm]);
                log.appendLogAndPrintToConsole("Wrong. The right answer is \"" +
                        flashcards.getFlashcardDefinition(terms[randomTerm]) + "\"" +
                        ", but your definition is correct for \"" + goodTerm + "\".\n");
            }
            // wrong definition isn't in DB
            else {
                flashcards.addFlashcardScore(terms[randomTerm]);
                log.appendLogAndPrintToConsole("Wrong. The right answer is \"" +
                        flashcards.getFlashcardDefinition(terms[randomTerm]) + "\".\n");
            }
        }
    }






}
