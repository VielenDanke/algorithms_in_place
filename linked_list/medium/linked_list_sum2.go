package medium

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(f *ListNode, s *ListNode) *ListNode {
	dump := &ListNode{}
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
		dump.Next = &ListNode{Val: tempVal}
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
		dump.Next = &ListNode{Val: tempVal}
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
		dump.Next = &ListNode{Val: tempVal}
		dump = dump.Next
		s = s.Next
	}
	if remainder != 0 {
		dump.Next = &ListNode{Val: remainder}
	}
	return temp.Next
}
