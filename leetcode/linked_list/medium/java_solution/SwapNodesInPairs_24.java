package leetcode.linked_list.medium.java_solution;

import static leetcode.linked_list.Helper.ListNode;

public class SwapNodesInPairs_24 {

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode temp = head;
            while (temp != null && temp.next != null) {
                int val = temp.val;
                temp.val = temp.next.val;
                temp.next.val = val;
                temp = temp.next.next;
            }
            return head;
        }
    }
}
