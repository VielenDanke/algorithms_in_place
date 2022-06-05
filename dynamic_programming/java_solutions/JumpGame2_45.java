package dynamic_programming.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class JumpGame2_45 {

    /*
    Pattern: using window technique
             we start from 0 and try to find min and max value which we are able to reach from current idx
             when we define left = min idx from current position, right = max idx from current position
             we iterate over range of left and right and define the farthest jump we could make
             when we found - update our left position to next from our previous right (left = right)
             right update to the farthest jump (right = furthest)

     Example:
     [2,3,1,1,4] left = 0, right = 0, jumps = 0

     1) left = 0, right = 0, jump = 0
     2) left = 1, right = 2, jump += 1 (from index 0 we can jump to min position - 1, max position - 2)
     3) left = 2, right = 4, jump += 1 (from index 1 we can jump to min position - 2, max position - 4)

     answer - 2
     */

    public int jumpBetter(int[] nums) {
        int N = nums.length;
        int jumps = 0, left = 0, right = 0;

        while (right < N - 1) {
            int farthest = 0;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right;
            right = farthest;
            jumps++;
        }
        return jumps;
    }

    // ------------------------------------------------------------------------

    private final Map<Integer, Integer> memo = new HashMap<>();

    public int jump(int[] nums) {
        return jumpMin(nums, 0);
    }

    public int jumpMin(int[] nums, int next) {
        if (memo.containsKey(next)) {
            return memo.get(next);
        }
        if (next >= nums.length - 1) {
            return 0;
        }
        int min = 1 << 30;
        int jumpLength = nums[next];

        for (int i = 1; i <= jumpLength; i++) {
            min = Math.min(min, jumpMin(nums, next + i) + 1);
        }
        memo.put(next, min);
        return min;
    }
}
