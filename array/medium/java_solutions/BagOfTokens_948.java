package array.medium.java_solutions;

import java.util.Arrays;

public class BagOfTokens_948 {

    static class Solution {
        public int bagOfTokensScore(int[] tokens, int power) {
            Arrays.sort(tokens);
            int score = 0, max = 0, left = 0, right = tokens.length - 1;

            while (left <= right) {
                if (power >= tokens[left]) {
                    power -= tokens[left++];
                    score++;
                    max = Math.max(max, score);
                } else if (score > 0) {
                    power += tokens[right--];
                    score--;
                } else {
                    break;
                }
            }
            return max;
        }
    }
}
