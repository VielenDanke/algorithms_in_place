package linked_list.medium.java_solution;

import static linked_list.Helper.ListNode;

public class OddEvenLinkedList_328 {

    private static class SolutionTwoLists {

        public ListNode oddEvenList(ListNode head) {
            ListNode even = new ListNode();
            ListNode odd = new ListNode();
            ListNode resultEven = even;
            ListNode resultOdd = odd;

            int counter = 0;

            while (head != null) {
                if (counter % 2 == 0) {
                    even.next = new ListNode(head.val);
                    even = even.next;
                } else {
                    odd.next = new ListNode(head.val);
                    odd = odd.next;
                }
                counter++;
                head = head.next;
            }
            even.next = resultOdd.next;
            return resultEven.next;
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

        public static void main(String[] args) {
            new Solution().oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        }
    }
}
