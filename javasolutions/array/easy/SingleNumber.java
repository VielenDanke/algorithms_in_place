package javasolutions.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SingleNumber {

    public static int singleNumberBetter(int[] nums) {
        int count = 0;

        for (int i : nums) {
            count ^= i;
        }
        return count;
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> visited = new HashMap<>();
        for (int i : nums) {
            if (visited.containsKey(i)) {
                visited.put(i, visited.get(i) + 1);
            } else {
                visited.put(i, 1);
            }
        }
        return visited.entrySet().stream().filter(entrySet -> entrySet.getValue() == 1).map(Entry::getKey).findFirst().orElse(-1);
    }
}
