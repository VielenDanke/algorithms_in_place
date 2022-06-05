package dynamic_programming.java_solutions;

public class JumpGame_55 {

    /*
    Pattern: start from last and iterate in decreasing order
             try to add to current idx jump length
             if position is reachable - place lastPos to current idx

    Example: [2,3,1,1,4]

             1) idx 3 + 1 >= 4 - yes, set lastPos to 3
             2) idx 2 + 1 >= 3 - yes, set lastPos to 2
             3) idx 1 + 3 >= 2 - yes, set lastPos to 1
             4) idx 0 + 2 >= 1 - yes, set lastPos to 0
     */

    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
