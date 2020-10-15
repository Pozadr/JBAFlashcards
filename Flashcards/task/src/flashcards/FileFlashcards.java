package flashcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileFlashcards {
    private Map<String, String> fileFlashcards = new HashMap<>();
    private Scanner scanner;
    private File file;

    public FileFlashcards(String path) {
        this.file = new File(path);
        try {
            this.scanner = new Scanner(file); // it throws FileNotFoundException (checked)
            System.out.println(scanner.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("File not found.\n");
        }
        readFlashcardsFromFile();
        printFileFlashcards();

    }

    private void readFlashcardsFromFile() {
        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().trim().split(":");
            String term = line[0];
            String definition = line[1];
            fileFlashcards.put(term, definition);
        }
    }

    private void printFileFlashcards() {
        fileFlashcards.forEach((term, definition) -> System.out.println(term + ":" + definition));
    }



}
