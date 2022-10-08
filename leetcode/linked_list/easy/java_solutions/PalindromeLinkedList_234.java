package leetcode.linked_list.easy.java_solutions;

import java.util.ArrayList;
import java.util.List;

import static leetcode.linked_list.Helper.*;

public class PalindromeLinkedList_234 {

    private static class SolutionBruteForce {
        public boolean isPalindrome(ListNode head) {
            List<Integer> list = buildList(head);
            return isPalindrome(list);
        }

        private boolean isPalindrome(List<Integer> list) {
            int left = 0, right = list.size() - 1;

            if (left == right) return true;

            while (left < right) {
                if (!list.get(left).equals(list.get(right))) return false;
                left++;
                right--;
            }
            return true;
        }

        private List<Integer> buildList(ListNode head) {
            List<Integer> list = new ArrayList<>();

            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            return list;
        }
    }

    private static class Solution {

        public boolean isPalindrome(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            if (fast != null) {
                slow = slow.next;
            }
            slow = reverse(slow);
            fast = head;

            while (slow != null) {
                if (fast.val != slow.val) {
                    return false;
                }
                fast = fast.next;
                slow = slow.next;
            }
            return true;
        }

        public ListNode reverse(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }
    }
}
