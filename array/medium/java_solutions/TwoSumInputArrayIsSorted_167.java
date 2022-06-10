package array.medium.java_solutions;

import java.util.HashMap;

public class TwoSumInputArrayIsSorted_167 {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int idx = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (idx != -1) {
                return new int[]{i + 1, idx + 1};
            }
        }
        return null;
    }

    private int binarySearch(int[] numbers, int left, int right, int diff) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midNum = numbers[mid];
            if (diff == midNum) {
                return mid;
            } else if (diff < midNum) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // --------------------------------------------------------------------------------------------------------

    public int[] twoSumDict(int[] numbers, int target) {
        var dict = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; i++) {
            var diff = target - numbers[i];
            if (dict.containsKey(diff)) {
                return new int[]{dict.get(diff) + 1, i + 1};
            }
            dict.put(numbers[i], i);
        }
        return null;
    }

    // -------------------------------------------------------------------------------------------------------

    public int[] twoSumTwoPointers(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int tempSum = numbers[left] + numbers[right];
            if (tempSum == target) {
                return new int[]{left, right};
            } else if (tempSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
