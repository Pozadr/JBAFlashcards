//put imports you need here

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] guestNameArr = new String[8];

        for (int i = 0; i < guestNameArr.length; i++) {
            guestNameArr[i] = scanner.next();
        }

        for (int j = guestNameArr.length - 1; j >= 0; j--) {
            System.out.println(guestNameArr[j]);
        }
    }
}
