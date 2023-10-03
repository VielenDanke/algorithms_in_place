package leetcode.array.easy.java_solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfGoodPairs_1512 {

    static class Solution {
        public int numIdenticalPairs(int[] nums) {
            new StringBuilder().trimToSize();
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.merge(num, 1, Integer::sum);
            }
            int counter = 0;
            for (int val : map.values()) {
                counter += (val * (val - 1)) / 2;
            }
            return counter;
        }
    }

    static class SolutionBruteForce {
        public int numIdenticalPairs(int[] nums) {
            int counter = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] == nums[j]) {
                        counter++;
                    }
                }
            }
            return counter;
        }
    }
}
