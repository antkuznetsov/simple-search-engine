package search;

import java.util.*;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> data = new ArrayList<>();

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
        Main app = new Main();
        app.run();
    }

    private void run() {
        System.out.println("Enter the number of people:");
        int dataCount = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter all people:");
        for (int i = 0; i < dataCount; i++) {
            data.add(scanner.nextLine());
        }

        boolean isProgramRun = true;
        while (isProgramRun) {
            printMenu();
            Action action = Action.UNKNOWN;

            while (action == Action.UNKNOWN) {
                action = Action.getAction(Integer.parseInt(scanner.nextLine()));
            }

            switch (action) {
                case FIND:
                    findPerson();
                    break;
                case PRINT:
                    printPeople();
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

    private void findPerson() {
        System.out.println();
        System.out.println("Enter data to search people:");
        String query = scanner.nextLine().trim();

        List<String> result = new ArrayList<>();

        for (String el : data) {
            if (el.toLowerCase().contains(query.toLowerCase())) {
                result.add(el);
            }
        }

        if (!result.isEmpty()) {
            System.out.println();
            System.out.println("Found people:");
            result.forEach(System.out::println);
        } else {
            System.out.println("No matching people found.");
        }
    }

    private void printPeople() {
        System.out.println("=== List of people ===");
        data.forEach(System.out::println);
    }
}
