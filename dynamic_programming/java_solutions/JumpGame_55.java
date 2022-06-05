package dynamic_programming.java_solutions;

public class JumpGame_55 {

    /*
    Pattern: start from last and iterate in decreasing order
             try to add to current idx jump length
             if position is reachable - place lastPos to current idx
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
