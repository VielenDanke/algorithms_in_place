package golang_solutions

import "github.com/vielendanke/algorithms_in_place/leetcode/linked_list"

func detectCycle(head *linked_list.ListNode) *linked_list.ListNode {
	visited := make(map[*linked_list.ListNode]interface{})

	for head != nil {
		if _, ok := visited[head]; ok {
			return head
		}
		visited[head] = nil
		head = head.Next
	}
	return head
}

func detectCycleWithoutMap(head *linked_list.ListNode) *linked_list.ListNode {
	slow := head
	fast := head

	if slow == nil && fast == nil {
		return head
	}
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			return slow
		}
	}
	return nil
}
