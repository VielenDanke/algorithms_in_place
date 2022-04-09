package hard

import (
	"github.com/vielendanke/algorithms_in_place/tree"
)

type BinaryTreeNode struct {
	PathSum     int
	Left, Right *tree.BinaryTree
}

func MaxPathSum(tree *tree.BinaryTree) int {
	_, maxSum := findPathSum(tree)
	return maxSum
}

func findMax(vals ...int) int {
	max := -1 << 63

	for _, v := range vals {
		if v > max {
			max = v
		}
	}
	return max
}

func findPathSum(tree *tree.BinaryTree) (int, int) {
	if tree == nil {
		return 0, -1 << 31
	}
	leftMaxSumBranch, leftMaxPathSum := findPathSum(tree.Left)
	rightMaxSumBranch, rightMaxPathSum := findPathSum(tree.Right)
	maxChildSumBranch := findMax(leftMaxSumBranch, rightMaxSumBranch)
	maxSumBranch := findMax(maxChildSumBranch+tree.Value, tree.Value)
	maxSumRoot := findMax(leftMaxSumBranch+tree.Value+rightMaxSumBranch, maxSumBranch)
	maxPathSum := findMax(leftMaxPathSum, rightMaxPathSum, maxSumRoot)
	return maxSumBranch, maxPathSum
}
