package array.medium.java_solutions;

import java.util.*;

public class LargestRange_Algo {

    public static int[] largestRange(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{-1, -1};
        }
        Map<Integer, Boolean> visited = new HashMap<>();
        int[] max = new int[]{array[0], array[0]};
        for (int num : array) {
            visited.put(num, false);
        }
        for (int i = 0; i < array.length && !visited.get(array[i]); i++) {
            int num = array[i];
            if (visited.get(num)) {
                continue;
            }
            int left = num, right = num;
            while (visited.containsKey(left - 1)) {
                visited.put(left--, true);
            }
            while (visited.containsKey(right + 1)) {
                visited.put(right++, true);
            }
            if (Math.abs(left - right) > Math.abs(max[0] - max[1])) {
                max[0] = left;
                max[1] = right;
            }
        }
        return max;
    }

    // ------------------------------------------------------------------------------

    public static int[] largestRangeSort(int[] array) {
        if (array == null || array.length == 0) return new int[]{};
        Arrays.sort(array);
        int[] max = new int[2];
        max[0] = array[0];
        max[1] = array[0];
        for (int i = 0; i + 1 < array.length; i++) {
            if (Math.abs(array[i] - array[i + 1]) == 1) {
                int j = i;
                while (j + 1 < array.length && Math.abs(array[j] - array[j + 1]) <= 1) {
                    j++;
                }
                if (Math.abs(array[j] - array[i]) > Math.abs(max[1] - max[0])) {
                    max[0] = array[i];
                    max[1] = array[j];
                }
                i = j;
            }
        }
        return max;
    }

    // -------------------------------------------------------------------------------------------

    public static int[] largestRangeSet(int[] array) {
        // Write your code here.
        Set<Integer> set = new HashSet<>();
        int[] max = new int[]{array[0], array[0]};
        for (int num : array) {
            set.add(num);
        }
        for (int num : array) {
            int current = num;
            while (set.contains(current)) {
                current++;
            }
            current--;
            if (Math.abs(num - current) > Math.abs(max[0] - max[1])) {
                max[0] = num;
                max[1] = current;
            }
        }
        return max;
    }
}
