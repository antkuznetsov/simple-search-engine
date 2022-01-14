package search.strategies;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnySearchStrategy implements SearchStrategy {
    @Override
    public Set<Integer> search(String[] words, Map<String, Set<Integer>> index) {
        Set<Integer> res = new HashSet<>();
        for (String word : words) {
            if (index.containsKey(word)) {
                res.addAll(index.get(word));
            }
        }
        return res;
    }
}
