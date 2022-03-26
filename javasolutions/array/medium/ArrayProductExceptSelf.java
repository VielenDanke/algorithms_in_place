package javasolutions.array.medium;

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
        if (zeroCounter == 1) {
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
}
