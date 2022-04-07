package medium

import "github.com/vielendanke/algorithms_in_place/linked_list"

func removeNthFromEnd(head *linked_list.ListNode, n int) *linked_list.ListNode {
	if head == nil {
		return head
	}
	length := 0

	temp := head

	for temp != nil {
		length++
		temp = temp.Next
	}
	if length == n {
		head = head.Next
		return head
	}
	temp = head
	for i := 0; i < length; i++ {
		if length-n-1 == i {
			temp.Next = temp.Next.Next
			break
		}
		temp = temp.Next
	}
	return head
}
