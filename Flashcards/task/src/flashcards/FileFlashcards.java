package flashcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileFlashcards {
    private final Map<String, String> flashcardsFromFile = new HashMap<>();
    private Scanner scanner;

    public FileFlashcards(String path, Flashcards flashcards) {

        File file = new File(path);
        try {
            this.scanner = new Scanner(file); // it throws FileNotFoundException (checked)
        } catch (FileNotFoundException e) {
            System.out.println("File not found.\n");
        }
        readFlashcardsFromFile();
        flashcards.readFlashcardsFromFileDB(flashcardsFromFile);

    }

    private void readFlashcardsFromFile() {
        int lineCounter = 0;
        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().trim().split(":");
            lineCounter++;
            String term = line[0];
            String definition = line[1];
            flashcardsFromFile.put(term, definition);
        }
        System.out.println(lineCounter + " cards have been loaded.\n");
    }

    private void printFlashcardsFromFile() {
        System.out.println("Flashcards from file:");
        flashcardsFromFile.forEach((term, definition) -> System.out.println(term + ":" + definition));
    }





}
