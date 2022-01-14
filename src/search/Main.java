package search;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final SearchEngine searchEngine = new SearchEngine();

    private enum Action {
        FIND(1),
        PRINT(2),
        EXIT(0),
        UNKNOWN(-1);

        private final int code;

        Action(int code) {
            this.code = code;
        }

        public static Action getAction(int code) {
            for (Action value : Action.values()) {
                if (code == value.code) {
                    return value;
                }
            }
            return UNKNOWN;
        }
    }

    public static void main(String[] args) {
        Main app = new Main(args);
        app.run();
    }

    public Main(String[] args) {
        Path path = Path.of(args[1]);
        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNext()) {
                searchEngine.addData(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(2);
        }
    }

    private void run() {
        boolean isProgramRun = true;
        while (isProgramRun) {
            printMenu();
            Action action = Action.UNKNOWN;

            while (action == Action.UNKNOWN) {
                action = Action.getAction(Integer.parseInt(scanner.nextLine()));
            }

            switch (action) {
                case FIND:
                    search();
                    break;
                case PRINT:
                    searchEngine.printData("=== List of people ===");
                    break;
                case EXIT:
                    System.out.println("Bye!");
                    isProgramRun = false;
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    private void printMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Search information.");
        System.out.println("2. Print all data.");
        System.out.println("0. Exit.");
    }

    private void search() {
        System.out.println();
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        searchEngine.setSearchStrategy(scanner.nextLine().trim());

        System.out.println();
        System.out.println("Enter data to search people:");
        searchEngine.search(scanner.nextLine().trim());
    }
}
