package leetcode.strings.easy.java_solution;

import java.util.HashSet;
import java.util.Set;

public class DetermineIfStringHalvesAreAlike_1704 {

    static class Solution {

        private static final Set<Character> STORAGE = new HashSet<>();

        static {
            STORAGE.add('a');
            STORAGE.add('e');
            STORAGE.add('i');
            STORAGE.add('o');
            STORAGE.add('u');
            STORAGE.add('A');
            STORAGE.add('E');
            STORAGE.add('I');
            STORAGE.add('O');
            STORAGE.add('U');
        }

        public boolean halvesAreAlike(String s) {
            if (s == null) return false;
            int n = s.length();
            if (n == 0 || n % 2 != 0) return false;
            return calculateVowels(s, 0, n / 2) == calculateVowels(s, n / 2, n);
        }

        private int calculateVowels(String s, int start, int end) {
            int letters = 0;
            for (int i = start; i < end; i++) {
                if (STORAGE.contains(s.charAt(i))) {
                    letters++;
                }
            }
            return letters;
        }
    }
}
