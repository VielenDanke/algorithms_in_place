package leetcode.strings.easy.java_solution;

/*
Rust solution:

impl Solution {
    pub fn length_of_last_word(s: String) -> i32 {
        s.trim().split(" ").last().unwrap().len() as i32
    }
}
 */

public class LengthOfLastWord_58 {

    static class Solution {
        public int lengthOfLastWord(String s) {
            String[] arr = s.trim().split(" ");
            return arr[arr.length - 1].trim().length();
        }
    }
}
