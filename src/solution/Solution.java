package solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        print5letters(intSet(args[0]));
    }

    private static Set<Character> intSet(String fileName) {
        Set<Character> result = new TreeSet<>();
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(fileName));
            String string = new String(bytes).toLowerCase();
            for (char ch : string.toCharArray()
            ) {
                if (ch >= 97 && ch <= 122)
                    result.add(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void print5letters(Set<Character> set) {
        set.stream()
                .limit(5)
                .forEach(System.out::print);
        System.out.println();
    }
}




