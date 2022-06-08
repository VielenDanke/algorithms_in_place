package dynamic_programming.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class MaxSumIncreasingSubsequence_Algo {

    // --------------------------------------------------------------
    // Backtracking

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), array, 0, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] array, int start, int sum) {
        if (start >= array.length) {
            return;
        }
        for (int i = start; i < array.length; i++) {
            if (!temp.isEmpty() && array[i] <= temp.get(temp.size() - 1)) {
                continue;
            }
            temp.add(array[i]);
            sum += array[i];
            backtrack(result, temp, array, i + 1, sum);
            compareAndReplaceSumIfGreater(result, temp, sum);
            sum -= temp.get(temp.size() - 1);
            temp.remove(temp.size() - 1);
        }
    }

    private static void compareAndReplaceSumIfGreater(List<List<Integer>> result, List<Integer> temp, int sum) {
        if (result.size() == 0) {
            result.add(new ArrayList<>() {{
                add(sum);
            }});
            result.add(new ArrayList<>(temp));
        } else {
            if (result.get(0).get(0) < sum) {
                result.set(0, new ArrayList<>() {{
                    add(sum);
                }});
                result.set(1, new ArrayList<>(temp));
            }
        }
    }
}
