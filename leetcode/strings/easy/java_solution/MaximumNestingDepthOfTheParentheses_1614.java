package leetcode.strings.easy.java_solution;

/*
impl Solution {
    pub fn max_depth(s: String) -> i32 {
        let (mut counter, mut result) = (0, 0);
        s.chars()
            .into_iter()
            .for_each(|c| {
                if c == '(' { counter += 1; } else if c == ')' { counter -= 1; }
                result = result.max(counter);
            });
        result
    }
}
 */

public class MaximumNestingDepthOfTheParentheses_1614 {

    static class Solution {
        public int maxDepth(String s) {
            int counter = 0, result = 0;

            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                if (current == '(') {
                    counter++;
                } else if (current == ')') {
                    counter--;
                }
                result = Math.max(result, counter);
            }
            return result;
        }
    }
}
