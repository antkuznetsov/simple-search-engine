package search;

import search.strategies.AllSearchStrategy;
import search.strategies.AnySearchStrategy;
import search.strategies.NoneSearchStrategy;
import search.strategies.SearchStrategy;

import java.util.*;

public class SearchEngine {
    private final List<String> data = new ArrayList<>();
    private final Map<String, Set<Integer>> index = new HashMap<>();

    private SearchStrategy searchStrategy;
    private int currentIdx = 0;

    public void search(String query) {
        if (searchStrategy == null) {
            throw new IllegalStateException("Set search strategy first!");
        }
        Set<Integer> res = searchStrategy.search(query.split("\\s+"), index);
        for (int el : res) {
            System.out.println(data.get(el));
        }
    }

    public void addData(String content) {
        data.add(content);
        for (String word : content.split("\\s+")) {
            word = word.toLowerCase(Locale.ROOT);
            if (index.containsKey(word)) {
                index.get(word).add(currentIdx);
            } else {
                Set<Integer> positions = new HashSet<>();
                positions.add(currentIdx);
                index.put(word, positions);
            }
        }
        currentIdx++;
    }

    public void printData(String title) {
        System.out.println(title);
        data.forEach(System.out::println);
    }

    public void setSearchStrategy(String strategyName) {
        switch (strategyName) {
            case "ALL":
                this.searchStrategy = new AllSearchStrategy();
                break;
            case "ANY":
                this.searchStrategy = new AnySearchStrategy();
                break;
            case "NONE":
                this.searchStrategy = new NoneSearchStrategy();
                break;
            default:
                throw new IllegalStateException();
        }
    }
}
