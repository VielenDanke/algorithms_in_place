package dynamic_programming.java_solutions;

public class MaxSubsetSumNonAdjacent {

    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }
        int[] result = new int[array.length];
        result[0] = array[0];
        result[1] = Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            result[i] = Math.max(result[i - 1], result[i - 2] + array[i]);
        }
        return result[result.length - 1];
    }
}
