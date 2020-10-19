package flashcards;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {
    private StringBuilder logSb = new StringBuilder();

    public void appendLogAndPrintToConsole(String text) {
        System.out.println(text);
        logSb.append(text).append("\n");
    }


    public void appendLog(String text) {
        logSb.append(text).append("\n");
    }


    public void writeLogToFile(String path) {
        File file = new File(path);
        try (PrintWriter printWriter = new PrintWriter(file)) {
                printWriter.print(logSb);
            System.out.println("The log has been saved.\n");
        } catch (IOException e) {
            System.out.println("An exception occurs: " + e.getMessage().toLowerCase() + "\n");
        }
    }
}
