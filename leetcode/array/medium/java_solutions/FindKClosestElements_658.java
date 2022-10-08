package leetcode.array.medium.java_solutions;

import java.util.*;

public class FindKClosestElements_658 {

    static class SolutionTwoPointers {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = 0, right = arr.length - 1;

            while (right - left >= k) {
                if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                    left++;
                } else {
                    right--;
                }
            }
            List<Integer> result = new ArrayList<>();
            for (int i = left; i <= right; i++) result.add(arr[i]);
            return result;
        }
    }

    static class Solution {
        /*
        arr = [1,2,3,4,5]
        k = 4
        x = 3

        Iterations:
        1. left = 0, right = 5 - k (1), middleIdx = 0
        2. left = 0, right = 0, end of the loop

        result = arr[left, left + k] elements
         */
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = 0, right = arr.length - k;

            while (left < right) {
                int middleIdx = left + (right - left) / 2;
                if (x - arr[middleIdx] > arr[middleIdx + k] - x) {
                    left = middleIdx + 1;
                } else {
                    right = middleIdx;
                }
            }
            List<Integer> result = new ArrayList<>();

            for (int i = left; i < left + k; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        public static void main(String[] args) {
            new Solution().findClosestElements(new int[]{1,2,3,4,5}, 4, 3);
        }
    }

    static class SolutionBruteForce {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /*
        1. Find index position of element x
        2. Find closest k elements to idx of x
        3. if arr[idx] != x (we couldn't find anything) - count element at possible idx + all the closest elements
           if arr[idx] == x (we found element) - count all the closest elements around
        4. to find the closest elements
           a is closer to b if Math.abs(a - x) < Math.abs(b - x) || (Math.abs(a - x) == Math.abs(b - x) and a < b)
        */
            if (arr == null || arr.length == 0) return new ArrayList<>();

            int idx = findIndexPosition(arr, x);

            return collectClosestElements(arr, idx, k, x);
        }

        private List<Integer> collectClosestElements(int[] arr, int idx, int k, int x) {
            int left = idx - 1, right = idx, n = arr.length;

            List<Integer> list = new LinkedList<>();

            while (left >= 0 && right < n && k > 0) {
                int leftCalc = Math.abs(arr[left] - x);
                int rightCalc = Math.abs(arr[right] - x);
                if (leftCalc < rightCalc || (leftCalc == rightCalc) && arr[left] < arr[right]) {
                    list.add(arr[left--]);
                } else {
                    list.add(arr[right++]);
                }
                k--;
            }
            while (left >= 0 && k > 0) {
                list.add(arr[left--]);
                k--;
            }
            while (right < n && k > 0) {
                list.add(arr[right++]);
                k--;
            }
            list.sort(Comparator.comparingInt(i -> i));
            return list;
        }

        private int findIndexPosition(int[] arr, int x) {
            int left = 0, right = arr.length - 1;

            while (left <= right) {
                int middle = left + (right - left) / 2;
                int candidate = arr[middle];

                if (candidate == x) {
                    return middle;
                } else if (candidate > x) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            return left;
        }
    }
}
