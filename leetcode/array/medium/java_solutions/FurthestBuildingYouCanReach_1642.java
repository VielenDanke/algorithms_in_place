package leetcode.array.medium.java_solutions;

import java.util.PriorityQueue;
import java.util.Queue;

public class FurthestBuildingYouCanReach_1642 {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> queue = new PriorityQueue<>();
        int finalIdx = heights.length - 1;
        for (int i = 0; i < finalIdx; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) queue.add(diff);
            if (queue.size() > ladders) bricks -= queue.poll();
            if (bricks < 0) return i;
        }
        return finalIdx;
    }

    // ---------------------------------------------------------------------------
    // Brute force
    private int max;

    public int furthestBuildingBruteForce(int[] heights, int bricks, int ladders) {
        max = 0;
        move(heights, 0, bricks, ladders);
        return max;
    }

    private void move(int[] heights, int position, int bricks, int ladders) {
        if (bricks < 0) {
            max = Math.max(position - 1, max);
            return;
        } else if (ladders < 0) {
            max = Math.max(position - 1, max);
            return;
        }
        if (position == heights.length - 1) {
            max = Math.max(position, max);
            return;
        }
        int current = heights[position];
        int next = heights[position + 1];
        if (next < current) {
            move(heights, position + 1, bricks, ladders);
        } else {
            move(heights, position + 1, bricks - (next - current), ladders);
            move(heights, position + 1, bricks, ladders - 1);
        }
    }
}
