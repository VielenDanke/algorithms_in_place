package leetcode.backtracking_recursion.java_solutions;

import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses_93 {

    static class Solution {

        public List<String> restoreIpAddresses(String s) {
            LinkedList<String> list = new LinkedList<>();
            backtrack(list, new LinkedList<>(), s);
            return list;
        }

        private void backtrack(LinkedList<String> result, LinkedList<String> temp, String s) {
            if (temp.size() == 4 && s.length() == 0) {
                result.add(String.join(".", temp));
                return;
            }
            for (int i = 1; i <= 3; i++) {
                if (i > s.length()) {
                    continue;
                }
                String sub = s.substring(0, i);
                if (isIpPartInvalid(sub)) {
                    continue;
                }
                temp.add(sub);
                backtrack(result, temp, s.substring(i));
                temp.removeLast();
            }
        }

        private boolean isIpPartInvalid(String ipPart) {
            return (ipPart.length() > 1 && ipPart.charAt(0) == '0') || convertToInt(ipPart) > 255;
        }

        private int convertToInt(String s) {
            int pow = 0;
            int incr = 10;
            int res = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                res += (s.charAt(i) - '0') * Math.pow(incr, pow);
                pow++;
            }
            return res;
        }
    }
}
