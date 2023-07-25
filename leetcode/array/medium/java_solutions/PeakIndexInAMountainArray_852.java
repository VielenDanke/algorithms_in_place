package leetcode.array.medium.java_solutions;

public class PeakIndexInAMountainArray_852 {

    static class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int left = 0, right = arr.length - 1;

            while (left < right) {
                int middle = left + (right - left) / 2;

                if (middle != 0 && arr[middle - 1] < arr[middle] && middle != arr.length - 1 && arr[middle] > arr[middle + 1]) {
                    return middle;
                } else if (middle != 0 && arr[middle - 1] > arr[middle]) {
                    right = middle - 1;
                } else if (middle != arr.length - 1 && arr[middle + 1] > arr[middle]) {
                    left = middle + 1;
                }
            }
            return left;
        }
    }
}
