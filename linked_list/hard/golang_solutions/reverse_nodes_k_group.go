package golang_solutions

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseKGroup(head *ListNode, k int) *ListNode {
	nodes := make([]int, 0)

	temp := head

	for temp != nil {
		nodes = append(nodes, temp.Val)
		temp = temp.Next
	}
	i, j := 0, 0+k
	for j <= len(nodes) {
		sub := nodes[i:j]
		left, right := 0, len(sub)-1
		for left < right {
			sub[left], sub[right] = sub[right], sub[left]
			left++
			right--
		}
		i += k
		j = i + k
	}
	temp = head
	currentIdx := 0
	for temp != nil {
		temp.Val = nodes[currentIdx]
		currentIdx++
		temp = temp.Next
	}
	return head
}
