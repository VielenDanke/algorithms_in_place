package leetcode.linked_list.easy.java_solutions;

import static leetcode.linked_list.Helper.ListNode;

public class DeleteNodeLinkedList_237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
