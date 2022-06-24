package array.hard.java_solutions;

import java.util.PriorityQueue;
import java.util.Queue;

public class ConstructTargetArrayMultipleSums_1354 {

    /*
    Pattern:
    1. Calculate sum of array target
    2. Add each number to PriorityQueue with priority from high to low
    3. Take the highest element of queue and decrease it from total sum
    4. If total sum will be greater than current the biggest num or total sum will be less than 1 - return false
    5. Important part: we perform % operation as num %= sum to find next number which will be added to queue
    6. Add number to current total sum
    7. Add number to queue if number > 0, if not - add sum instead
     */

    public boolean isPossible(int[] target) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int num : target) {
            sum += num;
            pq.add(num);
        }
        while (!pq.isEmpty() && pq.peek() != 1) {
            int num = pq.poll();
            sum -= num;
            if (num <= sum || sum < 1) return false;
            num %= sum;
            sum += num;
            pq.add(num > 0 ? num : sum);
        }
        return true;
    }

    public static void main(String[] args) {
        new ConstructTargetArrayMultipleSums_1354().isPossible(new int[]{8, 5});
    }
}
