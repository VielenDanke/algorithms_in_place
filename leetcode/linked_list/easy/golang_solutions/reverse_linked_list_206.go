package golang_solutions

import "github.com/vielendanke/algorithms_in_place/leetcode/linked_list"

func reverse(head *linked_list.ListNode) *linked_list.ListNode {
	var previousNode, currentNode *linked_list.ListNode = nil, head

	for currentNode != nil {
		nextNode := currentNode.Next
		currentNode.Next = previousNode
		previousNode = currentNode
		currentNode = nextNode
	}
	return previousNode
}

func reverseRecursive(head, prev *linked_list.ListNode) *linked_list.ListNode {
	if head == nil {
		return prev
	}
	next := head.Next
	head.Next = prev
	return reverseRecursive(next, head)
}
