package leetcode.strings.easy.java_solution;

public class DeleteColumnsToMakeSorted_944 {

    static class Solution {
        public int minDeletionSize(String[] strs) {
            int result = 0;
            for (int i = 0; i < strs[0].length(); i++) {
                for (int j = 0; j < strs.length; j++) {
                    if (j > 0 && strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                        result++;
                        break;
                    }
                }
            }
            return result;
        }
    }
}
