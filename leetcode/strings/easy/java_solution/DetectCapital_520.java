package leetcode.strings.easy.java_solution;

public class DetectCapital_520 {

    static class Solution {
        public boolean detectCapitalUse(String word) {
            if (word == null || word.isEmpty() || word.isBlank()) return false;
            return isSequenceValid(word, Character.isUpperCase(word.charAt(0))) || (Character.isUpperCase(word.charAt(0)) && isSequenceValid(word.substring(1), Character.isUpperCase(word.charAt(1))));
        }

        private boolean isSequenceValid(String word, boolean isUpper) {
            for (int i = 0; i < word.length(); i++) {
                if (isUpper && Character.isLowerCase(word.charAt(i))) {
                    return false;
                } else if (!isUpper && Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}
