package main

import (
	"github.com/vielendanke/preparation/tree/medium"
)

var maxSum int
var maxDepth int

type BinaryTree struct {
	Value int

	Left  *BinaryTree
	Right *BinaryTree
}

type Edge struct {
	Depth int
	Sum   int
	Tree  *BinaryTree
}

func BinaryTreeDiameter(tree *BinaryTree) int {
	bottomUp(tree)
	return maxDepth
}

func bottomUp(node *BinaryTree) (int, int) {
	if node.Left == nil && node.Right == nil {
		return node.Value, 0
	}
	var sum, depth int
	if node.Left != nil {
		leftVal, leftDepth := bottomUp(node.Left)
		sum += leftVal
		depth += leftDepth
	}
	if node.Right != nil {
		rightVal, rightDepth := bottomUp(node.Right)
		sum += rightVal
		depth += rightDepth
	}
	sum += node.Value
	depth++
	if sum > maxSum {
		maxSum = sum
		maxDepth = depth
	}
	return sum, depth
}

func main() {
	medium.ReconstructBst([]int{10, 4, 2, 1, 5, 17, 19, 18})
}
