import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.next());
        int b = Integer.parseInt(scanner.next());
        int n = Integer.parseInt(scanner.next());
        int result = 0;

        for (int i = a; i <= b; i++) {
            if (i % n == 0) {
                result++;
            }
        }
        System.out.println(result);
    }
}
