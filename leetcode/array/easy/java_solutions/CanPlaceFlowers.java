package leetcode.array.easy.java_solutions;

public class CanPlaceFlowers {

    static class Solution {

        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int l = flowerbed.length;
            for (int i = 0; i < l; i++) {
                if (n == 0) return true;
                if (flowerbed[i] != 1 && (i == 0 || flowerbed[i - 1] != 1) && (i == l - 1 || flowerbed[i + 1] != 1)) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
            return n == 0;
        }
    }
}
