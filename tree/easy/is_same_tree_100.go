package easy

import "github.com/vielendanke/algorithms_in_place/tree"

func isSameTree(p *tree.TreeNode, q *tree.TreeNode) bool {
	if p == nil && q == nil {
		return true
	}
	if p == nil || q == nil {
		return false
	}
	if p.Val != q.Val {
		return false
	}
	return isSameTree(p.Left, q.Left) && isSameTree(p.Right, q.Right)
}
