package golang_solutions

import "github.com/vielendanke/algorithms_in_place/leetcode/linked_list"

// iterate over linked list
// if next == temp - switch the pointer to next node
// repeat the process until the different number appears

func RemoveDuplicatesFromListNode3(ListNode *linked_list.ListNode) *linked_list.ListNode {
	intSet := make(map[int]interface{})

	temp := ListNode

	intSet[ListNode.Val] = nil

	for temp.Next != nil {
		if _, ok := intSet[temp.Next.Val]; ok {
			temp.Next = temp.Next.Next
		} else {
			temp = temp.Next
			intSet[temp.Val] = nil
		}
	}
	return ListNode
}

func RemoveDuplicatesFromListNode2(ListNode *linked_list.ListNode) *linked_list.ListNode {
	currentNode := ListNode
	for currentNode != nil {
		nextDistinctNode := currentNode.Next
		for nextDistinctNode != nil && nextDistinctNode.Val == currentNode.Val {
			nextDistinctNode = nextDistinctNode.Next
		}
		currentNode.Next = nextDistinctNode
		currentNode = nextDistinctNode
	}
	return ListNode
}

func RemoveDuplicatesFromListNode(ListNode *linked_list.ListNode) *linked_list.ListNode {
	temp := ListNode

	prevNum := ListNode.Val

	for temp.Next != nil {
		if temp.Next.Val == prevNum {
			temp.Next = temp.Next.Next
		} else {
			temp = temp.Next
			prevNum = temp.Val
		}
	}
	return ListNode
}

func RemoveDuplicatesFromListNode4(head *linked_list.ListNode) *linked_list.ListNode {
	if head == nil {
		return nil
	}
	if head.Next != nil && head.Val == head.Next.Val {
		for head.Next != nil && head.Val == head.Next.Val {
			head = head.Next
		}
		return RemoveDuplicatesFromListNode4(head.Next)
	} else {
		head.Next = RemoveDuplicatesFromListNode4(head.Next)
	}
	return head
}
