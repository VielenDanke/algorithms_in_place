package hackerrank.array.easy;

import java.util.LinkedList;
import java.util.List;

public class SequenceEquation {

    // https://www.hackerrank.com/challenges/permutation-equation/problem

    static class Solution {

        public static List<Integer> permutationEquation(List<Integer> p) {
            List<Integer> result = new LinkedList<>();

            for (int i = 1; i <= p.size(); i++) {
                result.add(p.indexOf(p.indexOf(i) + 1) + 1);
            }
            return result;
        }
    }
}
