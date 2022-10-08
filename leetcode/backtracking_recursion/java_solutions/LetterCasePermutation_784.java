package leetcode.backtracking_recursion.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation_784 {

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();

        backtrack(result, s.toCharArray(), 0);

        return result;
    }

    private void backtrack(List<String> result, char[] word, int start) {
        result.add(new String(word));
        for (int i = start; i < word.length; i++) {
            if (Character.isLetter(word[i])) {
                boolean isUpperCase = Character.isUpperCase(word[i]);
                boolean isLowerCase = Character.isLowerCase(word[i]);

                if (isUpperCase) {
                    word[i] = Character.toLowerCase(word[i]);
                }
                if (isLowerCase) {
                    word[i] = Character.toUpperCase(word[i]);
                }
                backtrack(result, word, i + 1);
                if (isUpperCase) {
                    word[i] = Character.toUpperCase(word[i]);
                }
                if (isLowerCase) {
                    word[i] = Character.toLowerCase(word[i]);
                }
            }
        }
    }
}
