import java.util.*;
import java.util.stream.IntStream;

/*
Collections & Generics
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        return new ArrayList<T>(Arrays.asList(elements));
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        return new HashSet<T>(Arrays.asList(elements));
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        HashMap<K, V> result = new HashMap<>();
        if (keys.size() != values.size())
            throw new IllegalArgumentException();
        IntStream.range(0, keys.size()).forEach(i -> result.put(keys.get(i), values.get(i)));
        return result;
    }
}