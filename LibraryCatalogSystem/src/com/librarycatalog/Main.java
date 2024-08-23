import library.LibraryCatalog;
import library.UserInterface;

public class Main {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        UserInterface ui = new UserInterface(catalog);
        ui.start();
    }
}
