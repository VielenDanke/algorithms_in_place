package golang_solutions

import "github.com/vielendanke/algorithms_in_place/leetcode/tree"

func sortedArrayToBST(nums []int) *tree.TreeNode {
	if len(nums) == 0 {
		return nil
	}
	mid := len(nums) / 2
	head := &tree.TreeNode{Val: nums[mid]}
	head.Left = sortedArrayToBST(nums[:mid])
	head.Right = sortedArrayToBST(nums[mid+1:])
	return head
}
