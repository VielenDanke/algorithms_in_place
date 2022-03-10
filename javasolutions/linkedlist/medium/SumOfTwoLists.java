package javasolutions.linkedlist.medium;

import javasolutions.linkedlist.ListNode;

public class SumOfTwoLists {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headPointer = new ListNode(0);
        ListNode currentNode = headPointer;
        int carry = 0;
        ListNode firstNode = l1;
        ListNode secondNode = l2;

        while (firstNode != null || secondNode != null || carry != 0) {
            int firstValue = (firstNode != null) ? firstNode.val : 0;
            int secondValue = (secondNode != null) ? secondNode.val : 0;
            int sumOfValues = firstValue + secondValue + carry;

            int newValue = sumOfValues % 10;
            ListNode newNode = new ListNode(newValue);
            currentNode.next = newNode;
            currentNode = newNode;

            carry = sumOfValues / 10;
            firstNode = (firstNode != null) ? firstNode.next : null;
            secondNode = (secondNode != null) ? secondNode.next : null;
        }
        return headPointer.next;
    }
}
