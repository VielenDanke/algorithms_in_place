package javasolutions.array.medium;

public class SortColorsInPlace {

    public static void sortColors(int[] nums) {
        int currentNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != currentNumber) {
                int j = nums.length - 1;
                while (nums[j] != currentNumber) {
                    if (j == i) {
                        break;
                    }
                    j--;
                }
                if (j == i && currentNumber == 3) {
                    return;
                } else if (j == i) {
                    currentNumber++;
                    i--;
                } else {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

    public static void sortColorsBubbleSort(int[] nums) {
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i + 1 < nums.length; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
    }
}
