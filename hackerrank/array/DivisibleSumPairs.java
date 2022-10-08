package hackerrank.array;

import java.util.List;

public class DivisibleSumPairs {

    static class Solution {
        public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
            // Write your code here
            int [] bucket = new int[k];
            int count = 0;
            for (int value : ar) {
                int modValue = value % k;
                count += bucket[(k - modValue) % k];
                bucket[modValue]++;
            }
            return count;
        }
    }

    static class SolutionBruteForce {
        public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
            // Write your code here
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((ar.get(i) + ar.get(j)) % k == 0) result++;
                }
            }
            return result;
        }
    }
}
