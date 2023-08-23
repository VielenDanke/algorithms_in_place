package leetcode.strings.medium.java_solutions;

import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString_767 {

    static class Solution {
        public String reorganizeString(String s) {
            int alphAmount = 26;

            int[] alph = new int[alphAmount];

            for (char c : s.toCharArray()) {
                alph[c - 'a']++;
            }
            Queue<Integer> queue = new PriorityQueue<>((left, right) -> alph[right] - alph[left]);

            for (int i = 0; i < alphAmount; i++) {
                if (alph[i] > 0) {
                    queue.offer(i);
                }
            }
            StringBuilder builder = new StringBuilder();

            char prevChar = 'A';

            while (!queue.isEmpty()) {
                int idx = queue.poll();
                char current = (char) (idx + 'a');
                builder.append(current);
                alph[idx]--;
                if (prevChar != 'A' && alph[prevChar - 'a'] > 0) {
                    queue.offer(prevChar - 'a');
                }
                prevChar = current;
            }
            return builder.length() == s.length() ? builder.toString() : "";
        }
    }
}
