package leetcode.array.easy.java_solutions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class AssignCookies_455 {

    static class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);

            int childIdx = 0, result = 0;

            for (int i = 0; i < s.length && childIdx < g.length; i++) {
                if (g[childIdx] <= s[i]) {
                    result++;
                    childIdx++;
                }
            }
            return result;
        }
    }

    static class SolutionQueue {
        public int findContentChildren(int[] g, int[] s) {
            Queue<Integer> children = new PriorityQueue<>();
            Queue<Integer> cookies = new PriorityQueue<>();

            for (Integer v : g) {
                children.offer(v);
            }
            for (Integer v : s) {
                cookies.offer(v);
            }
            while (!cookies.isEmpty() && !children.isEmpty()) {
                if (children.peek() <= cookies.poll()) {
                    children.poll();
                }
            }
            return g.length - children.size();
        }
    }
}
