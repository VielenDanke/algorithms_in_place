package javasolutions.array.medium;

import java.util.Arrays;

public class ArrayProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int commonProduct = 1;
        int zeroCounter = 0;
        for (int currentNum : nums) {
            if (currentNum != 0) {
                commonProduct *= currentNum;
            } else {
                zeroCounter++;
            }
        }
        if (zeroCounter > 1) {
            return new int[nums.length];
        }
        if (zeroCounter != 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    nums[i] = commonProduct;
                } else {
                    nums[i] = 0;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = commonProduct / nums[i];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.printf("Result: %s\n", Arrays.toString(ArrayProductExceptSelf.productExceptSelf(new int[]{-1,1,0,-3,3})));
    }
}
