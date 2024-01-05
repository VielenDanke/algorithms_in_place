package leetcode.binary_search.medium.java_solutions;

public class MinimumSpeedToArriveOnTime_1870 {

    static class Solution {
        public int minSpeedOnTime(int[] dist, double hour) {
            int left = 1, right = 10000000, answer = -1;

            while (left <= right) {
                int middle = left + (right - left) / 2;

                double value = calculate(dist, middle);

                if (value > hour) {
                    left = middle + 1;
                } else {
                    answer = middle;
                    right = middle - 1;
                }
            }
            return answer;
        }

        private double calculate(int[] dist, int speed) {
            double sum = 0.0;

            for (int i = 0; i < dist.length - 1; i++) {
                sum += Math.ceil((double) dist[i] / speed);
            }
            return sum + ((double) dist[dist.length - 1]) / speed;
        }
    }
}
