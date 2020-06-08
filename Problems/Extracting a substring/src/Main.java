import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        int start = Integer.parseInt(scanner.next());
        int stop = Integer.parseInt(scanner.next());

        System.out.println(text.substring(start, stop + 1));
    }
}