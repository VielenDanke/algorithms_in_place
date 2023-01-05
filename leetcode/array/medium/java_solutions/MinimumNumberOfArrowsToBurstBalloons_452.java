package leetcode.array.medium.java_solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MinimumNumberOfArrowsToBurstBalloons_452 {

    static class SolutionWithoutStack {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

            int result = 1;
            int end = points[0][1];

            for (int i = 1; i < points.length; i++) {
                if (points[i][0] > end) {
                    result++;
                    end = points[i][1];
                }
            }
            return result;
        }
    }

    static class Solution {
        public int findMinArrowShots(int[][] points) {
            // sort using start position
            // unite points such as [max(x0, x1), min(y0, y1)]
            // check if next point cross boarder, if yes - unite, if not - skip
            Arrays.sort(points, (l, r) -> {
                if (l[0] == r[0]) {
                    return l[1] - r[1];
                }
                return l[0] - r[0];
            });

            Stack<int[]> stack = new Stack<>();

            for (int[] point : points) {
                if (stack.isEmpty() || !isIntersect(stack.peek(), point)) {
                    stack.add(point);
                } else {
                    int[] lastElem = stack.pop();
                    stack.add(new int[]{Math.max(point[0], lastElem[0]), Math.min(point[1], lastElem[1])});
                }
            }
            return stack.size();
        }

        private boolean isIntersect(int[] fromStack, int[] next) {
            return (next[0] >= fromStack[0] && next[0] <= fromStack[1]) || (next[1] >= fromStack[0] && next[1] <= fromStack[1]);
        }
    }
}
