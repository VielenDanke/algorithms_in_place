package array.easy.java_solutions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumUnitTruck_1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (i, j) -> j[1] - i[1]);
        int current = 0, sum = 0;
        while (current < boxTypes.length && truckSize > 0) {
            int[] typeAmount = boxTypes[current++];
            sum += Math.min(typeAmount[0], truckSize) * typeAmount[1];
            truckSize -= typeAmount[0];
        }
        return sum;
    }

    public int maximumUnitsMaxHeap(int[][] boxTypes, int truckSize) {
        Queue<int[]> queue = new PriorityQueue<>((i, j) -> j[1] - i[1]);
        int sum = 0;

        queue.addAll(Arrays.asList(boxTypes));

        while (truckSize > 0 && !queue.isEmpty()) {
            int[] best = queue.poll();
            sum += Math.min(truckSize, best[0]) * best[1];
            truckSize -= best[0];
        }
        return sum;
    }
}
