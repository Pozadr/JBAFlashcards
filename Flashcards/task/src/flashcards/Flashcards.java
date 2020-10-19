package flashcards;

import java.util.*;

public class Flashcards {
    private final Map<String, String> flashcards = new HashMap<>();
    private final Map<String, Integer> hardestCards = new HashMap<>();


    public void addFlashcardUser(String term, String definition) {
        flashcards.put(term, definition);
        hardestCards.put(term, 0);
    }


    public void addFlashcardFromFile(String term, String definition, Integer score) {
        flashcards.put(term, definition);
        hardestCards.put(term, score);
    }


    public void removeFlashcard(String term) {
        flashcards.remove(term);
        hardestCards.put(term, 0);
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


    public Set<String> getHardestCardsTerms() {
        return new HashSet<>(hardestCards.keySet());
    }


    public String[] getFlashcardsTermsArray() {
        String[] terms = new String[flashcards.size()];
        int termIndex = 0;
        for (String term : getFlashcardsTerms()) {
            terms[termIndex] = term;
            termIndex++;
        }
        return terms;
    }


    public Set<String> getFlashcardsDefinitions() {
        return new HashSet<>(flashcards.values());
    }


    public Set<Integer> getHardestCardsScores() {
        return new HashSet<>(hardestCards.values());
    }


    public String getFlashcardDefinition(String term) {
        return flashcards.get(term);
    }


    public Integer getHardestCardDefinition(String term) {
        return hardestCards.get(term);
    }


    public Integer getFlashcardScore(String term) {
        return hardestCards.get(term);
    }


    public void addFlashcardScore(String term) {
        hardestCards.put(term, (hardestCards.get(term) + 1));
    }


    public HashMap<String, Integer> getHardestCards() throws NoSuchElementException {
        HashMap<String, Integer> hardestCards = new HashMap();
        Integer max = Collections.max(getHardestCardsScores());
        if (max == 0) {
            return null;
        }
        //System.out.println("max: " + max);
        for (String term : getHardestCardsTerms()) {
            if (getHardestCardDefinition(term).equals(max)) {
                hardestCards.put(term, getHardestCardDefinition(term));
                //System.out.println("card:" + term + " score: " + getHardestCardDefinition(term));
            }
        }
        return hardestCards;
    }


    public void resetStats() {
        for (String term : getHardestCardsTerms()) {
            hardestCards.put(term, 0);
        }
    }


    // ------------------------ TEST ------------------------
    public void printFlashcards() {
        System.out.println("Current loaded flashcards:");
        flashcards.forEach((term, definition) -> System.out.println(term + ": " + definition));
    }


    public void printHardestCards() {
        System.out.println("The hardest cards are:");
        hardestCards.forEach((term, value) -> System.out.println(term + ": " + value));
    }


}
