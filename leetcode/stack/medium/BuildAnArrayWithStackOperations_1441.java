package leetcode.stack.medium;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations_1441 {

    static class Solution {
        public List<String> buildArray(int[] target, int n) {
            // 1..n inclusive
            // Push Pop
            List<String> result = new ArrayList<>();
            if (target == null || target.length == 0) {
                return result;
            }
            if (target[0] > 1) {
                addNonExistentElements(result, 1, target[0]);
            }
            for (int i = 0; i < target.length; i++) {
                if (i > 0) {
                    int diff = target[i] - target[i - 1] - 1;
                    addNonExistentElements(result, 0, diff);
                }
                result.add("Push");
            }
            return result;
        }

        private void addNonExistentElements(List<String> result, int start, int end) {
            for (int j = start; j < end; j++) {
                result.add("Push");
            }
            for (int j = start; j < end; j++) {
                result.add("Pop");
            }
        }
    }
}
