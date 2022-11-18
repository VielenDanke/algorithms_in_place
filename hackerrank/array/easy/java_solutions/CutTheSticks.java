package hackerrank.array.easy.java_solutions;

import java.util.LinkedList;
import java.util.List;

public class CutTheSticks {

    // https://www.hackerrank.com/challenges/cut-the-sticks/problem

    static class Solution {
        public static List<Integer> cutTheSticks(List<Integer> arr) {
            // Write your code here
            List<Integer> collector = new LinkedList<>();

            while (!arr.isEmpty()) {
                int n = arr.size();
                int min = 1 << 30;

                collector.add(n);

                for (Integer v : arr) {
                    min = Math.min(min, v);
                }
                List<Integer> newArr = new LinkedList<>();

                for (Integer v : arr) {
                    if (min < v) {
                        newArr.add(v - min);
                    }
                }
                arr = newArr;
            }
            return collector;
        }
    }
}
