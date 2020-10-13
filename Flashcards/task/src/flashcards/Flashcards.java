package flashcards;

import java.util.*;

public class Flashcards {
    private final Map<String, String> flashcards = new LinkedHashMap<>();

    public void printFlashcards() {
        flashcards.forEach((term, definition) -> System.out.println(term + ": " + definition));
    }

    public void addFlashcard(String term, String definition) {
        flashcards.put(term, definition);
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
        return "Definition not exists in flashcards.";

    }

    public Set<String> getFlashcardsTerms() {
        return new LinkedHashSet<>(flashcards.keySet());
    }
    public Set<String> getFlashcardsDefinitions() {
        return new HashSet<>(flashcards.values());
    }
    public String getFlashcardDefinition(String key) {
        return flashcards.get(key);
    }
}
