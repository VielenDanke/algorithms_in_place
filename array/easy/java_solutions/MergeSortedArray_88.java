package array.easy.java_solutions;

import java.util.Arrays;

public class MergeSortedArray_88 {

    public void merge(int[] l, int m, int[] r, int n) {
        int right = 0;
        for (int i = 0; i < l.length; i++) {
            if (i >= m) {
                l[i] = r[right++];
            }
        }
        Arrays.sort(l);
    }

    // ------------------------------------------------------------------------------

    public void mergeExtraMemory(int[] l, int m, int[] r, int n) {
        int left = 0, right = 0;

        int[] temp = new int[l.length];

        int current = 0;

        while (left < m && right < n) {
            if (l[left] > r[right]) {
                temp[current++] = r[right];
                right++;
            } else {
                temp[current++] = l[left];
                left++;
            }
        }
        while (left < m) {
            temp[current++] = l[left];
            left++;
        }
        while (right < n) {
            temp[current++] = r[right];
            right++;
        }
        System.arraycopy(temp, 0, l, 0, temp.length);
    }
}
