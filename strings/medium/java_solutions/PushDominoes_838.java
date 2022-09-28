package strings.medium.java_solutions;

public class PushDominoes_838 {

    static class Solution {
        /*
        Idea:
        1. Moving 1 time through dominoes
        2. if we meet 'R' - we need to check if the most recent index R is greater than left
           if yes - we are dealing with R..R subsequence because left < right and therefore left cannot affect right dominoes
           assign right variable to current index
        3. if we meet 'L' - we need to check if the most recent index L is greater than right
           if yes - we are dealing with R..L subsequence because right < left and therefore left affects right and vise-verse
           if no - we are dealing with L..L subsequence and we need to assign all L until current index i
         */

        public String pushDominoes(String dominoes) {
            char[] dom = dominoes.toCharArray();

            int right = -1, left = -1, n = dom.length;

            for (int i = 0; i <= n; i++) {
                if (i == n || dom[i] == 'R') {
                    if (right > left) { // means we face R..R
                        while (right < i) {
                            dom[right++] = 'R';
                        }
                    }
                    right = i;
                } else if (dom[i] == 'L') {
                    if (left > right || right == -1) { // means we face L..L
                        while (++left < i) {
                            dom[left] = 'L';
                        }
                    } else { // R..L
                        left = i;
                        int low = right + 1, high = left - 1;
                        while (low < high) {
                            dom[low++] = 'R';
                            dom[high--] = 'L';
                        }
                    }
                }
            }
            return new String(dom);
        }
    }
}
