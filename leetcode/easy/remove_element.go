package easy

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeElements(head *ListNode, val int) *ListNode {
	if head == nil {
		return head
	}
	for head != nil && head.Val == val {
		head = head.Next
	}
	root := head
	beforeHead := root
	for head != nil {
		if head.Val == val {
			if head.Next != nil && head.Next.Val == val {
				head = head.Next
				continue
			}
			beforeHead.Next = head.Next
		} else {
			beforeHead = head
		}
		head = head.Next
	}
	return root
}

func removeElements2(head *ListNode, val int) *ListNode {
	if head == nil {
		return nil
	}
	temp := head

	arr := make([]*ListNode, 0)

	for temp != nil {
		if temp.Val != val {
			arr = append(arr, &ListNode{Val: temp.Val})
		}
		temp = temp.Next
	}
	for i := 1; i < len(arr); i++ {
		arr[i-1].Next = arr[i]
	}
	if len(arr) == 0 {
		return nil
	} else {
		return arr[0]
	}
}
