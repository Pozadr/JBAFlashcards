import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentNumber = scanner.nextInt();
        int result = currentNumber;

        while (currentNumber != 0) {
            int nextNumber = scanner.nextInt();
            if (nextNumber > result && nextNumber != 0) {
                result = nextNumber;
            }
            currentNumber = nextNumber;
        }
        System.out.println(result);
    }
}