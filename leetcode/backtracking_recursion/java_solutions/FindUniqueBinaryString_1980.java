package leetcode.backtracking_recursion.java_solutions;

import java.util.*;

public class FindUniqueBinaryString_1980 {

    // We should have the same values of array.length and array[i].length to proceed
    static class Solution {
        public String findDifferentBinaryString(String[] nums) {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < nums.length; i++) {
                builder.append(nums[i].charAt(i) == '0' ? '1' : '0');
            }
            return builder.toString();
        }
    }

    static class SolutionBacktrack {
        public String findDifferentBinaryString(String[] nums) {
            return backtrack(new HashSet<>(Arrays.asList(nums)), new StringBuilder(), nums[0].length());
        }

        private String backtrack(Set<String> set, StringBuilder temp, int n) {
            if (temp.length() == n) {
                var tempStr = temp.toString();
                if (!set.contains(tempStr)) {
                    return tempStr;
                }
                return null;
            }
            String result;
            for (int i = 0; i < n; i++) {
                temp.append('1');
                result = backtrack(set, temp, n);
                if (result != null) {
                    return result;
                }
                temp.deleteCharAt(temp.length() - 1);
                temp.append('0');
                result = backtrack(set, temp, n);
                if (result != null) {
                    return result;
                }
                temp.deleteCharAt(temp.length() - 1);
            }
            return null;
        }
    }
}
