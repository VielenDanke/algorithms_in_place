package bfs_dfs

import "github.com/vielendanke/algorithms_in_place/tree"

// TODO: 23.25% faster - too slow, need to think about how to speed up algorithm

func mergeTrees(root1 *tree.TreeNode, root2 *tree.TreeNode) *tree.TreeNode {
	// handle null nodes
	// handle sum of nodes
	// start from the root -> perform root merge -> do the same for left / right node
	if root1 == nil && root2 == nil {
		return nil
	} else if root1 != nil && root2 != nil {
		root2.Val += root1.Val
	} else if root1 != nil {
		root2 = &tree.TreeNode{Val: root1.Val}
	}
	var left1, right1 *tree.TreeNode

	if root1 != nil {
		left1 = root1.Left
		right1 = root1.Right
	}
	root2.Left = mergeTrees(left1, root2.Left)
	root2.Right = mergeTrees(right1, root2.Right)
	return root2
}
