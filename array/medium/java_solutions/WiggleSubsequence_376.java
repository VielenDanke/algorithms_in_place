package array.medium.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class WiggleSubsequence_376 {

    private final Map<String, Integer> memo = new HashMap<>();

    public int wiggleMaxLength(int[] nums) {
        return Math.max(backtrack(nums, 0, false), backtrack(nums, 0, true)) + 1;
    }

    private int backtrack(int[] nums, int idx, boolean isGreater) {
        String key = createKey(idx, isGreater);
        if (memo.containsKey(key)) return memo.get(key);
        int max = 0;
        for (int i = idx + 1; i < nums.length; i++) {
            if ((isGreater && nums[i] > nums[idx]) || (!isGreater && nums[i] < nums[idx])) {
                max = Math.max(max, backtrack(nums, i, !isGreater) + 1);
            }
        }
        memo.put(key, max);
        return max;
    }

    private String createKey(int idx, boolean isGreater) {
        return String.format("%d-%b", idx, isGreater);
    }
}
