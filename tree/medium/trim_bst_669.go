package medium

import "github.com/vielendanke/algorithms_in_place/tree"

func trimBST(root *tree.TreeNode, low int, high int) *tree.TreeNode {
	if root == nil {
		return root
	}
	if root.Val > high {
		return trimBST(root.Left, low, high)
	}
	if root.Val < low {
		return trimBST(root.Right, low, high)
	}
	root.Left = trimBST(root.Left, low, high)
	root.Right = trimBST(root.Right, low, high)
	return root
}