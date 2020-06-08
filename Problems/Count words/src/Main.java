import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            int charAsNumber = reader.read();
            while (charAsNumber != -1) {
                char character = (char) charAsNumber;
                sb.append(character);
                charAsNumber = reader.read();
            }
            String result = sb.toString();
            String[] resultArr = result.split(" ");
            int counter = 0;
            for (String str : resultArr) {
                if (!str.isBlank()) {
                    counter++;
                }
            }
            System.out.println(counter);
        }
    }

}