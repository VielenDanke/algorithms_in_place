package javasolutions.array;

import java.util.Arrays;

public class MajorityElements {

    public static int majorityElement(int[] nums) {
        int majority = nums.length / 2;
        Arrays.sort(nums);
        int counter = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                counter++;
            } else {
                if (counter >= majority) {
                    return nums[i - 1];
                } else {
                    counter = 0;
                }
            }
        }
        if (counter >= majority) {
            return nums[nums.length - 1];
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElements.majorityElement(new int[]{3,2,3});
    }
}
