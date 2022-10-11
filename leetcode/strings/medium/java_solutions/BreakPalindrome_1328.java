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

            StringBuilder toSwitch = new StringBuilder();

            int n = palindrome.length();

            if (n == 0 || n == 1) return "";

            toSwitch.append("z".repeat(n));

            char[] pal = palindrome.toCharArray();
            int left = 0, right = n - 1;
            while (left < right) {
                char current = pal[left];
                if (current > 97) {
                    pal[left] = 'a';
                } else if (current == 97) {
                    pal[left] = 'b';
                }
                StringBuilder b = new StringBuilder();
                b.append(pal);
                if (b.toString().compareTo(toSwitch.toString()) < 0) {
                    toSwitch = new StringBuilder(b.toString());
                }
                pal[left++] = current;
                char rightCurrent = pal[right];
                if (rightCurrent > 97) {
                    pal[right] = 'a';
                } else if (rightCurrent == 97) {
                    pal[right] = 'b';
                }
                b = new StringBuilder();
                b.append(pal);
                if (b.toString().compareTo(toSwitch.toString()) < 0) {
                    toSwitch = new StringBuilder(b.toString());
                }
                pal[right--] = rightCurrent;
            }
            return toSwitch.toString();
        }
    }
}
