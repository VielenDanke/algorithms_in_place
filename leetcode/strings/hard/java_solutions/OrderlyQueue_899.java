package leetcode.strings.hard.java_solutions;

import java.util.Arrays;

public class OrderlyQueue_899 {

    static class Solution {
        public String orderlyQueue(String s, int k) {
            if (k > 1) {
                char[] letters = s.toCharArray();
                Arrays.sort(letters);
                return new String(letters);
            }
            String res = s;
            for (int i = 1; i < s.length(); i++) {
                String tmp = s.substring(i) + s.substring(0, i);
                if (res.compareTo(tmp) > 0) res = tmp;
            }
            return res;
        }
    }
}
