package leetcode.array.medium.java_solutions;

import java.util.TreeMap;
import java.util.TreeSet;

public class LongestContinuousSubarrayWithAbsoluteDiff_1438 {

    static class Solution {
        public int longestSubarray(int[] nums, int limit) {
            int i = 0, j;
            TreeMap<Integer, Integer> m = new TreeMap<>();

            for (j = 0; j < nums.length; j++) {
                m.put(nums[j], m.getOrDefault(nums[j], 0) + 1);

                if (m.lastEntry().getKey() - m.firstEntry().getKey() > limit) {
                    m.put(nums[i], m.get(nums[i]) - 1);

                    if (m.get(nums[i]) == 0) m.remove(nums[i]);
                    i++;
                }
            }
            return j - i;
        }
    }

    static class SolutionSet {
        public int longestSubarray(int[] nums, int limit) {
            TreeSet<Integer> set = new TreeSet<>((i, j) -> nums[i] == nums[j] ? i - j : nums[i] - nums[j]);

            int left = 0, result = 1;

            set.add(left);

            for (int right = 1; right < nums.length; right++) {
                set.add(right);
                while (nums[set.last()] - nums[set.first()] > limit) {
                    set.remove(left++);
                }
                result = Math.max(result, right - left + 1);
            }
            return result;
        }
    }

}
