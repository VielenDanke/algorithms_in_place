package leetcode.array.easy.java_solutions;

import java.util.HashSet;
import java.util.Set;

public class KthMissingPositiveNumber_1539 {

    static class Solution {
        public int findKthPositive(int[] arr, int k) {
            int left = 0, right = arr.length, middle;
            while (left < right) {
                middle = (left + right) / 2;
                if (arr[middle] - 1 - middle < k) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            return left + k;
        }
    }

    static class SolutionBruteForce {
        public int findKthPositive(int[] arr, int k) {
            int max = Integer.MIN_VALUE;

            Set<Integer> existed = new HashSet<>();

            for (int num : arr) {
                max = Math.max(max, num);
                existed.add(num);
            }
            for (int i = 1; i <= max; i++) {
                if (!existed.contains(i) && --k == 0) {
                    return i;
                }
            }
            while (k-- > 0) {
                max++;
            }
            return max;
        }
    }
}
