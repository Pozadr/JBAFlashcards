import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputStringArr = scanner.nextLine().split(" ");
        int[] inputIntArr = new int[inputStringArr.length];
        for (int i = 0; i < inputStringArr.length; i++) {
            inputIntArr[i] = Integer.parseInt(inputStringArr[i]);
        }
        int shift = scanner.nextInt();
        if (shift > inputIntArr.length) {
            if (shift % inputIntArr.length == 0) {
                shift = inputIntArr.length;
            } else {
                shift = shift % inputIntArr.length;
            }
            //System.out.println("Shift:" + shift);
        }

        for (int j = 1; j <= shift; j++) {
            int tmp = inputIntArr[inputIntArr.length - 1];
            System.arraycopy(inputIntArr, 0, inputIntArr, 1, inputIntArr.length - 2 + 1);
            inputIntArr[0] = tmp;
        }
        for (int element : inputIntArr) {
            System.out.print(element + " ");
        }
    }
}
