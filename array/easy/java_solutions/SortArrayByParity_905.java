package array.easy.java_solutions;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayByParity_905 {

    public int[] sortArrayByParity(int[] nums) {
        return mergeSort(nums);
    }

    private int[] mergeSort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int middle = nums.length / 2;
        int[] leftArray = Arrays.copyOfRange(nums, 0, middle);
        int[] rightArray = Arrays.copyOfRange(nums, middle, nums.length);

        return merge(leftArray, rightArray);
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        int[] result = new int[leftArray.length + rightArray.length];

        int start = 0, end = result.length - 1;

        for (int j : leftArray) {
            if (j % 2 == 0) {
                result[start] = j;
                start++;
            } else {
                result[end] = j;
                end--;
            }
        }
        for (int j : rightArray) {
            if (j % 2 == 0) {
                result[start] = j;
                start++;
            } else {
                result[end] = j;
                end--;
            }
        }
        return result;
    }
}
