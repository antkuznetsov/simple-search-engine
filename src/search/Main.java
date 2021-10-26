package search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final Map<String, Integer> data = new HashMap<>();

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    private void run() {
        String[] words = scanner.nextLine().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            data.put(words[i], i + 1);
        }
        String request = scanner.nextLine();
        System.out.println(data.get(request) == null ? "Not found" : data.get(request));
    }
}
