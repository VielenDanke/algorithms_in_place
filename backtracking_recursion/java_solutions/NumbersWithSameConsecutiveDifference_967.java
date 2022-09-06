package backtracking_recursion.java_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifference_967 {

    private static class Solution {
        public int[] numsSameConsecDiff(int n, int k) {
        /*
        1. no leading 0 means 1 number is always greater than 0
        2. difference between numbers - k
        */
            List<String > list = new ArrayList<>();
            backtrack(list, new StringBuilder(), n, k);
            return list.stream().mapToInt(Integer::parseInt).toArray();
        }

        private void backtrack(List<String> list, StringBuilder temp, int n, int k) {
            if (temp.length() == n) {
                list.add(temp.toString());
                return;
            }
            for (int i = 0; i <= 9; i++) {
                if (i == 0 && temp.isEmpty()) {
                    continue;
                }
                if (temp.isEmpty() || Math.abs((temp.charAt(temp.length() - 1) - '0') - i) == k) {
                    temp.append(i);
                    backtrack(list, temp, n, k);
                    temp.deleteCharAt(temp.length() - 1);
                }
            }
        }
    }
}
