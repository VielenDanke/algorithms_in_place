package leetcode.array.easy.java_solutions;

public class PlusOne_66 {

    public int[] plusOne(int[] digits) {
        var currentIdx = digits.length - 1;
        var remainder = 1;

        while (currentIdx >= 0 && remainder != 0) {
            var sum = digits[currentIdx] + remainder;

            if (sum >= 10) {
                digits[currentIdx] = 0;
                currentIdx--;
                remainder = sum / 10;
            } else {
                digits[currentIdx] = sum;
                remainder = 0;
                break;
            }
        }
        if (remainder != 0) {
            int[] array = new int[digits.length + 1];
            array[0] = 1;
            System.arraycopy(digits, 0, array, 1, digits.length);
            return array;
        }
        return digits;
    }

    public int[] plusOneRecursive(int[] digits) {
        return addOneRecursive(digits, digits.length - 1, 1);
    }

    private int[] addOneRecursive(int[] digits, int currentIdx, int remainder) {
        if (currentIdx < 0) {
            int[] array = new int[digits.length + 1];
            array[0] = 1;
            System.arraycopy(digits, 0, array, 1, digits.length);
            return array;
        }
        var sum = digits[currentIdx] + remainder;
        if (sum >= 10) {
            digits[currentIdx] = 0;
            return addOneRecursive(digits, currentIdx - 1, sum / 10);
        } else {
            digits[currentIdx] = sum;
        }
        return digits;
    }
}
