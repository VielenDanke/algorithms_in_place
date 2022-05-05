package golang_solution

import "github.com/vielendanke/algorithms_in_place/linked_list"

func reorderList(head *linked_list.ListNode) {
	nodes := make([]int, 0)
	temp := head

	for temp != nil {
		nodes = append(nodes, temp.Val)
		temp = temp.Next
	}
	idx := 0
	temp = head
	for idx <= len(nodes)/2 && temp != nil {
		temp.Val = nodes[idx]
		if temp.Next != nil {
			temp.Next.Val = nodes[len(nodes)-1-idx]
			temp = temp.Next.Next
		}
		idx++
	}
}
