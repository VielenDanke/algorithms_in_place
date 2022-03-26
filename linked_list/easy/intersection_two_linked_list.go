package easy

type ListNode struct {
	Val  int
	Next *ListNode
}

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	storage := make(map[*ListNode]interface{})

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

func getIntersectionNodeConstantSpace(headA, headB *ListNode) *ListNode {
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

func moveHead(head *ListNode, diff int) *ListNode {
	for diff > 0 {
		head = head.Next
		diff--
	}
	return head
}

func findLen(node *ListNode) (length int) {
	for node != nil {
		length++
		node = node.Next
	}
	return
}
