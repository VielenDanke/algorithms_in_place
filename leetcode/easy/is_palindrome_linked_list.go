package easy

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func isPalindrome3(head *ListNode) bool {
	listLength := 0

	temp := head

	for temp != nil {
		listLength++
		temp = temp.Next
	}
	temp = head
	stack := make([]int, 0)

	var nodeVal int

	isPrime := listLength%2 == 0

	for i := 0; i < listLength/2; i++ {
		stack = append(stack, temp.Val)
		temp = temp.Next
	}
	if !isPrime {
		temp = temp.Next
	}
	for i := listLength / 2; i < listLength && len(stack) != 0; i++ {
		nodeVal, stack = stack[len(stack)-1], stack[:len(stack)-1]
		if nodeVal != temp.Val {
			return false
		}
		temp = temp.Next
	}
	return len(stack) == 0
}

func isPalindrome2(head *ListNode) bool {
	arr := make([]int, 0)

	for head != nil {
		arr = append(arr, head.Val)
		head = head.Next
	}
	start, end := 0, len(arr)-1
	for start < end {
		if arr[start] != arr[end] {
			return false
		}
		start++
		end--
	}
	return true
}

func isPalindrome(head *ListNode) bool {
	temp := copyList(head)
	reversedHead := reverseListPalindrome(head)
	head = temp
	length := 0

	for temp != nil {
		length++
		temp = temp.Next
	}
	// for head != nil && length >= 0 && reversedHead != nil {
	// 	if head.Val != reversedHead.Val {
	// 		return false
	// 	}
	// 	head = head.Next
	// 	reversedHead = reversedHead.Next
	// 	length--
	// }
	return isPalindromeRecursive(head, reversedHead, length)
}

func isPalindromeRecursive(head, reversedHead *ListNode, length int) bool {
	if length == 1 {
		return head.Val == reversedHead.Val
	}
	return head.Val == reversedHead.Val && isPalindromeRecursive(head.Next, reversedHead.Next, length-1)
}

func copyList(head *ListNode) *ListNode {
	n := &ListNode{Val: head.Val}
	temp := n
	head = head.Next
	for head != nil {
		n.Next = &ListNode{Val: head.Val}
		head = head.Next
		n = n.Next
	}
	return temp
}

func reverseListPalindrome(head *ListNode) *ListNode {
	var next, prev *ListNode
	curr := head
	for curr != nil {
		next = curr.Next
		curr.Next = prev
		prev = curr
		curr = next
	}
	return prev
}
