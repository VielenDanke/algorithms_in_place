package leetcode.sorting.medium.java_solutions;

import java.util.Arrays;

public class LargestPerimeterTriangle_976 {

    static class Solution {
        public int largestPerimeter(int[] array) {
            Arrays.sort(array);
            for (int i = array.length - 1; i > 1; --i)
                if (array[i] < array[i - 1] + array[i - 2])
                    return array[i] + array[i - 1] + array[i - 2];
            return 0;
        }
    }
}
