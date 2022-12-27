package leetcode.strings.medium.java_solutions;

import java.util.Arrays;

public class TextSplitting {

    static class Solution {

        public static void main(String[] args) {
            System.out.println(new Solution().lines("bla bla blablablabla       bla   bla\n     \n     blalsadlakwdkjalwmd\n", 4));
        }

        public int lines(String text, int pageWidth) {
            if (text == null) {
                return 0;
            }
            int n = text.length();
            if (n == 0) {
                return 0;
            }
            if (text.isBlank()) {
                return (n / pageWidth) + 1;
            }
            String[] words = text.split(" ");

            int lines = 0, currentWidth = 0;

            for (String word : words) {
                if (word.contains("\n")) {
                    if (word.length() + currentWidth > pageWidth) {
                        lines += 2;
                    } else {
                        lines++;
                    }
                    currentWidth = 0;
                } else if (word.length() > pageWidth) {
                    int linesToIncr = word.length() / pageWidth;
                    lines += linesToIncr;
                    currentWidth = word.length() % pageWidth;
                } else if (word.length() + currentWidth <= pageWidth) {
                    currentWidth += word.length();
                } else {
                    lines++;
                    currentWidth = word.length();
                }
                currentWidth++;
                if (currentWidth == pageWidth) {
                    lines++;
                    currentWidth = 0;
                }
            }
            return lines;
        }
    }
}
