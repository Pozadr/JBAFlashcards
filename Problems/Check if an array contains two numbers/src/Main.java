import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean result = false;
        int[] sum = new int[scanner.nextInt()];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int j = 0; j < sum.length; j++) {

            if (n == sum[j] && ((j + 1 < sum.length && m == sum[j + 1])
                    || m == sum[j - 1])) {
                result = true;
                break;
            }
        }
        System.out.println(result);
    }
}
