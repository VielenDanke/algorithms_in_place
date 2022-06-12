package array.medium.java_solutions;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue_1695 {

    // O(N) time | O(N) space

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

    // ----------------------------------------------------------------------
    // O(N) time | O(1) space (Since boolean array has a constant size of 10001 it becomes redundant)

    public int maximumUniqueSubarrayArray(int[] nums) {
        int N = nums.length;
        int maxNumber = 10001;
        boolean[] visited = new boolean[maxNumber];
        int i = 0, j = 0, sum = 0, res = 0;

        while (j < N) {
            while (j < N && !visited[nums[j]]) {
                visited[nums[j]] = true;
                sum += nums[j++];
            }
            res = Math.max(res, sum);

            while (j < N && visited[nums[j]]) {
                visited[nums[i]] = false;
                sum -= nums[i++];
            }
        }
        return res;
    }

    // ---------------------------------------------------------------------
    // O(N^2) time | O(N) space

    public int maximumUniqueSubarrayBruteForce(int[] nums) {
        int sum = 0, N = nums.length;

        for (int i = 0; i < N; i++) {
            int tempSum = 0;
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < N; j++) {
                if (!set.add(nums[j])) {
                    sum = Math.max(sum, tempSum);
                    break;
                }
                tempSum += nums[j];
            }
            sum = Math.max(sum, tempSum);
        }
        return sum;
    }
}
