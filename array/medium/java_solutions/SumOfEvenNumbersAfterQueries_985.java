package array.medium.java_solutions;

public class SumOfEvenNumbersAfterQueries_985 {

    static class Solution {
        public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
            int n = nums.length;
            int evenSum = 0;
            int[] evenFinder = new int[n];

            for (int i = 0; i < n; i++) {
                int num = nums[i];
                if (num % 2 == 0) {
                    evenSum += num;
                    evenFinder[i] = num;
                }
            }
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                int[] currentQuery = queries[i];
                int idx = currentQuery[1];
                int val = currentQuery[0];
                int newVal = nums[idx] = nums[idx] + val;
                if (evenFinder[idx] != 0) {
                    if (newVal % 2 == 0) {
                        evenSum += newVal - evenFinder[idx];
                        evenFinder[idx] = newVal;
                    } else {
                        evenSum -= evenFinder[idx];
                        evenFinder[idx] = 0;
                    }
                } else {
                    if (newVal % 2 == 0) {
                        evenSum += newVal;
                        evenFinder[idx] = newVal;
                    }
                }
                result[i] = evenSum;
            }
            return result;
        }
    }

    static class SolutionBruteForce {
        public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
            int n = nums.length;
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                int[] currentQuery = queries[i];
                nums[currentQuery[1]] += currentQuery[0];
                int sum = 0;
                for (int currentNum : nums) {
                    if (currentNum % 2 == 0) {
                        sum += currentNum;
                    }
                }
                result[i] = sum;
            }
            return result;
        }
    }
}
