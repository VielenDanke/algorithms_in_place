package leetcode.linked_list.medium.java_solution;

import leetcode.linked_list.Helper;

import static leetcode.linked_list.Helper.*;

public class PartitionList_86 {

    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode greater = new ListNode();
            ListNode lower = new ListNode();
            ListNode resultLower = lower;
            ListNode resultGreater = greater;

            while (head != null) {
                if (head.val >= x) {
                    greater.next = head;
                    greater = greater.next;
                } else {
                    lower.next = head;
                    lower = lower.next;
                }
                head = head.next;
            }
            greater.next = null;
            lower.next = resultGreater.next;
            return resultLower.next;
        }
    }
}
