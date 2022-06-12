package array.medium.java_solutions;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue_1695 {

    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> window = new HashSet<>();

        int left = 0, right = 0, N = nums.length, max = 0, sum = 0;

        while (right < N) {
            if (window.add(nums[right])) {
                sum += nums[right++];
                max = Math.max(sum, max);
            } else {
                sum -= nums[left];
                window.remove(nums[left++]);
            }
        }
        return max;
    }
}
