package golang_solutions

import (
	"github.com/vielendanke/algorithms_in_place/leetcode/linked_list"
	"sort"
)

func mergeTwoListsSort(first, second *linked_list.ListNode) *linked_list.ListNode {
	arr := make([]int, 0)
	for first != nil {
		arr = append(arr, first.Val)
		first = first.Next
	}
	for second != nil {
		arr = append(arr, second.Val)
		second = second.Next
	}
	if len(arr) == 0 {
		return nil
	}
	sort.Ints(arr)
	root := &linked_list.ListNode{Val: arr[0]}
	temp := root
	for i := 1; i < len(arr); i++ {
		temp.Next = &linked_list.ListNode{Val: arr[i]}
		temp = temp.Next
	}
	return root
}

func MergeList(first, second *linked_list.ListNode) *linked_list.ListNode {
	root := &linked_list.ListNode{}

	if first != nil && second != nil {
		if first.Val < second.Val {
			root = first
			first = first.Next
		} else {
			root = second
			second = second.Next
		}
	} else if first != nil && second == nil {
		root = first
		first = first.Next
	} else if second != nil && first == nil {
		root = second
		second = second.Next
	} else if first == nil && second == nil {
		return nil
	}
	temp := root

	for first != nil && second != nil {
		if first.Val < second.Val {
			temp.Next = first
			first = first.Next
			temp = temp.Next
		} else {
			temp.Next = second
			second = second.Next
			temp = temp.Next
		}
	}
	for first != nil {
		temp.Next = first
		first = first.Next
		temp = temp.Next
	}
	for second != nil {
		temp.Next = second
		second = second.Next
		temp = temp.Next
	}
	return root
}

func MergeRecursive(first, second *linked_list.ListNode) *linked_list.ListNode {
	root := &linked_list.ListNode{}

	if first != nil && second != nil {
		if first.Val < second.Val {
			root = first
			first = first.Next
		} else {
			root = second
			second = second.Next
		}
	} else if first != nil && second == nil {
		root = first
		first = first.Next
	} else if second != nil && first == nil {
		root = second
		second = second.Next
	} else if first == nil && second == nil {
		return nil
	}
	temp := root

	recursiveList(temp, first, second)
	return root
}

func recursiveList(root, first, second *linked_list.ListNode) {
	if first == nil && second == nil {
		return
	}
	if first != nil && second != nil {
		if first.Val < second.Val {
			root.Next = first
			first = first.Next
			root = root.Next
		} else {
			root.Next = second
			second = second.Next
			root = root.Next
		}
	} else if first != nil {
		root.Next = first
		first = first.Next
		root = root.Next
	} else if second != nil {
		root.Next = second
		second = second.Next
		root = root.Next
	}
	recursiveList(root, first, second)
}
