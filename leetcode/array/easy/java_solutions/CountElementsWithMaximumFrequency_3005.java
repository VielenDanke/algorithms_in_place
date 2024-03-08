package leetcode.array.easy.java_solutions;

public class CountElementsWithMaximumFrequency_3005 {

    static class Solution {
        public int maxFrequencyElements(int[] nums) {
            int[] array = new int[101];

            for (int num : nums) {
                array[num]++;
            }
            int maxFreq = -1 << 30;
            int elements = 0;

            for (int num : nums) {
                if (array[num] > maxFreq && array[num] != 0) {
                    maxFreq = array[num];
                    elements = 1;
                } else if (array[num] == maxFreq) {
                    elements++;
                }
            }
            return elements;
        }
    }
}
