package leetcode.backtracking_recursion.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        backtrack(combinations, "", 0, 0, n);
        return combinations;
    }

    private void backtrack(List<String> combinations, String temp, int open, int close, int n) {
        if (temp.length() == n * 2) {
            combinations.add(temp);
            return;
        }
        if (open < n) {
            backtrack(combinations, temp + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(combinations, temp + ")", open, close + 1, n);
        }
    }
}
