import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int totalCounter = 1;
        for (int i = 1; i <= input; i++) {
            int j = i;
            while (j > 0) {
                System.out.print(i + " ");
                j--;
                totalCounter++;
                if (totalCounter > input) {
                    break;
                }
            }
            if (totalCounter > input) {
                break;
            }
        }
    }
}
