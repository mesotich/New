import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ConvertableUtil {
    public static <K, V extends Convertable<K>> Map<K, V> convert(List<V> list) {
        Map<K, V> result = new HashMap<>();
        list.forEach(i -> result.put(i.getKey(), i));
        return result;
    }
}