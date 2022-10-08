package leetcode.array.medium.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class MinOperationsToReduceXToZero_1658 {

    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) sum += num;

        int left = 0, right = 0, maxLen = -1, currentSum = 0;

        while (right < nums.length) {
            currentSum += nums[right];
            while (left <= right && currentSum > sum - x) currentSum -= nums[left++];
            if (currentSum == sum - x) maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen == -1 ? -1 : nums.length - maxLen;
    }

    // ----------------------------------------------------------------------------------

    public int minOperationsWithMap(int[] nums, int x) {
        int target = -x;
        for (int num : nums) target += num;

        if (target == 0) return nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, i - map.get(sum - target));
            }
            map.put(sum, i);
        }
        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }

    // -----------------------------------------------------------------------------------

    public int minOperationsRec(int[] nums, int x) {
        // try left, try right, cut leetcode.array
        int min = minOperationsRecursive(nums, x, 0, nums.length - 1);
        return min >= 1 << 30 ? -1 : min;
    }

    public int minOperationsRecursive(int[] nums, int x, int mostLeft, int mostRight) {
        if (x == 0) {
            return 0;
        } else if (x < 0) {
            return 1 << 30;
        } else if (mostLeft > mostRight) {
            return 1 << 30;
        }
        int left = minOperationsRecursive(nums, x - nums[mostLeft], mostLeft + 1, mostRight);
        int right = minOperationsRecursive(nums, x - nums[mostRight], mostLeft, mostRight - 1);
        return Math.min(left, right) + 1;
    }
}
