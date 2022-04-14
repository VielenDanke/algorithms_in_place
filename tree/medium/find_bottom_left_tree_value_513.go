package medium

import "github.com/vielendanke/algorithms_in_place/tree"

func findBottomLeftValue(root *tree.TreeNode) int {
	queue := make([]*tree.TreeNode, 0)

	queue = append(queue, root)

	var mostLeft *tree.TreeNode

	for len(queue) > 0 {
		length := len(queue)

		mostLeft = queue[0]

		if mostLeft.Left != nil {
			queue = append(queue, mostLeft.Left)
		}
		if mostLeft.Right != nil {
			queue = append(queue, mostLeft.Right)
		}
		for i := 1; i < length; i++ {
			node := queue[i]
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		queue = queue[length:]
	}
	return mostLeft.Val
}
