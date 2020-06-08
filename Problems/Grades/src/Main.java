import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsQuantity = scanner.nextInt();
        int gradeA = 0;
        int gradeB = 0;
        int gradeC = 0;
        int gradeD = 0;
        for (int i = 0; i < studentsQuantity; i++) {
            int grade = scanner.nextInt();
            switch (grade) {
                case 2: {
                    gradeD++;
                    break;
                }
                case 3: {
                    gradeC++;
                    break;
                }
                case 4: {
                    gradeB++;
                    break;
                }
                case 5: {
                    gradeA++;
                    break;
                }
            }
        }
        System.out.println(gradeD + " " + gradeC + " " + gradeB + " "
        + gradeA);
    }
}
