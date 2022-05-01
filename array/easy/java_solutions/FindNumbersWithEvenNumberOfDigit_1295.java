package array.easy.java_solutions;

public class FindNumbersWithEvenNumberOfDigit_1295 {

    public int findNumbers(int[] nums) {
        int even = 0;
        for (int i : nums) {
            int temp = i;
            int counter = 0;

            while (temp > 0) {
                counter++;
                temp /= 10;
            }
            if (counter % 2 == 0) {
                even++;
            }
        }
        return even;
    }

    public int findNumbersStringConversion(int[] nums) {
        int even = 0;
        for (int i : nums) {
            String s = String.valueOf(i);
            if (s.length() % 2 == 0) {
                even++;
            }
        }
        return even;
    }
}
