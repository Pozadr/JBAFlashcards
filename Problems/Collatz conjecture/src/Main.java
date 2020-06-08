import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        System.out.print(inputNumber + " ");
        while (inputNumber != 1) {
            if (inputNumber % 2 == 0) {
                inputNumber /= 2;
            } else {
                inputNumber = inputNumber * 3 + 1;
            }
            System.out.print(inputNumber + " ");
        }
    }
}