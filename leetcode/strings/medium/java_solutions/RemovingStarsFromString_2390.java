package leetcode.strings.medium.java_solutions;

public class RemovingStarsFromString_2390 {

    static class Solution {
        public String removeStars(String s) {
            StringBuilder builder = new StringBuilder();

            for (char c : s.toCharArray()) {
                if (c == '*' && !builder.isEmpty()) {
                    builder.deleteCharAt(builder.length() - 1);
                } else {
                    builder.append(c);
                }
            }
            return builder.toString();
        }
    }
}
