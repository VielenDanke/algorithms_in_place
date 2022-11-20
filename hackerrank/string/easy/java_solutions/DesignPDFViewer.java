package hackerrank.string.easy.java_solutions;

import java.util.List;

public class DesignPDFViewer {

    // https://www.hackerrank.com/challenges/designer-pdf-viewer/problem

    static class Solution {

        public static int designerPdfViewer(List<Integer> h, String word) {
            int maxHeight = 0, n = word.length();

            for (int i = 0; i < n; i++) {
                maxHeight = Math.max(maxHeight, h.get(word.charAt(i) - 'a'));
            }
            return maxHeight * n;
        }
    }
}
