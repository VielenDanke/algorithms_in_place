package hackerrank.array.easy;

import java.util.List;

public class CircularArrayRotation {

    static class Solution {
        public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
            // Write your code here
            int n = a.size();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                int nextIdx = (i + k) % n;
                arr[nextIdx] = a.get(i);
            }
            queries.replaceAll(integer -> arr[integer]);

            return queries;
        }
    }
}
