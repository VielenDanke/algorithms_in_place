package leetcode.linked_list;

import static leetcode.linked_list.Helper.*;

public class SplitLinkedListInParts_725 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution {
        public ListNode[] splitListToParts(ListNode head, int k) {
            // nextPart always lower or equal
            ListNode temp = head;

            int length;

            for (length = 0; temp != null; length++) {
                temp = temp.next;
            }
            temp = head;
            ListNode[] result = new ListNode[k];
            int extra = length % k;
            int part = length / k;
            int idx = 0;
            while (temp != null) {
                result[idx++] = temp;

                int currentLength = part - 1 + ((extra-- > 0) ? 1 : 0);

                for (int i = 0; i < currentLength; i++) {
                    temp = temp.next;
                }
                ListNode next = temp.next;
                temp.next = null;
                temp = next;
            }
            return result;
        }
    }
}
