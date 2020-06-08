import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean asc = true;
        boolean result = true;
        boolean firstScan = true;

        int previousNo = scanner.nextInt();
        while (scanner.hasNextInt()) {
            int inputNo = scanner.nextInt();
            if (firstScan) {
                if (inputNo < previousNo) {
                    asc = false;
                }
                firstScan = false;
                continue;
            }

            if (inputNo == 0) {
                break;
            } else if (asc == true  && inputNo < previousNo
            || asc == false && inputNo > previousNo) {
                result = false;
                break;
            }
            previousNo = inputNo;

        }
        System.out.println(result);
    }
}
