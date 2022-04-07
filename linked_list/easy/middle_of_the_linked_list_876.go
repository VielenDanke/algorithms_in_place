package easy

import "github.com/vielendanke/algorithms_in_place/linked_list"

func middleNode(head *linked_list.ListNode) *linked_list.ListNode {
	length := 0

	temp := head

	for temp != nil {
		length++
		temp = temp.Next
	}
	middle := length / 2
	temp = head

	for middle > 0 {
		middle--
		temp = temp.Next
	}
	return temp
}
