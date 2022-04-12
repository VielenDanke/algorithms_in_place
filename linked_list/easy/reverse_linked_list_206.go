package easy

import "github.com/vielendanke/algorithms_in_place/leetcode/easy"

func reverse(head *easy.ListNode) *easy.ListNode {
	var previousNode, currentNode *easy.ListNode = nil, head

	for currentNode != nil {
		nextNode := currentNode.Next
		currentNode.Next = previousNode
		previousNode = currentNode
		currentNode = nextNode
	}
	return previousNode
}

func reverseRecursive(head, prev *easy.ListNode) *easy.ListNode {
	if head == nil {
		return prev
	}
	next := head.Next
	head.Next = prev
	return reverseRecursive(next, head)
}
