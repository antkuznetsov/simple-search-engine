package search.strategies;

import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class NoneSearchStrategy implements SearchStrategy {
    @Override
    public Set<Integer> search(String[] words, Map<String, Set<Integer>> index) {
        Set<Integer> res = new HashSet<>();
        for (Set<Integer> positions : index.values()) {
            res.addAll(positions);
        }
        for (String word : words) {
            if (index.containsKey(word.toLowerCase(Locale.ROOT))) {
                res.removeAll(index.get(word.toLowerCase(Locale.ROOT)));
            }
        }
        return res;
    }
}
