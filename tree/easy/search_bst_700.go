package easy

import "github.com/vielendanke/algorithms_in_place/tree"

func searchBST(root *tree.TreeNode, val int) *tree.TreeNode {
	if root == nil {
		return nil
	} else if root.Val == val {
		return root
	} else {
		if root.Val > val {
			return searchBST(root.Left, val)
		} else {
			return searchBST(root.Right, val)
		}
	}
}
