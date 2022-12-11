package golang_solution

import "github.com/vielendanke/algorithms_in_place/leetcode/linked_list"

/**
 * Definition for singly-linked list.
 * type leetcode.linked_list.ListNode struct {
 *     val int
 *     next *leetcode.linked_list.ListNode
 * }
 */
// O(N) time | O(1) space

func swapNodes(head *linked_list.ListNode, k int) *linked_list.ListNode {
	temp := head
	lengthOfHead := 1
	left, right := 0, 0
	for temp != nil {
		if lengthOfHead == k {
			left = temp.Val
		}
		lengthOfHead++
		temp = temp.Next
	}
	temp = head
	counter := 1

	for temp != nil {
		if lengthOfHead-k == counter {
			right = temp.Val
		}
		counter++
		temp = temp.Next
	}
	counter = 1
	temp = head

	for temp != nil {
		if counter == k {
			temp.Val = right
		}
		if counter == lengthOfHead-k {
			temp.Val = left
		}
		temp = temp.Next
		counter++
	}
	return head
}

// O(N) time | O(1) space

func swapNodesWithTwoIterations(head *linked_list.ListNode, k int) *linked_list.ListNode {
	left, right := head, head
	counter := 0
	for left != nil {
		counter++
		if counter == k {
			break
		}
		left = left.Next
	}
	pNode := left

	for pNode.Next != nil {
		pNode = pNode.Next
		right = right.Next
	}
	left.Val, right.Val = right.Val, left.Val
	return head
}

// O(N) time | O(N) space

func swapNodesBruteForce(head *linked_list.ListNode, k int) *linked_list.ListNode {
	store := make([]int, 0)

	temp := head

	for temp != nil {
		store = append(store, temp.Val)
		temp = temp.Next
	}
	store[k-1], store[len(store)-k] = store[len(store)-k], store[k-1]

	temp = head

	for _, v := range store {
		temp.Val = v
		temp = temp.Next
	}
	return head
}
