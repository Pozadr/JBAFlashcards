package flashcards;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class FileFlashcards {

    public static void readFlashcardsFromFile(String path, Flashcards flashcards) {
        Scanner scanner;
        File file = new File(path);

        try {
            scanner = new Scanner(file); // it throws FileNotFoundException (checked)
            int lineCounter = 0;
            while (scanner.hasNext()) {
                String[] line = scanner.nextLine().trim().split(":");
                lineCounter++;
                String term = line[0];
                String definition = line[1];
                Integer score = Integer.parseInt(line[2]);
                flashcards.addFlashcardFromFile(term, definition, score);
            }
            System.out.println(lineCounter + " cards have been loaded.\n");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.\n");
        }
    }

    public static void writeFlashcardsToFile(String path, Flashcards flashcards) {
        File file = new File(path);
        int lineCounter = 0;

        try (PrintWriter printWriter = new PrintWriter(file)) {
            for(String term : flashcards.getFlashcardsTerms()) {
                printWriter.printf("%s:%s:%s\n",
                        term,
                        flashcards.getFlashcardDefinition(term),
                        flashcards.getFlashcardScore(term));
                lineCounter++;
            }
            System.out.println(lineCounter + " cards have been saved.\n");
        } catch (IOException e) {
            System.out.println("An exception occurs: " + e.getMessage().toLowerCase() + "\n");
        }
    }

    private static void printFlashcardsFromFile(Map<String, String> flashcardsFromFile) {
        System.out.println("Flashcards from file:");
        flashcardsFromFile.forEach((term, definition) -> System.out.println(term + ":" + definition));
    }





}
