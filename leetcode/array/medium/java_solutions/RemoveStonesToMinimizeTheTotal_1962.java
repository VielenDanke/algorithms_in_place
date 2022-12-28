package leetcode.array.medium.java_solutions;

import java.util.PriorityQueue;
import java.util.Queue;

public class RemoveStonesToMinimizeTheTotal_1962 {

    static class Solution {
        public int minStoneSum(int[] piles, int k) {
            Queue<Integer> queue = new PriorityQueue<>((l, r) -> r - l);

            int result = 0;

            for (int pile : piles) {
                queue.add(pile);
                result += pile;
            }
            while (k-- > 0 && !queue.isEmpty()) {
                int pile = queue.poll();

                queue.add(pile - pile / 2);

                result -= pile / 2;
            }
            return result;
        }
    }
}
