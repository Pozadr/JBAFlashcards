package flashcards;

public class Main {
    public static void main(String[] args) {
        UI userInterface = new UI();
        userInterface.manageMainArgs(args);
        userInterface.menuLoop();
    }
}
