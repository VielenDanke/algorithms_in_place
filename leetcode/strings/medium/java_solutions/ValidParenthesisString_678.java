package leetcode.strings.medium.java_solutions;

/*
pub struct Solution {}

impl Solution {
    pub fn check_valid_string(s: String) -> bool {
        let mut left = Vec::new();
        s.as_bytes().clone_into(&mut left);

        let is_valid = Solution::validate(left, '(', ')');

        let mut right = Vec::new();
        s.as_bytes().clone_into(&mut right);
        right.reverse();

        is_valid && Solution::validate(right, ')', '(')
    }

    fn validate(s: Vec<u8>, left: char, right: char) -> bool {
        let (mut count_stars, mut parentheses) = (0, 0);
        for ch in s {
            if ch as char == left {
                parentheses += 1;
            } else if ch as char == right {
                if parentheses > 0 {
                    parentheses -= 1;
                } else if count_stars > 0 {
                    count_stars -= 1;
                } else {
                    return false;
                }
            } else {
                count_stars += 1;
            }
        }
        true
    }
}
 */

public class ValidParenthesisString_678 {

    public boolean checkValidString(String s) {
        int lower = 0, higher = 0;
        for (char c : s.toCharArray()) {
            lower += c == '(' ? 1 : -1;
            higher += c != ')' ? 1 : -1;
            if (higher < 0) {
                break;
            }
            lower = Math.max(lower, 0);
        }
        return lower == 0;
    }
}
