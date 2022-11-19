package leetcode.geometry.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ErectTheFence_587 {

    // Convex Hull Algorithm https://www.youtube.com/watch?v=B2AJoQSZf4M

    static class SolutionJarvisMarch {

        public int[][] outerTrees(int[][] points) {
            List<int[]> hull = new ArrayList<>();

            int[] startingPoint = getMinY(points); // bottom most, left most point is guaranteed to be on the hull
            hull.add(startingPoint);

            int[] prevVertex = startingPoint;

            while (true) {
                int[] candidate = null;
                /*
                 * iterate over every point and pick the one that creates the smallest counterclockwise angle
                 * in reference to the previous vertex
                 */
                for (int[] point : points) {
                    if (point == prevVertex) continue;

                    if (candidate == null) {
                        candidate = point;
                        continue;
                    }

                    int ccw = ccw(prevVertex, candidate, point);

                    if (ccw == 0 && dist(prevVertex, candidate) < dist(prevVertex, point)) {
                        candidate = point; // collinear tie is decided by the distance
                    } else if (ccw < 0) {
                        /*
                         * if made a clockwise turn, then found a better point that makes a smaller
                         * counterclockwise angle in reference to the previous vertex
                         */
                        candidate = point;
                    }
                }

                if (candidate == startingPoint) break; // came back to the starting point, so we are done

                hull.add(candidate);
                prevVertex = candidate;
            }
            return hull.toArray(int[][]::new);
        }

        private static int[] getMinY(int[][] points) {
            int idx = 0;

            for (int i = 1; i < points.length; i++) {
                if (points[i][1] < points[idx][1]) {
                    idx = i;
                }
            }
            return points[idx];
        }
    }

    static class SolutionGrahamScan {

        public int[][] outerTrees(int[][] points) {
            if (points.length <= 1) return points;
            sortByPolar(points, bottomLeft(points));
            Stack<int[]> stack = new Stack<>();
            stack.push(points[0]);
            stack.push(points[1]);
            for (int i = 2; i < points.length; i++) {
                int[] top = stack.pop();
                while (ccw(stack.peek(), top, points[i]) < 0) {
                    top = stack.pop();
                }
                stack.push(top);
                stack.push(points[i]);
            }
            return stack.toArray(int[][]::new);
        }

        private static int[] bottomLeft(int[][] points) {
            int[] bottomLeft = points[0];
            for (int[] p : points) {
                if (p[1] < bottomLeft[1] || p[1] == bottomLeft[1] && p[0] < bottomLeft[0]) {
                    bottomLeft = p;
                }
            }
            return bottomLeft;
        }

        private static void sortByPolar(int[][] points, int[] r) {
            Arrays.sort(points, (p, q) -> {
                int compPolar = ccw(p, r, q);
                int compDist = dist(p, r) - dist(q, r);
                return compPolar == 0 ? compDist : compPolar;
            });
            // find collinear points in the end positions
            int[] p = points[0], q = points[points.length - 1];
            int i = points.length - 2;
            while (i >= 0 && ccw(p, q, points[i]) == 0) {
                i--;
            }
            // reverse sort order of collinear points in the end positions
            for (int l = i + 1, h = points.length - 1; l < h; l++, h--) {
                int[] tmp = points[l];
                points[l] = points[h];
                points[h] = tmp;
            }
        }
    }

    /**
     * @return positive if counter-clockwise, negative if clockwise, 0 if collinear
     */
    private static int ccw(int[] a, int[] b, int[] c) {
        return a[0] * b[1] - a[1] * b[0] + b[0] * c[1] - b[1] * c[0] + c[0] * a[1] - c[1] * a[0];
    }

    /**
     * @return distance square of |p - q|
     */
    private static int dist(int[] p, int[] q) {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }
}
