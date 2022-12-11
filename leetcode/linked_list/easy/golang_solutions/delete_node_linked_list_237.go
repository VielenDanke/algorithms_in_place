package golang_solutions

import "github.com/vielendanke/algorithms_in_place/leetcode/linked_list"

func deleteNode(node *linked_list.ListNode) {
	node.Val = node.Next.Val
	node.Next = node.Next.Next
}
