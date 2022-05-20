package sorting.medium.java_solutions;

public class SubarraySort_Algo {

    public static int[] subarraySort(int[] array) {
        // Write your code here.
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (isOutOfOrder(i, num, array)) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }
        if (min == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        int subLeftIdx = 0;
        while (min >= array[subLeftIdx]) {
            subLeftIdx++;
        }
        int subRightIdx = array.length - 1;
        while (max <= array[subRightIdx]) {
            subRightIdx--;
        }
        return new int[]{subLeftIdx, subRightIdx};
    }

    private static boolean isOutOfOrder(int i, int num, int[] array) {
        if (i == 0) {
            return num > array[i + 1];
        }
        if (i == array.length - 1) {
            return num < array[i - 1];
        }
        return num > array[i + 1] || num < array[i - 1];
    }
}
