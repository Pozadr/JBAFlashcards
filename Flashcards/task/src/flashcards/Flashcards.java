package flashcards;

import java.util.HashMap;
import java.util.Map;

public class Flashcards {
    private Map<String, String> flashcards = new HashMap<>();

    public void printFlashcards() {
        flashcards.forEach((term, definition) -> System.out.println(term + ": " + definition));
    }

    public void addFlashcard(String term, String definition) {
        flashcards.put(term, definition);
    }

    public boolean isTermExist(String term) {
        return flashcards.containsKey(term);
    }

    public boolean isDefinitionExist(String definition) {
        return flashcards.containsValue(definition);
    }
}
