package leetcode.array.medium.java_solutions;

public class MaximizeTheConfusionOfAnExam_2024 {

    static class Solution {

        public int maxConsecutiveAnswers(String str, int k) {
            return Math.max(replace(str, k, 'T'), replace(str, k, 'F'));
        }

        private int replace(String str, int k, char letter) {
            int n = str.length(), left = 0, right = 0, max = Integer.MIN_VALUE;
            while (right < n) {
                if (str.charAt(right) == letter) {
                    k--;
                    max = Math.max(max, right - left);
                    while (k < 0 && left < right) {
                        if (str.charAt(left++) == letter) {
                            k++;
                        }
                    }
                }
                right++;
            }
            return Math.max(max, right - left);
        }
    }
}
