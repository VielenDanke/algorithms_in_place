package leetcode.dynamic_programming.java_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumIncreasingSubsequence_Algo {

    // DP
    /*
    Pattern:
    sums - [8, 12, 2, 3, 15, 5, 7]
    original leetcode.array - [8, 12, 2, 3, 15, 5, 7]


    for each value we try to understand is the number is element of increasing subsequence
    1) [8, 12, 2, 3, 15, 5, 7] - index 0
    2) [8, 20, 2, 3, 15, 5, 7] - index 1, 12 > 8 - we place at index 1 sum of 0 and 1 indexes which is 20
    3) [8, 20, 2, 3, 15, 5, 7] - index 2, 2 > 8? No. 2 > 12? No. So sum will be 2, it is start element of subsequence
    3) [8, 20, 2, 5, 15, 5, 7] - index 3, 2 > 8? No. 2 > 12? No. 3 > 2? Yes, we add 2 + 3 and place it in index 3
    4) [8, 20, 2, 5, 35, 5, 7] - index 4, 15 > 8? Yes, place Max(sums[0] + nums[4], sums[4]) 23.
                                          15 > 12? Yes, place Max(sums[1] + nums[4], sums[4]) 35.
                                          15 > 2? Yes, place Max(sums[2] + nums[4], sums[4]) still 35
                                          15 > 3? Yes, place Max(sums[3] + nums[4], sums[4]) still 35
     */

    public static List<List<Integer>> maxSumIncreasingSubsequenceDP(int[] array) {
        int N = array.length;
        int[] sequences = new int[N];
        Arrays.fill(sequences, Integer.MIN_VALUE);
        int[] sums = array.clone();
        int maxSumIdx = 0;
        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i];
            for (int j = 0; j < i; j++) {
                int otherNum = array[j];
                if (otherNum < currentNum && sums[j] + currentNum >= sums[i]) {
                    sums[i] = sums[j] + currentNum;
                    sequences[i] = j;
                }
            }
            if (sums[i] >= sums[maxSumIdx]) {
                maxSumIdx = i;
            }
        }
        return build(array, sequences, maxSumIdx, sums[maxSumIdx]);
    }

    private static List<List<Integer>> build(
            int[] array, int[] sequences, int currentIdx, int sums
    ) {
        List<List<Integer>> sequence = new ArrayList<>();
        sequence.add(new ArrayList<>());
        sequence.add(new ArrayList<>());
        sequence.get(0).add(sums);
        while (currentIdx != Integer.MIN_VALUE) {
            sequence.get(1).add(0, array[currentIdx]);
            currentIdx = sequences[currentIdx];
        }
        return sequence;
    }

    // --------------------------------------------------------------
    // Backtracking
    /*
    Pattern: find all increasing subsequences one by one and compare result sum
    Realisation: backtracking
    Example:
    [10, 70, 20, 30, 50, 11, 30]

    1) 10 -> 70 -> skip 20 -> skip 30 -> skip 50 -> skip 11 -> skip 30 = 80 Sum (70 >= all skipped leetcode.numbers)
    2) 10 -> 20 -> 30 -> 50 -> skip 11 -> skip 30 = 110 Sum (Notices we enter 10 and recursively returned from 70 and moved to 20)
     */

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        int[] sums = new int[array.length];
        backtrack(result, new ArrayList<>(), array, 0, 0, sums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] array, int start, int sum, int[] sums) {
        if (start >= array.length) {
            return;
        }
        for (int i = start; i < array.length; i++) {
            if ((!temp.isEmpty() && array[i] <= temp.get(temp.size() - 1)) || sums[i] != 0 && sums[i] < sum) {
                continue;
            }
            temp.add(array[i]);
            sum += array[i];
            sums[i] = Math.max(sums[i], sum);
            backtrack(result, temp, array, i + 1, sum, sums);
            calculateSum(result, temp, sum);
            sum -= temp.get(temp.size() - 1);
            temp.remove(temp.size() - 1);
        }
    }

    private static void calculateSum(List<List<Integer>> result, List<Integer> temp, int sum) {
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

    public static void main(String[] args) {
        MaxSumIncreasingSubsequence_Algo.maxSumIncreasingSubsequence(new int[]{10, 70, 20, 30, 50, 11, 30});
    }
}
