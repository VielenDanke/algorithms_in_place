package easy

import "github.com/vielendanke/algorithms_in_place/linked_list"

func getIntersectionNode(headA, headB *linked_list.ListNode) *linked_list.ListNode {
	storage := make(map[*linked_list.ListNode]interface{})

	for headA != nil {
		storage[headA] = nil
		headA = headA.Next
	}
	for headB != nil {
		if _, ok := storage[headB]; ok {
			return headB
		}
		headB = headB.Next
	}
	return nil
}

func getIntersectionNodeConstantSpace(headA, headB *linked_list.ListNode) *linked_list.ListNode {
	lenA, lenB := findLen(headA), findLen(headB)
	skipA, diffNum := diff(lenA, lenB)

	if skipA {
		headA = moveHead(headA, diffNum)
	} else {
		headB = moveHead(headB, diffNum)
	}
	if headA == headB {
		return headA
	}
	for headA != nil && headB != nil {
		if headA.Next == headB.Next {
			return headA.Next
		}
		headA = headA.Next
		headB = headB.Next
	}
	return nil
}

func diff(lenA, lenB int) (bool, int) {
	if lenA > lenB {
		return true, lenA - lenB
	}
	return false, lenB - lenA
}

func moveHead(head *linked_list.ListNode, diff int) *linked_list.ListNode {
	for diff > 0 {
		head = head.Next
		diff--
	}
	return head
}

func findLen(node *linked_list.ListNode) (length int) {
	for node != nil {
		length++
		node = node.Next
	}
	return
}
