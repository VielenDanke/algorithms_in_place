package leetcode.linked_list.medium.java_solution;

import java.util.ArrayList;
import java.util.List;

import static leetcode.linked_list.Helper.ListNode;

public class MaximumTwinSumOfLinkedList_2130 {

    static class SolutionReverseList {
        public int pairSum(ListNode head) {
            Object[] res = reverseLinkedList(head);
            ListNode node = (ListNode) res[0];
            Integer size = (Integer) res[1];
            int maxSum = 0;
            while (head != null && node != null && size / 2 >= 1) {
                maxSum = Math.max(maxSum, node.val + head.val);
                node = node.next;
                head = head.next;
                size--;
            }
            return maxSum;
        }

        private Object[] reverseLinkedList(ListNode head) {
            ListNode node = new ListNode();
            int counter = 0;

            while (head != null) {
                node.val = head.val;
                ListNode next = new ListNode();
                next.next = node;
                head = head.next;
                node = next;
                counter++;
            }
            return new Object[]{node.next, counter};
        }
    }

    static class Solution {
        public int pairSum(ListNode head) {
            List<Integer> list = new ArrayList<>();

            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            int left = 0, right = list.size() - 1, maxSum = Integer.MIN_VALUE;
            while (left < right) {
                maxSum = Math.max(maxSum, list.get(left++) + list.get(right--));
            }
            return maxSum;
        }
    }
}
