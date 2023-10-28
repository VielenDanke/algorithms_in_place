package leetcode.dynamic_programming.java_solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountVowelsPermutation_1220 {

    static class Solution {
        private static final Map<Character, List<Character>> VOWELS = new HashMap<>();
        private Integer[][] cache;
        private static final int MOD = (int) (10e8 + 7);

        static {
            VOWELS.put('a', List.of('e'));
            VOWELS.put('e', List.of('a', 'i')); // left and right
            VOWELS.put('i', List.of('a', 'e', 'o', 'u'));
            VOWELS.put('o', List.of('i', 'u')); // left and right
            VOWELS.put('u', List.of('a'));
        }

        public int countVowelPermutation(int n) {
            this.cache = new Integer[32][n + 1];
            return backtrack('k', n);
        }

        private int backtrack(char last, int len) {
            if (len == 0) {
                return 1;
            }
            int amount = 0;
            if (cache[last - 'a'][len] != null) {
                return cache[last - 'a'][len];
            }
            if (last == 'k') {
                for (char c : VOWELS.keySet()) {
                    amount = (amount + backtrack(c, len - 1)) % MOD;
                }
            } else {
                List<Character> next = VOWELS.get(last);
                for (char c : next) {
                    amount = (amount + backtrack(c, len - 1)) % MOD;
                }
            }
            return cache[last - 'a'][len] = amount % MOD;
        }
    }

    static class SolutionBruteForce {
        private static final Map<Character, List<Character>> VOWELS = new HashMap<>();
        private int counter;
        private int n;

        static {
            VOWELS.put('a', List.of('e'));
            VOWELS.put('e', List.of('a', 'i')); // left and right
            VOWELS.put('i', List.of('a', 'e', 'o', 'u'));
            VOWELS.put('o', List.of('i', 'u')); // left and right
            VOWELS.put('u', List.of('a'));
        }

        public int countVowelPermutation(int n) {
            // backtrack
            // idx every recursive call will be incremented
            this.n = n;
            this.counter = 0;
            backtrack("");
            return counter;
        }

        private void backtrack(String temp) {
            if (temp.length() == n) {
                counter++;
                return;
            }
            if (temp.isEmpty()) {
                for (char c : VOWELS.keySet()) {
                    backtrack(temp + c);
                }
            } else {
                char last = temp.charAt(temp.length() - 1);
                List<Character> next = VOWELS.get(last);
                for (char c : next) {
                    backtrack(temp + c);
                }
            }
        }
    }
}
