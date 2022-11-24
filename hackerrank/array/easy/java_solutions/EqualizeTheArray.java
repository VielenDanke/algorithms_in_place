package hackerrank.array.easy.java_solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualizeTheArray {

    // https://www.hackerrank.com/challenges/equality-in-a-array/problem

    static class Solution {
        public static int equalizeArray(List<Integer> arr) {
            Map<Integer, Integer> m = new HashMap<>();

            int maxVal = 0, maxNum = 0;

            for (Integer v : arr) {
                int counter = m.getOrDefault(v, 0) + 1;
                m.put(v, counter);
                if (counter > maxVal) {
                    maxVal = counter;
                    maxNum = v;
                }
            }
            return arr.size() - m.get(maxNum);
        }
    }
}
