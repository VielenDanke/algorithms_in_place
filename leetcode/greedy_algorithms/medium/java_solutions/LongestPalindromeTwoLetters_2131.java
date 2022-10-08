package leetcode.greedy_algorithms.medium.java_solutions;

import java.util.Arrays;
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

    private static class SolutionBetter {

        public int longestPalindrome(String[] words) {
            Map<String, Integer> wordsAmount = new HashMap<>();

            Arrays.stream(words).forEach(word -> wordsAmount.put(word, wordsAmount.getOrDefault(word, 0) + 1));

            int result = 0;
            boolean isFound = false;

            for (String word : words) {
                if (word.charAt(0) == word.charAt(1)) {
                    Integer wordAmount = wordsAmount.get(word);
                    if (wordAmount % 2 != 0) {
                        wordAmount -= 1;
                        isFound = true;
                    }
                    result += wordAmount * 2;
                    wordsAmount.put(word,wordsAmount.get(word) - wordAmount);
                } else {
                    String reversedWord = new StringBuilder(word).reverse().toString();
                    if (wordsAmount.containsKey(reversedWord)) {
                        int min = Math.min(wordsAmount.get(reversedWord), wordsAmount.get(word));
                        result += (min * 2) * 2;
                        wordsAmount.put(word, wordsAmount.get(word) - min);
                        wordsAmount.put(reversedWord, wordsAmount.get(reversedWord) - min);
                    }
                }
            }
            if (isFound) {
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
