package medium

import "github.com/vielendanke/algorithms_in_place/tree"

func kthSmallest(root *tree.TreeNode, k int) int {
	array := make([]int, 0)

	tree.DFS(root, &array)

	return array[k-1]
}
