import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        int output = 37;

        int num1 = inputNumber % 10;
        int num10 = (inputNumber / 10) % 10;
        int num100 = (inputNumber / 100) % 10;
        int num1000 = (inputNumber / 1000) % 10;
        if (num1 == num1000 && num10 == num100) {
            output = 1;
        }
        System.out.println(output);
    }
}