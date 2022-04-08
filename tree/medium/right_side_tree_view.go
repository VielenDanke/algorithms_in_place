package medium

import "github.com/vielendanke/algorithms_in_place/tree"

func rightSideViewShorter(root *tree.TreeNode) []int {
	var result []int
	helper(root, &result, 0)
	return result
}

func helper(current *tree.TreeNode, result *[]int, level int) {
	if current == nil {
		return
	}
	if level == len(*result) {
		*result = append(*result, current.Val)
	}
	(*result)[level] = current.Val
	helper(current.Left, result, level+1)
	helper(current.Right, result, level+1)
}

func rightSideView(root *tree.TreeNode) []int {
	levelMap := make(map[int][]int)

	queue := make([]*tree.Node, 0)

	queue = append(queue, &tree.Node{InnerNode: root, Depth: 1})

	var tempNode *tree.Node

	for len(queue) > 0 {
		tempNode, queue = queue[0], queue[1:]

		if tempNode.InnerNode == nil {
			continue
		}
		if _, ok := levelMap[tempNode.Depth]; !ok {
			levelMap[tempNode.Depth] = append(make([]int, 0), tempNode.InnerNode.Val)
		} else {
			levelMap[tempNode.Depth] = append(levelMap[tempNode.Depth], tempNode.InnerNode.Val)
		}
		queue = append(queue, &tree.Node{InnerNode: tempNode.InnerNode.Left, Depth: tempNode.Depth + 1})
		queue = append(queue, &tree.Node{InnerNode: tempNode.InnerNode.Right, Depth: tempNode.Depth + 1})
	}
	result := make([]int, 0)

	currentDepth := 1

	for {
		levelArr, ok := levelMap[currentDepth]

		if !ok {
			break
		}
		result = append(result, levelArr[len(levelArr)-1])
		currentDepth++
	}
	return result
}
