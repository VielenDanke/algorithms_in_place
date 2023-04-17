package leetcode.array.easy.java_solutions;

import java.util.LinkedList;
import java.util.List;

public class KidsWithTheGreatesNumberOfCandies_1431 {

    static class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int max = -1 << 30;

            for (int kidCandy : candies) {
                max = Math.max(max, kidCandy);
            }
            List<Boolean> list = new LinkedList<>();

            for (int kidCandy : candies) {
                list.add(kidCandy + extraCandies >= max);
            }
            return list;
        }
    }
}
