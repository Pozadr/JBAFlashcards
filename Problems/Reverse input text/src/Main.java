import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;


class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayList<Character> inputCharlist = new ArrayList<>();
            int charAsNumber = reader.read();
            while (charAsNumber != -1) {
                inputCharlist.add((char) charAsNumber);
                charAsNumber = reader.read();
            }
            Collections.reverse(inputCharlist);
            for (char ch : inputCharlist) {
                System.out.print(ch);
            }

        }
    }
}