package golang_solutions

import (
	"github.com/vielendanke/algorithms_in_place/leetcode/tree"
)

func convertBST(root *tree.TreeNode) *tree.TreeNode {
	vals := make([]int, 0)
	sum := inOrderTraversalWithSum(root, &vals)

	greaterMap := make(map[int]int)

	for i := 0; i < len(vals); i++ {
		greaterMap[vals[i]] = sum
		sum -= vals[i]
	}
	stack := make([]*tree.TreeNode, 0)

	stack = append(stack, root)

	var temp *tree.TreeNode

	for len(stack) > 0 {
		temp, stack = stack[len(stack)-1], stack[:len(stack)-1]

		if temp == nil {
			continue
		}
		temp.Val = greaterMap[temp.Val]
		stack = append(stack, temp.Left)
		stack = append(stack, temp.Right)
	}
	return root
}

func inOrderTraversalWithSum(root *tree.TreeNode, vals *[]int) int {
	if root == nil {
		return 0
	}
	left := inOrderTraversalWithSum(root.Left, vals)
	*vals = append(*vals, root.Val)
	right := inOrderTraversalWithSum(root.Right, vals)
	return root.Val + left + right
}
