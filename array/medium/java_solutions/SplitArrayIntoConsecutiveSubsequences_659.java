package array.medium.java_solutions;

import java.util.HashMap;

public class SplitArrayIntoConsecutiveSubsequences_659 {

    private static class Solution {
        public boolean isPossible(int[] nums) {
            var freq = new HashMap<Integer, Integer>();
            var append = new HashMap<Integer, Integer>();
            for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);
            for (int n : nums) {
                if (freq.getOrDefault(n, 0) == 0) {
                    continue;
                } else if (append.getOrDefault(n, 0) > 0) {
                    append.put(n, append.get(n) - 1);
                    append.put(n + 1, append.getOrDefault(n + 1, 0) + 1);
                } else if (freq.getOrDefault(n + 1, 0) > 0 && freq.getOrDefault(n + 2, 0) > 0) {
                    freq.put(n + 1, freq.getOrDefault(n + 1, 0) - 1);
                    freq.put(n + 2, freq.getOrDefault(n + 2, 0) - 1);
                    append.put(n + 3, append.getOrDefault(n + 3, 0) + 1);
                } else {
                    return false;
                }
                freq.put(n, freq.get(n) - 1);
            }
            return true;
        }
    }
}
