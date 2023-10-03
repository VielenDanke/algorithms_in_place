package leetcode.strings.medium.java_solutions;

public class DecodedStringAtIndex_880 {

    static class Solution {
        public String decodeAtIndex(String s, int k) {
            long decodedLength = 0;

            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    decodedLength *= (ch - '0');
                } else {
                    decodedLength++;
                }
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                char ch = s.charAt(i);

                if (Character.isDigit(ch)) {
                    decodedLength /= (ch - '0');
                    k %= (int) decodedLength;
                } else {
                    if (k == 0 || decodedLength == k) {
                        return String.valueOf(ch);
                    }
                    decodedLength--;
                }
            }
            return "";
        }
    }

    static class SolutionBruteForce {
        public String decodeAtIndex(String s, int k) {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isAlphabetic(ch)) {
                    builder.append(ch);
                } else if (Character.isDigit(ch)) {
                    String toRepeat = builder.toString();
                    builder.append(toRepeat.repeat(((int) (ch - '0')) - 1));
                } else {
                    throw new IllegalStateException("expecting only letters or digits");
                }
                if (builder.length() > k) {
                    return String.valueOf(builder.charAt(k - 1));
                }
            }
            return String.valueOf(builder.charAt(k - 1));
        }
    }
}
