package search;

import java.util.*;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> data = new ArrayList<>();
    private final List<String> result = new ArrayList<>();

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

        System.out.println();
        System.out.println("Enter the number of search queries:");
        int queriesCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < queriesCount; i++) {
            System.out.println();
            System.out.println("Enter data to search people:");
            String query = scanner.nextLine().trim();

            result.clear();

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
    }
}
