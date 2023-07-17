package leetcode.linked_list.medium.java_solution;

import java.util.ArrayList;
import java.util.List;

import static leetcode.linked_list.Helper.ListNode;

public class AddTwoNumbers2_445 {

    static class SolutionList {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();

            while (l1 != null) {
                left.add(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                right.add(l2.val);
                l2 = l2.next;
            }
            int i = left.size() - 1, j = right.size() - 1;

            List<Integer> result = new ArrayList<>();

            int remainder = 0;

            while (i >= 0 && j >= 0) {
                int sum = left.get(i) + right.get(j) + remainder;
                remainder = sum / 10;
                sum %= 10;
                result.add(sum);
                i--;
                j--;
            }
            while (i >= 0) {
                int sum = left.get(i) + remainder;
                remainder = sum / 10;
                sum %= 10;
                result.add(sum);
                i--;
            }
            while (j >= 0) {
                int sum = right.get(j) + remainder;
                remainder = sum / 10;
                sum %= 10;
                result.add(sum);
                j--;
            }
            ListNode dummy = new ListNode();
            ListNode res = dummy;
            if (remainder != 0) {
                dummy.next = new ListNode(remainder);
                dummy = dummy.next;
            }
            for (int k = result.size() - 1; k >= 0; k--) {
                dummy.next = new ListNode(result.get(k));
                dummy = dummy.next;
            }
            return res.next;
        }
    }
}
