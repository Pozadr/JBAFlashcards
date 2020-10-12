import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min;
        int max;
        String[] input = scanner.nextLine().split("\\s+");
        min = Integer.parseInt(input[0]);
        max = Integer.parseInt(input[1]);
        int howManyKeyValue = Integer.parseInt(scanner.nextLine().trim());

        HashMap<Integer, String> pairs = new HashMap<>();
        while (howManyKeyValue > 0) {
            input = scanner.nextLine().split("\\s+");
            if (Integer.parseInt(input[0]) >= min && Integer.parseInt(input[0]) <= max) {
                pairs.put(Integer.parseInt(input[0]), input[1]);
            }
            howManyKeyValue--;
        }
        pairs.forEach((key, value) -> System.out.println(key + " " + value));
    }
}