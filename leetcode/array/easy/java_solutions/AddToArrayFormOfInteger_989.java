package leetcode.array.easy.java_solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger_989 {

    static class Solution {
        public List<Integer> addToArrayForm(int[] num, int k) {
            int idx = num.length - 1, carry = 0;
            List<Integer> l = new ArrayList<>();
            while (k > 0 || idx >= 0) {
                int ld = 0, ldArray = 0;

                if (k > 0) {
                    ld = k % 10;
                }
                if (idx >= 0) {
                    ldArray = num[idx];
                }
                int sum = ld + ldArray + carry;

                if (sum >= 10) {
                    carry = 1;
                    l.add(sum % 10);
                } else {
                    carry = 0;
                    l.add(sum);
                }
                idx--;
                k /= 10;
            }
            if (carry > 0) l.add(carry);
            Collections.reverse(l);
            return l;
        }
    }
}
