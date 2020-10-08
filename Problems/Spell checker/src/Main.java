import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        Set<String> knownWords = new HashSet();
        int howMany = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < howMany; i++) {
            for (String str : scanner.nextLine().toLowerCase().trim().split("\\s+")) {
                knownWords.add(str);
            }
        }
        //addToSet(knownWords);
        //System.out.println(knownWords);

        Set<String> text = new HashSet();
        howMany = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < howMany; i++) {
            for (String str : scanner.nextLine().toLowerCase().trim().split("\\s+")) {
                text.add(str);
            }
        }
        //addToSet(text);
        //System.out.println(text);

        text.removeAll(knownWords);
        for (String s : text) {
            System.out.println(s);
        }

    }

}