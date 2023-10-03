package leetcode.stack.medium;

import java.util.Stack;

public class RemoveDuplicateLetters_316 {

    static class Solution {
        // bcabcd
        public String removeDuplicateLetters(String s) {
            int[] alph = new int[26];
            for (int i = 0; i < s.length(); i++) {
                alph[s.charAt(i) - 'a'] = i;
            }
            boolean[] seen = new boolean[26];
            Stack<Integer> st = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                int curr = s.charAt(i) - 'a';
                if (seen[curr]) {
                    continue;
                }
                while (!st.isEmpty() && st.peek() > curr && i < alph[st.peek()]) {
                    seen[st.pop()] = false;
                }
                st.push(curr);
                seen[curr] = true;
            }
            StringBuilder sb = new StringBuilder();

            while (!st.isEmpty()) {
                sb.append((char) (st.pop() + 'a'));
            }
            return sb.reverse().toString();
        }
    }
}
