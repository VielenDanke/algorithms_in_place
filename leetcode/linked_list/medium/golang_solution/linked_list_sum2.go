package golang_solution

import "github.com/vielendanke/algorithms_in_place/leetcode/linked_list"

func addTwoNumbers(f *linked_list.ListNode, s *linked_list.ListNode) *linked_list.ListNode {
	dump := &linked_list.ListNode{}
	temp := dump
	remainder := 0

	for f != nil && s != nil {
		tempVal := f.Val + s.Val

		tempVal += remainder
		remainder = 0

		if tempVal > 9 {
			remainder = tempVal / 10
			tempVal %= 10
		}
		dump.Next = &linked_list.ListNode{Val: tempVal}
		dump = dump.Next
		f = f.Next
		s = s.Next
	}
	for f != nil {
		tempVal := f.Val + remainder
		remainder = 0
		if tempVal > 9 {
			remainder = tempVal / 10
			tempVal %= 10
		}
		dump.Next = &linked_list.ListNode{Val: tempVal}
		dump = dump.Next
		f = f.Next
	}
	for s != nil {
		tempVal := s.Val + remainder
		remainder = 0
		if tempVal > 9 {
			remainder = tempVal / 10
			tempVal %= 10
		}
		dump.Next = &linked_list.ListNode{Val: tempVal}
		dump = dump.Next
		s = s.Next
	}
	if remainder != 0 {
		dump.Next = &linked_list.ListNode{Val: remainder}
	}
	return temp.Next
}
