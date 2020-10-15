package flashcards;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileFlashcards {

    public static Map<String, String> readFlashcardsFromFile(String path) {
        Scanner scanner;
        Map<String, String> flashcardsFromFile = new HashMap<>();
        File file = new File(path);

        try {
            scanner = new Scanner(file); // it throws FileNotFoundException (checked)
            int lineCounter = 0;
            while (scanner.hasNext()) {
                String[] line = scanner.nextLine().trim().split(":");
                lineCounter++;
                String term = line[0];
                String definition = line[1];
                flashcardsFromFile.put(term, definition);
            }
            System.out.println(lineCounter + " cards have been loaded.\n");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.\n");
        }
        return flashcardsFromFile;
    }

    public static void writeFlashcardsToFile(String path, Flashcards flashcards) {
        File file = new File(path);
        int lineCounter = 0;

        try (PrintWriter printWriter = new PrintWriter(file)) {
            for(String term : flashcards.getFlashcardsTerms()) {
                printWriter.printf("%s:%s\n", term, flashcards.getFlashcardDefinition(term));
                lineCounter++;
            }
            System.out.println(lineCounter + " cards have been saved.\n");
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    private static void printFlashcardsFromFile(Map<String, String> flashcardsFromFile) {
        System.out.println("Flashcards from file:");
        flashcardsFromFile.forEach((term, definition) -> System.out.println(term + ":" + definition));
    }





}
