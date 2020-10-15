package flashcards;

import java.util.*;

public class Flashcards {
    private final Map<String, String> flashcards = new HashMap<>();

    public void addFlashcard(String term, String definition) {
        flashcards.put(term, definition);
    }

    public void readFlashcardsFromFileDB(Map<String, String> fileDBHashMap) {
        for (String term : fileDBHashMap.keySet()) {
            flashcards.put(term, fileDBHashMap.get(term));
        }
    }

    public void removeFlashcard(String term) {
        flashcards.remove(term);
    }

    public boolean isTermExist(String term) {
        return flashcards.containsKey(term);
    }

    public boolean isDefinitionExist(String definition) {
        return flashcards.containsValue(definition);
    }

    public String getTermToDefinition(String definition) {
        if (isDefinitionExist(definition)) {
            for (String term : getFlashcardsTerms()) {
                if (flashcards.get(term).equals(definition)) {
                    return term;
                }
            }
        }
        System.out.println( "Definition not exists in flashcards.");
        return "";
    }

    public Set<String> getFlashcardsTerms() {
        return new HashSet<>(flashcards.keySet());
    }

    public Set<String> getFlashcardsDefinitions() {
        return new HashSet<>(flashcards.values());
    }

    public String getFlashcardDefinition(String key) {
        return flashcards.get(key);
    }

    public void printFlashcards() {
        System.out.println("Current loaded flashcards:");
        flashcards.forEach((term, definition) -> System.out.println(term + ": " + definition));
    }
}
