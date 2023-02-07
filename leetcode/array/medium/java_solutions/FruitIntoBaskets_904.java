package leetcode.array.medium.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets_904 {

    static class Solution {

        public int totalFruit(int[] fruits) {
            Map<Integer, Integer> count = new HashMap<>();
            int left = 0, right;
            int n = fruits.length;
            for (right = 0; right < n; ++right) {
                count.put(fruits[right], count.getOrDefault(fruits[right], 0) + 1);
                if (count.size() > 2) {
                    count.put(fruits[left], count.get(fruits[left]) - 1);
                    count.remove(fruits[left++], 0);
                }
            }
            return right - left;
        }
    }

    static class SolutionIteration {

        public int totalFruit(int[] fruits) {
            Map<Integer, Integer> storage = new HashMap<>();
            int left = 0, right = 0, max = 0, n = fruits.length;
            while (right < n) {
                storage.put(fruits[right], storage.getOrDefault(fruits[right], 0) + 1);
                while (storage.size() > 2) {
                    storage.put(fruits[left], storage.get(fruits[left]) - 1);
                    storage.remove(fruits[left], 0);
                    left++;
                }
                max = Math.max(max, right - left + 1);
                right++;
            }
            return max;
        }
    }
}
