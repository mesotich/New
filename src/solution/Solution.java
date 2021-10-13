package solution;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;



/*
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class<?> getExpectedClass() {
        List<Class<?>> classList = new ArrayList<>(Arrays.asList(Collections.class.getDeclaredClasses()));
        for (int i = 0; i < classList.size(); i++) {
            Class<?>[] classes = classList.get(i).getDeclaredClasses();
            if (classes.length != 0) {
                classList.addAll(Arrays.asList(classes));
            }
        }
        classList = classList.stream()
                .filter(List.class::isAssignableFrom)
                .filter(a -> Modifier.isPrivate(a.getModifiers()))
                .filter(a -> Modifier.isStatic(a.getModifiers()))
                .collect(Collectors.toList());
        for (Class<?> cl : classList
        ) {
            try {
                Method method = cl.getMethod("get", int.class);
                method.setAccessible(true);
                Constructor<?> constructor = cl.getDeclaredConstructor();
                constructor.setAccessible(true);
                method.invoke(constructor.newInstance(), 1);
            } catch (Exception e) {
                if (e.getCause() instanceof IndexOutOfBoundsException)
                    return cl;
            }
        }
        return null;
    }
}
