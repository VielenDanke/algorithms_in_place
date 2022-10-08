package leetcode.array.easy.java_solutions;

public class PeakIndexInMountainArray_852 {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;

            if (arr[middle] < arr[middle + 1]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }

    public int peakIndexInMountainArrayIterative(int[] arr) {
        int maxIdx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
