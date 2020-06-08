import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfParts = Integer.parseInt(scanner.nextLine());
        int okParts = 0;
        int nokParts = 0;
        int rejectParts = 0;

        for (int i = 0; i < numberOfParts; i++) {
            int partQuality = Integer.parseInt(scanner.nextLine());
            if (partQuality == 0) {
                okParts++;
            } else if (partQuality == 1) {
                nokParts++;
            } else {
                rejectParts++;
            }
        }
        System.out.println(okParts + " " + nokParts + " " + rejectParts);
    }
}
