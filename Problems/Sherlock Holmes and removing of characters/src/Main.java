import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Integer> word1 = readLineToHashMap(scanner.nextLine().toLowerCase().trim().toCharArray());
        HashMap<Character, Integer> word2 = readLineToHashMap(scanner.nextLine().toLowerCase().trim().toCharArray());

        //word1.forEach((key, value) -> System.out.println(key + ": " + value));
        //word2.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println(checkWords(word1, word2));


    }

    private static HashMap<Character, Integer> readLineToHashMap(char[] input) {
        HashMap<Character, Integer> result = new HashMap<>();
        for (Character ch : input) {
            if (result.containsKey(ch)) {
                int howManyCh = result.get(ch) + 1;
                result.put(ch, howManyCh);
            } else {
                result.put(ch, 1);
            }
        }
        return result;
    }

    private static int checkWords(HashMap<Character, Integer> word1, HashMap<Character, Integer> word2) {
        int notInBothWords = 0;
        HashSet<Character> allKeys = new HashSet<>();
        allKeys.addAll(word1.keySet());
        allKeys.addAll(word2.keySet());

        for (Character ch : allKeys) {
            //System.out.println(ch);
            if (word1.containsKey(ch) && word2.containsKey(ch)) {
                notInBothWords += Math.abs(word1.get(ch) - word2.get(ch));
                word2.remove(ch);
            } else if (word1.containsKey(ch)) {
                notInBothWords += word1.get(ch);
            } else if (word2.containsKey(ch)) {
                notInBothWords += word2.get(ch);
            }
        }
        return notInBothWords;
    }

}