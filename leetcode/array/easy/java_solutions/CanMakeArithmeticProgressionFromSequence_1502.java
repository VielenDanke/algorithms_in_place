package leetcode.array.easy.java_solutions;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence_1502 {

    static class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            if (arr == null) {
                return false;
            }
            int n = arr.length;

            if (n <= 2) {
                return true;
            }
            Arrays.sort(arr);

            int diff = arr[1] - arr[0];

            for (int i = 2; i < n; i++) {
                if (arr[i] - arr[i - 1] != diff) {
                    return false;
                }
            }
            return true;
        }
    }
}
