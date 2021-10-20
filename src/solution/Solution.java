package solution;

import java.util.HashSet;
import java.util.Set;

/*
Сколько у человека потенциальных друзей?
*/

public class Solution {
    private boolean[][] humanRelationships;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.humanRelationships = generateRelationships();
        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends(4, 2);
        System.out.println(allFriendsAndPotentialFriends); // Expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends); // Expected: [2, 5, 7]
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        Set<Integer> result = new HashSet<>();
        if (deep < 1)
            return result;
        result.addAll(getFriends(index));
        Set<Integer> friends = new HashSet<>();
        for (int d = 2; d <= deep; d++) {
            friends.clear();
            for (int res : result
            ) {
                friends.addAll(getFriends(res));
            }
            result.addAll(friends);
        }
        result.remove(index);
        return result;
//напишите тут ваш код
    }

    private Set<Integer> getFriends(int index) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < humanRelationships.length; i++) {
            if (i < index && humanRelationships[index][i])
                set.add(i);
            if (i > index && humanRelationships[i][index])
                set.add(i);
        }
        return set;
    }
// Remove from the set the people with whom you already have a relationship

    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humanRelationships.length; i++) {
            if ((i < index) && (index < humanRelationships.length) && humanRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humanRelationships[i][index]) {
                set.remove(i);
            }
        }
        return set;
    }
// Return test data

    private static boolean[][] generateRelationships() {
        return new boolean[][]{
                {true}, //0
                {true, true}, //1
                {false, true, true}, //2
                {false, false, false, true}, //3
                {true, true, false, true, true}, //4
                {true, false, true, false, false, true}, //5
                {false, false, false, false, false, true, true}, //6
                {false, false, false, true, false, false, false, true} //7
        };
    }
}