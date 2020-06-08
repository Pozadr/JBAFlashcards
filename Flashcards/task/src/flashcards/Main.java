package flashcards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String task = scanner.nextLine();
        String rightAnswer = scanner.nextLine();
        System.out.println("Card:");
        System.out.println(task);
        System.out.println("Type your answer and confirm it pressing enter: ");
        if (rightAnswer.equals(scanner.next())) {
            System.out.println("Your answer is right!");
        }
        else {
            System.out.println("Your answer is wrong!");
        }
    }
}
