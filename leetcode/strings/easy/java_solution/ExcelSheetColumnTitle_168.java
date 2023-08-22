package leetcode.strings.easy.java_solution;

public class ExcelSheetColumnTitle_168 {

    static class Solution {
        public String convertToTitle(int columnNumber) {
            int del = 26;
            StringBuilder result = new StringBuilder();
            while (columnNumber > 0) {
                columnNumber--;
                result.append(Character.toUpperCase((char) (columnNumber % del + 'a')));
                columnNumber /= del;
            }
            return result.reverse().toString();
        }
    }
}
