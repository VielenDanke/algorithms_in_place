package medium

import "github.com/vielendanke/preparation/tree"

var globalIdx = 0
var inorderIdxMap = make(map[int]int)

func buildTree(preorder []int, inorder []int) *tree.TreeNode {
	globalIdx = 0
	for i := 0; i < len(inorder); i++ {
		inorderIdxMap[inorder[i]] = i
	}
	return arrayToTree(preorder, 0, len(preorder)-1)
}

func arrayToTree(preorder []int, left, right int) *tree.TreeNode {
	if left > right {
		return nil
	}
	rootVal := preorder[globalIdx]
	globalIdx++
	root := &tree.TreeNode{Val: rootVal}
	root.Left = arrayToTree(preorder, left, inorderIdxMap[rootVal]-1)
	root.Right = arrayToTree(preorder, inorderIdxMap[rootVal]+1, right)
	return root
}
