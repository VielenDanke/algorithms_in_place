package leetcode.array.medium.java_solutions;

public class MinimumTimeToCompleteTrips_2187 {

    static class SolutionCalculateLeftRight {
        public long minimumTime(int[] time, int totalTrips) {
            long left = Long.MAX_VALUE, ans = Long.MAX_VALUE, right;

            for (int t : time) {
                left = Math.min(left, t);
            }
            right = totalTrips * left;

            while (left <= right) {
                long midTime = left + ((right - left) / 2);

                long trips = 0;

                for (int t : time) {
                    trips += midTime / t;
                    if (trips >= totalTrips) break;
                }
                if (trips >= totalTrips) {
                    ans = Math.min(ans, midTime);
                    right = midTime - 1;
                } else
                    left = midTime + 1;
            }
            return ans;
        }
    }

    static class Solution {
        public long minimumTime(int[] time, int totalTrips) {
            long left = 0L, right = Long.MAX_VALUE / time.length, need;

            while (left < right) {
                need = left + (right - left) / 2;

                if (calculateSum(time, need) < totalTrips) {
                    left = need + 1;
                } else {
                    right = need;
                }
            }
            return left;
        }

        private long calculateSum(int[] time, long need) {
            long sum = 0;
            for (int t : time) sum += need / t;
            return sum;
        }
    }

    static class SolutionBruteForce {
        public long minimumTime(int[] time, int totalTrips) {
            // totalTrips - sum of all trips for all busses
            int n = time.length;
            int[] newVal = new int[n];
            long timeCounter = 0;

            while (totalTrips > 0) {
                for (int i = 0; i < n && totalTrips > 0; i++) {
                    newVal[i]++;
                    if (newVal[i] == time[i]) {
                        newVal[i] = 0;
                        totalTrips--;
                        if (totalTrips == 0) return timeCounter;
                    }
                }
                timeCounter++;
            }
            return timeCounter;
        }
    }
}
