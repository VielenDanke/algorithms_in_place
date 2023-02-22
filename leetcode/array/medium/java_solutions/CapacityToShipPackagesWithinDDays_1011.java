package leetcode.array.medium.java_solutions;

public class CapacityToShipPackagesWithinDDays_1011 {

    static class SolutionBinarySearch {

        public int shipWithinDays(int[] weights, int days) {
            int left = 0, right = 0;

            for (int weight : weights) {
                left = Math.max(left, weight);
                right += weight;
            }
            while (left < right) {
                int middle = left + (right - left) / 2, need = 1, current = 0;
                for (int weight : weights) {
                    if (current + weight > middle) {
                        need++;
                        current = 0;
                    }
                    current += weight;
                }
                if (need > days) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            return left;
        }
    }

    static class SolutionBruteForce {

        public int shipWithinDays(int[] weights, int days) {
            int capacity = 0;

            for (int weight : weights) capacity = Math.max(capacity, weight);

            while (true) {
                int tempDays = days;
                int tempCapacity = capacity;

                for (int weight : weights) {
                    if (tempCapacity - weight < 0) {
                        tempCapacity = capacity;
                        tempDays--;
                        if (tempDays == 0) break;
                    }
                    tempCapacity -= weight;
                }
                if (tempDays > 0) {
                    return capacity;
                }
                capacity++;
            }
        }
    }
}
