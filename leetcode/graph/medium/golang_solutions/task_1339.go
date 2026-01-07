package golang_solutions

import (
	"github.com/vielendanke/algorithms_in_place/leetcode/tree"
)

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func maxProduct(root *tree.TreeNode) int {
	maxFunc := func(a, b int64) int64 {
		if a > b {
			return a
		}
		return b
	}

	var dfs func(root *tree.TreeNode, max *int64, sum *int64) int64

	dfs = func(root *tree.TreeNode, max *int64, sum *int64) int64 {
		if root == nil {
			return 0
		}

		current := dfs(root.Left, max, sum) + dfs(root.Right, max, sum) + int64(root.Val)

		*max = maxFunc(*max, (*sum-current)*current)

		return current
	}

	var sum, max int64

	sum = dfs(root, &max, &sum)
	dfs(root, &max, &sum)

	return int(max % (1_000_000_007))
}
