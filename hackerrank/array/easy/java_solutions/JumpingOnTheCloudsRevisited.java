package hackerrank.array.easy.java_solutions;

public class JumpingOnTheCloudsRevisited {

    // https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem

    static class Solution {
        static int jumpingOnClouds(int[] c, int k) {
            int start = 0;
            int n = c.length;
            int e = 100;
            boolean[] visited = new boolean[n];

            while (!visited[start]) {
                visited[start] = true;
                start += k;
                if (start >= n) {
                    start %= n;
                }
                e--;
                if (c[start] == 1) {
                    e -= 2;
                }
            }
            return start == 0 ? e : -1;
        }
    }
}
