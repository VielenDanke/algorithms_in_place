package leetcode.geometry.hard;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsLine_149 {

    static class SolutionDiff {
        public int maxPoints(int[][] points) {
            int maxPoints = 0;
            for (int i = 0; i < points.length; i++) {
                Map<String, Integer> slopes = new HashMap<>();
                int samePoints = 1;
                for (int j = i + 1; j < points.length; j++) {
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    if (x1 == x2 && y1 == y2) {
                        samePoints++;
                    } else {
                        String slope;
                        if (x1 == x2) {
                            slope = "inf";
                        } else {
                            int dy = y2 - y1;
                            int dx = x2 - x1;
                            int gcd = gcd(dy, dx);
                            dy /= gcd;
                            dx /= gcd;
                            slope = dy + "/" + dx;
                        }
                        slopes.put(slope, slopes.getOrDefault(slope, 0) + 1);
                    }
                }
                maxPoints = Math.max(maxPoints, samePoints);
                for (int numPoints : slopes.values()) {
                    maxPoints = Math.max(maxPoints, numPoints + samePoints);
                }
            }
            return maxPoints;
        }
    }

    static class Solution {
        public int maxPoints(int[][] points) {
            if (points == null) return 0;
            if (points.length <= 2) return points.length;

            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            int result = 0;
            for (int i = 0; i < points.length; i++) {
                map.clear();
                int overlap = 0, max = 0;
                for (int j = i + 1; j < points.length; j++) {
                    int x = points[j][0] - points[i][0];
                    int y = points[j][1] - points[i][1];
                    if (x == 0 && y == 0) {
                        overlap++;
                        continue;
                    }
                    int gcd = gcd(x, y);
                    if (gcd != 0) {
                        x /= gcd;
                        y /= gcd;
                    }
                    if (map.containsKey(x)) {
                        if (map.get(x).containsKey(y)) {
                            map.get(x).put(y, map.get(x).get(y) + 1);
                        } else {
                            map.get(x).put(y, 1);
                        }
                    } else {
                        Map<Integer, Integer> m = new HashMap<>();
                        m.put(y, 1);
                        map.put(x, m);
                    }
                    max = Math.max(max, map.get(x).get(y));
                }
                result = Math.max(result, max + overlap + 1);
            }
            return result;
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
