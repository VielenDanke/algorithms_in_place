package greedy_algorithms.medium.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeTwoLetters_2131 {

    private static class Solution {

        public int longestPalindrome(String[] words) {
            Map<String, Integer> wordsDict = new HashMap<>();
            int unpaired = 0, result = 0;
            for (String w : words) {
                if (!wordsDict.containsKey(w)) {
                    wordsDict.put(w, 1);
                }
                if (w.charAt(0) == w.charAt(1)) {
                    if (wordsDict.get(w) > 1) {
                        unpaired--;
                        wordsDict.put(w, wordsDict.get(w) - 1);
                        result += 4;
                    } else {
                        wordsDict.put(w, wordsDict.get(w) + 1);
                        unpaired++;
                    }
                } else {
                    String rev = new StringBuilder(w).reverse().toString();
                    if (wordsDict.containsKey(rev) && wordsDict.get(rev) > 1) {
                        result += 4;
                        wordsDict.put(rev, wordsDict.get(rev) - 1);
                    } else {
                        wordsDict.put(w, wordsDict.get(w) + 1);
                    }
                }
            }
            if (unpaired > 0) {
                result += 2;
            }
            return result;
        }
    }

    private static class SolutionBruteForce {
        private int max;

        public int longestPalindrome(String[] words) {
            max = 0;
            backtrack(words, "", new boolean[words.length]);
            return max;
        }

        private void backtrack(String[] words, String word, boolean[] visited) {
            if (word.length() > max && isPalindrome(word)) {
                max = Math.max(max, word.length());
            }
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                backtrack(words, word + words[i], visited);
                visited[i] = false;
            }
        }

        private boolean isPalindrome(String word) {
            int left = 0, right = word.length() - 1;
            while (left < right) {
                if (word.charAt(left) != word.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
