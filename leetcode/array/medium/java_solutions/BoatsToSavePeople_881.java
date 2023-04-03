package leetcode.array.medium.java_solutions;

import java.util.Arrays;

public class BoatsToSavePeople_881 {

    static class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);

            int left = 0, right = people.length - 1, boats = 0;

            while (left <= right) {
                int leftWeight = people[left];
                int rightWeight = people[right];

                if (leftWeight + rightWeight <= limit) {
                    left++;
                }
                right--;
                boats++;
            }
            return boats;
        }
    }
}
