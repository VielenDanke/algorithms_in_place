package dynamic_programming.java_solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WiggleSubsequence_376 {

    // DP
    public int wiggleMaxLengthDP(int[] nums) {
        if (nums.length == 0) return 0;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(down[nums.length - 1], up[nums.length - 1]);
    }

    // --------------------------------------------------------------------------------------------------------------
    // memo
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
