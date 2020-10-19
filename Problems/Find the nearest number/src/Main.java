import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArr = scanner.nextLine().trim().split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for(String input : inputArr) {
            list.add(Integer.parseInt(input));
        }
        Collections.sort(list);

        int numToCompare = scanner.nextInt();
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer integer : list) {
            result.add(Math.abs(numToCompare - integer));
        }
        int min = Collections.min(result);
        for (int i = 0; i < result.size(); i++) {
            //System.out.println("list: " + list.get(i) + " result: " + result.get(i));
            if(result.get(i) == min) {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}