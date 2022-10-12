package leetcode.array.medium.java_solutions;

import java.util.Arrays;
import java.util.Random;

public class MinimumMovesToEqualArrayElements_462 {

    static class Solution {

        public int minMoves2(int[] nums) {
            Arrays.sort(nums);
            int left = 0, right = nums.length - 1, result = 0;
            while (left < right) {
                result += nums[right--] - nums[left++];
            }
            return result;
        }
    }

    static class SolutionQuickSelect {

        private final Random random = new Random();

        public int minMoves2(int[] nums) {
            int operations = 0, mid = quickSelect(nums, 0, nums.length - 1, nums.length / 2);
            for (int num : nums) operations += Math.abs(mid - num);
            return operations;
        }

        private int quickSelect(int[] nums, int left, int right, int k) {
            if (left == right) return nums[left];

            int pIndex = random.nextInt(right - left + 1) + left;

            pIndex = partition(nums, left, right, pIndex);

            if (pIndex == k) {
                return nums[k];
            } else if (pIndex < k) {
                return quickSelect(nums, pIndex + 1, right, k);
            }
            return quickSelect(nums, left, pIndex - 1, k);
        }

        private int partition(int[] nums, int left, int right, int pIndex) {
            int pivot = nums[pIndex];

            swap(nums, pIndex, right);

            pIndex = left;

            for (int i = left; i <= right; i++)
                if (nums[i] <= pivot) swap(nums, i, pIndex++);
            return pIndex - 1;
        }

        private void swap(int[] nums, int x, int y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }
    }
}
