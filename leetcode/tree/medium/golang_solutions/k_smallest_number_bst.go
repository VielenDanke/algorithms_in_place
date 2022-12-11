package golang_solutions

import "github.com/vielendanke/algorithms_in_place/leetcode/tree"

func kthSmallest(root *tree.TreeNode, k int) int {
	array := make([]int, 0)

	tree.InOrderTraversal(root, &array)

	return array[k-1]
}
