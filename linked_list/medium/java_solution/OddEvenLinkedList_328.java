package linked_list.medium.java_solution;

import static linked_list.Helper.ListNode;

public class OddEvenLinkedList_328 {

    private static class SolutionTwoLists {

        public ListNode oddEvenList(ListNode head) {
            ListNode odd = new ListNode(0);
            ListNode even = new ListNode(0);
            ListNode resultOdd = odd;
            ListNode resultEven = even;
            int current = 1;
            while (head != null) {
                if (current % 2 == 0) {
                    even.next = head;
                    even = even.next;
                } else {
                    odd.next = head;
                    odd = odd.next;
                }
                head = head.next;
                current++;
            }
            odd.next = resultEven.next;
            even.next = null;
            return resultOdd.next;
        }
    }

    private static class Solution {

        public ListNode oddEvenList(ListNode head) {
            ListNode dummy = new ListNode();
            ListNode result = dummy;

            int counter = 0;

            ListNode temp = head;

            while (temp != null) {
                if (counter % 2 == 0) {
                    dummy.next = new ListNode(temp.val);
                    dummy = dummy.next;
                }
                temp = temp.next;
                counter++;
            }
            temp = head;

            counter = 0;

            while (temp != null) {
                if (counter % 2 != 0) {
                    dummy.next = new ListNode(temp.val);
                    dummy = dummy.next;
                }
                temp = temp.next;
                counter++;
            }
            dummy.next = null;
            return result.next;
        }
    }
}
