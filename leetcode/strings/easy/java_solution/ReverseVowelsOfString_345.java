package leetcode.strings.easy.java_solution;

import java.util.LinkedList;

public class ReverseVowelsOfString_345 {

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u' || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U';
    }

    static class SolutionTwoPointers {
        public String reverseVowels(String s) {
            char[] word = s.toCharArray();

            int left = 0, right = word.length - 1;

            while (left < right) {
                if (!isVowel(word[left])) {
                    left++;
                } else if (!isVowel(word[right])) {
                    right--;
                } else {
                    char temp = word[left];
                    word[left] = word[right];
                    word[right] = temp;
                    left++;
                    right--;
                }
            }
            return new String(word);
        }
    }

    static class Solution {
        public String reverseVowels(String s) {
            final char[] word = s.toCharArray();
            final LinkedList<Character> vowels = new LinkedList<>();

            for (char current : word) {
                if (isVowel(current)) {
                    vowels.add(current);
                }
            }
            for (int i = 0; i < word.length; i++) {
                if (isVowel(word[i])) {
                    word[i] = vowels.removeLast();
                }
            }
            return new String(word);
        }
    }
}
