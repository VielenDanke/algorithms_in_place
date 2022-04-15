package medium

import "github.com/vielendanke/algorithms_in_place/tree"

func deleteNode(root *tree.TreeNode, key int) *tree.TreeNode {
	if root == nil {
		return root
	}
	if root.Val > key {
		root.Left = deleteNode(root.Left, key)
	} else if root.Val < key {
		root.Right = deleteNode(root.Right, key)
	} else {
		if root.Right != nil {
			temp := root.Right

			for temp.Left != nil {
				temp = temp.Left
			}
			temp.Left = root.Left

			return root.Right
		}
		return root.Left
	}
	return root
}

func deleteNodeVal(root *tree.TreeNode, key int) *tree.TreeNode {
	if root == nil {
		return root
	}
	if root.Val > key {
		root.Left = deleteNode(root.Left, key)
	} else if root.Val < key {
		root.Right = deleteNode(root.Right, key)
	} else {
		if root.Left != nil && root.Right != nil {
			rMin := minRightNode(root.Right)
			root.Val = rMin
			root.Right = deleteNodeVal(root.Right, rMin)
			return root
		} else if root.Left != nil {
			return root.Left
		} else {
			return root.Right
		}
	}
	return root
}

func minRightNode(root *tree.TreeNode) int {
	if root.Left != nil {
		return minRightNode(root.Left)
	}
	return root.Val
}
