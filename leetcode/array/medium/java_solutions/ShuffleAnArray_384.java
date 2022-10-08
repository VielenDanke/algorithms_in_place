package leetcode.array.medium.java_solutions;

import java.util.Random;

public class ShuffleAnArray_384 {

    private static final Random random = new Random();
    private final int[] rootArray;

    public ShuffleAnArray_384(int[] nums) {
        this.rootArray = nums;
    }

    public int[] reset() {
        return this.rootArray;
    }

    public int[] shuffle() {
        int[] temp = new int[this.rootArray.length];
        System.arraycopy(this.rootArray, 0, temp, 0, temp.length);
        doShuffle(temp);
        return temp;
    }

    private void doShuffle(int[] nums) {
        int current = 0;
        while (current < nums.length) {
            int next = random.nextInt(current + 1);
            int temp = nums[current];
            nums[current] = nums[next];
            nums[next] = temp;
            current++;
        }
    }
}
