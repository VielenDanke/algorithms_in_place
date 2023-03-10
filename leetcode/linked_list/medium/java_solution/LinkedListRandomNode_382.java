package leetcode.linked_list.medium.java_solution;

import leetcode.linked_list.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static leetcode.linked_list.Helper.*;

public class LinkedListRandomNode_382 {

    static class Solution {

        private final ListNode head;
        private final Random random;

        public Solution(ListNode head) {
            this.head = head;
            this.random = new Random();
        }

        public int getRandom() {
            ListNode current = head;
            int ans = current.val;
            for (int i = 1; current.next != null; i++) {
                current = current.next;
                if (random.nextInt(i + 1) == i) ans = current.val;
            }
            return ans;
        }
    }

    static class SolutionUsingList {

        private final List<Integer> list = new ArrayList<>();
        private final Random random;

        public SolutionUsingList(ListNode head) {
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            random = new Random();
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
