import org.jetbrains.annotations.NotNull;

import java.util.*;

class SetUtils {

    @NotNull
    public static Set<Integer> getSetFromString(@NotNull String str) {
        // write your code here
        Set<Integer> result = new TreeSet<>();
        String[] strArr = str.split(" ");
        for (String s : strArr) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }

    public static void removeAllNumbersGreaterThan10(@NotNull Set<Integer> set) {
        // write your code here
        set.removeIf(num -> num > 10);
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}