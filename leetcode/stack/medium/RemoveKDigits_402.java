package leetcode.stack.medium;

import java.math.BigInteger;

/*
Rust solution

struct Solution {}

impl Solution {
    pub fn remove_kdigits(num: String, k: i32) -> String {
        let mut stack = String::new();
        let mut k = k;

        for current in num.chars() {
            while !stack.is_empty() && k > 0 && stack.chars().last().unwrap() > current {
                stack.remove(stack.len() - 1);
                k -= 1;
            }
            stack.push(current);
        }
        while k > 0 && !stack.is_empty() {
            stack.remove(stack.len() - 1);
            k -= 1;
        }
        stack = stack.trim_start_matches(|c| c == '0').to_string();
        if stack.is_empty() { String::from("0") } else { stack }
    }
}
 */

public class RemoveKDigits_402 {

    static class Solution {
        public String removeKdigits(String num, int k) {
            StringBuilder builder = new StringBuilder();

            for (char current : num.toCharArray()) {
                while (!builder.isEmpty() && k > 0 && builder.charAt(builder.length() - 1) > current) {
                    builder.deleteCharAt(builder.length() - 1);
                    k--;
                }
                builder.append(current);
            }
            while (k > 0 && !builder.isEmpty()) {
                builder.deleteCharAt(builder.length() - 1);
                k--;
            }
            while (!builder.isEmpty() && builder.charAt(0) == '0') {
                builder.deleteCharAt(0);
            }
            return builder.isEmpty() ? "0" : builder.toString();
        }
    }

    static class SolutionBruteForce {
        private BigInteger min = null;

        public String removeKdigits(String num, int k) {
            StringBuilder builder = new StringBuilder(num);

            dfs(builder, k);

            return min == null ? "0" : min.toString();
        }

        private void dfs(StringBuilder builder, int k) {
            if (k == 0) {
                if (builder.isEmpty()) {
                    return;
                }
                BigInteger current = new BigInteger(builder.toString());
                if (min == null || current.compareTo(min) < 0) {
                    min = current;
                }
                return;
            }
            for (int i = 0; i < builder.length(); i++) {
                char c = builder.charAt(i);
                dfs(builder.deleteCharAt(i), k - 1);
                builder.insert(i, c);
            }
        }
    }
}
