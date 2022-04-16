package medium

import (
	"github.com/vielendanke/algorithms_in_place/tree"
)

func convertBST(root *tree.TreeNode) *tree.TreeNode {
	vals := make([]int, 0)
	sum := inOrderTraversal(root, &vals)

	oldMap := make(map[int]int)

	for i := 0; i < len(vals); i++ {
		oldMap[vals[i]] = sum
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
		temp.Val = oldMap[temp.Val]
		stack = append(stack, temp.Left)
		stack = append(stack, temp.Right)
	}
	return root
}

func inOrderTraversal(root *tree.TreeNode, vals *[]int) int {
	if root == nil {
		return 0
	}
	left := inOrderTraversal(root.Left, vals)
	*vals = append(*vals, root.Val)
	right := inOrderTraversal(root.Right, vals)
	return root.Val + left + right
}
