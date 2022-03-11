package javasolutions.linkedlist.medium;

import java.util.ArrayList;
import java.util.List;
import javasolutions.linkedlist.ListNode;

public class RotateList {

    public static ListNode rotateRightBetter(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode curr = head;
        int count = 1;
        while (curr.next != null) {
            count++;
            curr = curr.next;
        }
        curr.next = head;
        k = count - (k % count);
        while (k-- > 0) {
            curr = curr.next;
        }
        head = curr.next;
        curr.next = null;

        return head;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] rotatedList = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            int idx;
            if (i + k > list.size() - 1) {
                idx = (i + k) % list.size();
            } else {
                idx = i + k;
            }
            rotatedList[idx] = list.get(i);
        }
        ListNode newHead = new ListNode(rotatedList[0]);

        ListNode temp = newHead;

        for (int i = 1; i < rotatedList.length; i++) {
            temp.next = new ListNode(rotatedList[i]);
            temp = temp.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = rotateRightBetter(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))), 2);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
