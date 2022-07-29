package linked_list.medium.java_solution;

import java.util.*;

import static linked_list.Helper.ListNode;

public class SortList_148 {

    private static class SolutionMergeSort {

        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode middle = findMiddle(head);
            ListNode left = sortList(head);
            ListNode right = sortList(middle);
            return merge(left, right);
        }

        private ListNode merge(ListNode left, ListNode right) {
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    tail.next = left;
                    left = left.next;
                } else {
                    tail.next = right;
                    right = right.next;
                }
                tail = tail.next;
            }
            tail.next = (left != null) ? left : right;
            return dummy.next;
        }

        private ListNode findMiddle(ListNode node) {
            ListNode prev = null;

            while (node != null && node.next != null) {
                prev = (prev == null) ? node : prev.next;
                node = node.next.next;
            }
            ListNode middle = prev.next;
            prev.next = null;
            return middle;
        }
    }

    private static class SolutionBruteForceList {

        public ListNode sortList(ListNode head) {
            List<Integer> list = new ArrayList<>();

            ListNode temp = head;

            while (temp != null) {
                list.add(temp.val);
                temp = temp.next;
            }
            list.sort(Comparator.comparingInt(Integer::intValue));

            temp = head;

            for (int num : list) {
                temp.val = num;
                temp = temp.next;
            }
            return head;
        }
    }

    private static class SolutionBruteForceQueue {

        public ListNode sortList(ListNode head) {
            Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));

            ListNode temp = head;

            while (temp != null) {
                queue.add(temp.val);
                temp = temp.next;
            }
            temp = head;

            while (!queue.isEmpty()) {
                temp.val = queue.poll();
                temp = temp.next;
            }
            return head;
        }
    }
}
