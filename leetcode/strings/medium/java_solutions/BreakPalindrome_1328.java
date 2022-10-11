package leetcode.strings.medium.java_solutions;

public class BreakPalindrome_1328 {

    static class Solution {
        public String breakPalindrome(String palindrome) {
            if (palindrome == null) return "";

            int n = palindrome.length();

            if (n == 0 || n == 1) return "";

            char[] pal = palindrome.toCharArray();

            int left = 0, right = n - 1;

            while (left < right && pal[left] == 'a') {
                left++;
                right--;
            }
            if (left >= right) {
                pal[n - 1] = 'b';
            } else {
                pal[left] = 'a';
            }
            return new String(pal);
        }
    }

    static class SolutionBruteForce {
        public String breakPalindrome(String palindrome) {
            if (palindrome == null) return "";

            int n = palindrome.length();

            if (n == 0 || n == 1) return "";

            String toSwitch = "";

            char[] pal = palindrome.toCharArray();

            int left = 0, right = n - 1;

            while (left < right) {
                toSwitch = swapAndReturn(pal, left++, toSwitch);
                toSwitch = swapAndReturn(pal, right--, toSwitch);
            }
            return toSwitch;
        }

        private String swapAndReturn(char[] pal, int idx, String toSwitch) {
            char current = pal[idx];
            if (current > 97) {
                pal[idx] = 'a';
            } else if (current == 97) {
                pal[idx] = 'b';
            }
            String s = new String(pal);
            if (toSwitch.isEmpty() || s.compareTo(toSwitch) < 0) {
                toSwitch = s;
            }
            pal[idx] = current;
            return toSwitch;
        }
    }
}
