package leetcode.linked_list.easy.java_solutions;

import static leetcode.linked_list.Helper.ListNode;

public class MiddleOfTheLinkedList_876 {

    static class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }

    static class SolutionCounter {
        public ListNode middleNode(ListNode head) {
            int n = 0;

            ListNode temp = head;

            while (temp != null) {
                temp = temp.next;
                n++;
            }
            for (int i = 0; i < n / 2; i++) {
                head = head.next;
            }
            return head;
        }
    }
}
