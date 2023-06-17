package leetcode.array.hard.java_solutions;

import java.util.Arrays;
import java.util.TreeSet;

public class MakeArrayStrictlyIncreasing_1187 {

    static class Solution {
        public int makeArrayIncreasing(int[] arr1, int[] arr2) {
            TreeSet<Integer> set = new TreeSet<>(Arrays.stream(arr2).boxed().toList());

            int m = arr2.length, max = Integer.MAX_VALUE;

            int[] dp = new int[m + 1];

            dp[0] = -1;

            for (int k : arr1) {
                for (int j = m; j >= 0; j--) {
                    int a = k > dp[j] ? k : max; // option arr1 - don't swap
                    Integer b = set.higher(j == 0 ? max : dp[j - 1]); // option arr2 - swap
                    dp[j] = Math.min(a, b == null ? max : b); // take the min of arr1 and arr2
                }
            }
            for (int i = 0; i <= m; i++) {
                if (dp[i] != max) {
                    return i;
                }
            }
            return -1;
        }
    }
}
