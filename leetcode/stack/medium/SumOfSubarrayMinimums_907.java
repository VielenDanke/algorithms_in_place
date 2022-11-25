package leetcode.stack.medium;

import java.util.Stack;

public class SumOfSubarrayMinimums_907 {

    static class Solution {
        public int sumSubarrayMins(int[] arr) {
            int n = arr.length;
            long result = 0, mod = (long) 1e9 + 7;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);

            for (int i = 0; i <= n; i++) {
                int current = i < n ? arr[i] : 0;

                while (stack.peek() != -1 && current < arr[stack.peek()]) {
                    int idx = stack.pop();
                    int mid = stack.peek();
                    int left = idx - mid;
                    int right = i - idx;
                    result += ((long) left * right * arr[idx]) % mod;
                    result %= mod;
                }
                stack.push(i);
            }
            return (int) result;
        }
    }

    // O(N^2)
    static class SolutionTimeLimitExceededBetter {

        public int sumSubarrayMins(int[] arr) {
            int result = 0, n = arr.length, mod = (int) 1e9 + 7;
            for (int i = 0; i < n; i++) {
                int min = arr[i];
                for (int j = i; j >= 0; j--) {
                    min = Math.min(min, arr[j]);
                    result += min;
                    result %= mod;
                }
            }
            return result;
        }
    }

    // O(N^3)
    static class SolutionTimeLimitExceeded {

        public int sumSubarrayMins(int[] arr) {
            int window = 1, mod = (int) 1e9 + 7, result = 0;

            while (window <= arr.length) {
                for (int i = 0; i + window <= arr.length; i++) {
                    result += findMin(arr, i, i + window);
                    result %= mod;
                }
                window++;
            }
            return (int) result;
        }

        private int findMin(int[] arr, int start, int end) {
            int min = arr[start];
            for (int i = start + 1; i < end; i++) {
                min = Math.min(min, arr[i]);
            }
            return min;
        }
    }
}
