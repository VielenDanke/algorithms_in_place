package bfs_dfs

import "github.com/vielendanke/algorithms_in_place/tree"

func mergeTrees(root1 *tree.TreeNode, root2 *tree.TreeNode) *tree.TreeNode {
	// handle null nodes
	// handle sum of nodes
	// start from the root -> perform root merge -> do the same for left / right node
	if root1 == nil {
		return root2
	}
	if root2 == nil {
		return root1
	}
	root1.Val += root2.Val
	root1.Left = mergeTrees(root1.Left, root2.Left)
	root1.Right = mergeTrees(root1.Right, root2.Right)
	return root1
}

func mergeTreesIterative(root1 *tree.TreeNode, root2 *tree.TreeNode) *tree.TreeNode {
	// handle null nodes
	// handle sum of nodes
	// start from the root -> perform root merge -> do the same for left / right node
	if root1 == nil {
		return root2
	}
	stack := make([][]*tree.TreeNode, 0)

	stack = append(stack, []*tree.TreeNode{root1, root2})

	var tempRootPair []*tree.TreeNode

	for len(stack) > 0 {
		tempRootPair, stack = stack[len(stack)-1], stack[:len(stack)-1]
		if tempRootPair[0] == nil || tempRootPair[1] == nil {
			continue
		}
		tempRootPair[0].Val += tempRootPair[1].Val

		if tempRootPair[0].Left == nil {
			tempRootPair[0].Left = tempRootPair[1].Left
		} else {
			stack = append(stack, []*tree.TreeNode{tempRootPair[0].Left, tempRootPair[1].Left})
		}
		if tempRootPair[0].Right == nil {
			tempRootPair[0].Right = tempRootPair[1].Right
		} else {
			stack = append(stack, []*tree.TreeNode{tempRootPair[0].Right, tempRootPair[1].Right})
		}
	}
	return root1
}
