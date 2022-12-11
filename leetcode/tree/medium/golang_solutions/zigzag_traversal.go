package golang_solutions

import "github.com/vielendanke/algorithms_in_place/leetcode/tree"

func ZigzagLevelOrder(root *tree.TreeNode) [][]int {
	depthsMap := make(map[int][]int)
	result := make([][]int, 0)
	stack := make([]*tree.Node, 0)

	stack = append(stack, &tree.Node{InnerNode: root, Depth: 1})

	var tempNode *tree.Node

	for len(stack) > 0 {
		tempNode, stack = stack[len(stack)-1], stack[:len(stack)-1]

		if tempNode.InnerNode == nil {
			continue
		}
		if _, ok := depthsMap[tempNode.Depth]; !ok {
			depthsMap[tempNode.Depth] = append(make([]int, 0), tempNode.InnerNode.Val)
		} else {
			depthsMap[tempNode.Depth] = append(depthsMap[tempNode.Depth], tempNode.InnerNode.Val)
		}
		stack = append(stack, &tree.Node{InnerNode: tempNode.InnerNode.Left, Depth: tempNode.Depth + 1})
		stack = append(stack, &tree.Node{InnerNode: tempNode.InnerNode.Right, Depth: tempNode.Depth + 1})
	}
	isLeftRightTraversal := true
	currentLevel := 1

	for {
		nodes, ok := depthsMap[currentLevel]

		if !ok {
			break
		}
		if !isLeftRightTraversal {
			result = append(result, nodes)
		} else {
			left, right := 0, len(nodes)-1
			for left < right {
				nodes[left], nodes[right] = nodes[right], nodes[left]
				left++
				right--
			}
			result = append(result, nodes)
		}
		isLeftRightTraversal = !isLeftRightTraversal
		currentLevel++
	}
	return result
}
