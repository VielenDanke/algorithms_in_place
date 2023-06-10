package leetcode.array.medium.java_solutions;

public class MaximumValueAtAGivenIndexInABoundedArray_1802 {

    static class Solution {
        public int maxValue(int n, int index, int maxSum) {
            int left = 1, right = maxSum;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (sum(index, mid, n) <= maxSum) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            return left;
        }

        private long sum(int index, int middle, int n) {
            long count = 0;

            if (middle > index) {
                count += (long) (middle + middle - index) * (index + 1) / 2;
            } else {
                count += (long) (middle + 1) * middle / 2 + index - middle + 1;
            }
            if (middle >= n - index) {
                count += (long) (middle + middle - n + 1 + index) * (n - index) / 2;
            } else {
                count += (long) (middle + 1) * middle / 2 + n - index - middle;
            }
            return count - middle;
        }
    }

    static class SolutionBruteForce {
        public int maxValue(int n, int index, int maxSum) {
            int[] arr = new int[n];
            int sumToPlace = maxSum;

            while (sumToPlace > 0) {
                arr[index] = sumToPlace;
                int tempSum = sumToPlace;
                int currentSum = sumToPlace;

                int left = index - 1, right = index + 1;

                boolean isExids = false;

                while (left >= 0 || right < arr.length) {
                    if (tempSum > 1) {
                        tempSum--;
                    }
                    if (left >= 0) {
                        arr[left] = tempSum;
                        sumToPlace += tempSum;
                    }
                    if (sumToPlace > maxSum) {
                        isExids = true;
                        break;
                    }
                    if (right < arr.length) {
                        arr[right] = tempSum;
                        sumToPlace += tempSum;
                    }
                    if (sumToPlace > maxSum) {
                        isExids = true;
                        break;
                    }
                    left--;
                    right++;
                }
                if (isExids) {
                    sumToPlace = currentSum - 1;
                } else {
                    return arr[index];
                }
            }
            return arr[index];
        }
    }
}
