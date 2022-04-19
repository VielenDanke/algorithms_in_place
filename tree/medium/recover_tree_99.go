package medium

import (
	"github.com/vielendanke/algorithms_in_place/tree"
)

var prev *tree.TreeNode = nil
var first *tree.TreeNode = nil
var second *tree.TreeNode = nil

func recoverTree(root *tree.TreeNode) {
	prev, first, second = nil, nil, nil
	traverse(root)
	first.Val, second.Val = second.Val, first.Val
}

func traverse(root *tree.TreeNode) {
	if root == nil {
		return
	}
	traverse(root.Left)
	if first == nil && (prev == nil || prev.Val >= root.Val) {
		first = prev
	}
	if first != nil && prev.Val >= root.Val {
		second = root
	}
	prev = root
	traverse(root.Right)
}
