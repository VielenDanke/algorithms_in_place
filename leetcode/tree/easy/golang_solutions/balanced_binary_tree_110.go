package golang_solutions

import (
	"github.com/vielendanke/algorithms_in_place/leetcode/tree"
	"math"
)

type pair struct {
	height     int
	isBalanced bool
}

func isBalanced(root *tree.TreeNode) bool {
	if root == nil {
		return true
	}
	return checkIfTreeIsBalanced(root).isBalanced
}

func checkIfTreeIsBalanced(root *tree.TreeNode) *pair {
	if root == nil {
		return &pair{1, true}
	}
	left := checkIfTreeIsBalanced(root.Left)
	right := checkIfTreeIsBalanced(root.Right)

	if math.Abs(float64(left.height-right.height)) > 1 || !left.isBalanced || !right.isBalanced {
		left.isBalanced = false
		return left
	}
	right.height = int(math.Max(float64(left.height), float64(right.height))) + 1
	right.isBalanced = true
	return right
}
