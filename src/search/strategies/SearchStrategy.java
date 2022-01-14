package search.strategies;

import java.util.Map;
import java.util.Set;

public interface SearchStrategy {
    Set<Integer> search(String[] words, Map<String, Set<Integer>> index);
}
