import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sum = new int[scanner.nextInt()];
        int result = 0;
        for (int i = 0; i < sum.length; i++) {
            sum[i] = scanner.nextInt();
            result += sum[i];
        }
        System.out.println(result);

    }
}
