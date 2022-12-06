package leetcode.linked_list.medium.java_solution;

import static leetcode.linked_list.Helper.ListNode;

public class OddEvenLinkedList_328 {

    static class Solution {

        public ListNode oddEvenList(ListNode head) {
            if (head == null) return null;
            ListNode odd = head, even = head.next, evenHead = even;
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
        }
    }

    static class SolutionTwoLists {

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

    static class SolutionBruteForce {

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
