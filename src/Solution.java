import java.util.ArrayList;
import java.util.List;

public class Solution<T extends Number, L extends List<Solution.SomeClass<T>>> {
    public static class SomeClass<T extends Number> {
        private T t;

        public SomeClass(T t) {
            this.t = t;
        }

        public void print() {
            System.out.println("T = " + t.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        Solution<Integer,ArrayList<Solution.SomeClass<Integer>>> solution = new Solution();
    }
}
