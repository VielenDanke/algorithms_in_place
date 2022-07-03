package array.medium.java_solutions;

import java.util.Arrays;

public class MaxAreaPieceCake_1465 {

    public int maxArea(int h, int w, int[] arrH, int[] arrV) {
        Arrays.sort(arrH);
        Arrays.sort(arrV);
        int maxH = calculateMax(arrH, h), maxV = calculateMax(arrV, w);
        return (int) ((long) maxH * maxV % 1000000007);
    }

    private int calculateMax(int[] arr, int v) {
        int max = -1 << 30;
        for (int i = 0; i + 1 < arr.length; i++) {
            max = Math.max(max, arr[i + 1] - arr[i]);
        }
        return Math.max(Math.max(max, arr[0]), v - arr[arr.length - 1]);
    }
}
