package medium

import "github.com/vielendanke/preparation/linked_list"

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
	if head == nil || head.Next == nil || head.Next.Next == nil {
		return nil
	}
	first := head.Next
	second := head.Next.Next

	for first != nil && second != nil && second.Next != nil {
		if first == second {
			break
		}
		first = first.Next
		second = second.Next.Next
	}
	first = head
	for first != nil && second != nil {
		if first == second {
			return first
		}
		first = first.Next
		second = second.Next
	}
	return nil
}
