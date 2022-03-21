package easy

import "github.com/vielendanke/preparation/leetcode/easy"

func reverse(head *easy.ListNode) *easy.ListNode {
	var prev *easy.ListNode
	current := head
	for current != nil {
		next := current.Next
		current.Next = prev
		current = current.Next
		current = next
	}
	return prev
}

func reverseRecursive(head, prev *easy.ListNode) *easy.ListNode {
	if head == nil {
		return prev
	}
	next := head.Next
	head.Next = prev
	return reverseRecursive(next, head)
}
