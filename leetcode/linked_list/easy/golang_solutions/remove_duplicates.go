package golang_solutions

import "github.com/vielendanke/algorithms_in_place/leetcode/easy"

type LinkedList struct {
	Value int
	Next  *LinkedList
}

// iterate over linked list
// if next == temp - switch the pointer to next node
// repeat the process until the different number appears

func RemoveDuplicatesFromLinkedList3(linkedList *LinkedList) *LinkedList {
	intSet := make(map[int]interface{})

	temp := linkedList

	intSet[linkedList.Value] = nil

	for temp.Next != nil {
		if _, ok := intSet[temp.Next.Value]; ok {
			temp.Next = temp.Next.Next
		} else {
			temp = temp.Next
			intSet[temp.Value] = nil
		}
	}
	return linkedList
}

func RemoveDuplicatesFromLinkedList2(linkedList *LinkedList) *LinkedList {
	currentNode := linkedList
	for currentNode != nil {
		nextDistinctNode := currentNode.Next
		for nextDistinctNode != nil && nextDistinctNode.Value == currentNode.Value {
			nextDistinctNode = nextDistinctNode.Next
		}
		currentNode.Next = nextDistinctNode
		currentNode = nextDistinctNode
	}
	return linkedList
}

func RemoveDuplicatesFromLinkedList(linkedList *LinkedList) *LinkedList {
	temp := linkedList

	prevNum := linkedList.Value

	for temp.Next != nil {
		if temp.Next.Value == prevNum {
			temp.Next = temp.Next.Next
		} else {
			temp = temp.Next
			prevNum = temp.Value
		}
	}
	return linkedList
}

func RemoveDuplicatesFromLinkedList4(head *easy.ListNode) *easy.ListNode {
	if head == nil {
		return nil
	}
	if head.Next != nil && head.Val == head.Next.Val {
		for head.Next != nil && head.Val == head.Next.Val {
			head = head.Next
		}
		return RemoveDuplicatesFromLinkedList4(head.Next)
	} else {
		head.Next = RemoveDuplicatesFromLinkedList4(head.Next)
	}
	return head
}
