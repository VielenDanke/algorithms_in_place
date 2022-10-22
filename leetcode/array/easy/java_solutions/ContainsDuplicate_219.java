package leetcode.array.easy.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate_219 {

    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            final Map<Integer, Integer> m = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int current = nums[i];

                if (m.containsKey(current)) {
                    if (i - m.get(current) <= k) {
                        return true;
                    }
                }
                m.put(current, i);
            }
            return false;
        }
    }

    static class SolutionBruteForce {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
