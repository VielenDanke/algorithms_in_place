package leetcode.geometry.medium;

public class RectangleArea_223 {

    static class Solution {
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            int areaOfSqrA = (ax2-ax1) * (ay2-ay1);
            int areaOfSqrB = (bx2-bx1) * (by2-by1);

            int left = Math.max(ax1, bx1);
            int right = Math.min(bx2, ax2);
            int bottom = Math.max(by1, ay1);
            int top = Math.min(ay2, by2);

            int overlap = 0;
            if(right > left && top > bottom)
                overlap = (right - left) * (top - bottom);

            return areaOfSqrA + areaOfSqrB - overlap;
        }
    }
}
