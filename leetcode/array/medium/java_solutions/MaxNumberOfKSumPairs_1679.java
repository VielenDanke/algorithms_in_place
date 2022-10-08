package leetcode.array.medium.java_solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs_1679 {

    /*
    1. Sort leetcode.array and use advance of two pointers (if sum > target - decrease right, if sum < target - increase left)
    2. Using visited leetcode.array - if we find a sum, we will mark index as visited
     */

    /*
    O(N * logN) time | O(1) space
     */
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1, operations = 0;

        while (left < right) {
            int tempSum = nums[left] + nums[right];

            if (tempSum > k) {
                right--;
            } else if (tempSum < k) {
                left++;
            } else {
                left++;
                right--;
                operations++;
            }
        }
        return operations;
    }

    /*
    O(N) time | O(N) space
     */
    public int maxOperationsWithMap(int[] nums, int k) {
        int operations = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int val : nums) {
            int tempDiff = k - val;

            if (map.containsKey(tempDiff) && map.get(tempDiff) > 0) {
                map.computeIfPresent(tempDiff, (key, value) -> --value);
                operations++;
            } else {
                map.compute(val, (key, value) -> {
                    if (value == null) {
                        return 1;
                    }
                    return ++value;
                });
            }
        }
        return operations;
    }

    /*
    Time limit exceeded | O(N^2) time | O(N) space
     */
    public int maxOperationsWithVisited(int[] nums, int k) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int operations = 0;

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (visited[j]) {
                    continue;
                }
                if (nums[i] + nums[j] == k && !visited[i] && !visited[j]) {
                    operations++;
                    visited[i] = true;
                    visited[j] = true;
                }
            }
        }
        return operations;
    }
}
