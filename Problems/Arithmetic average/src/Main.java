import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int result = 0;
        int quantityOfDivisibleByThree = 0;

        for (int i = a; i <= b; i++) {
            if (i % 3 == 0) {
                result += i;
                quantityOfDivisibleByThree++;
            }
        }
        System.out.println((double) result / quantityOfDivisibleByThree);
    }
}
