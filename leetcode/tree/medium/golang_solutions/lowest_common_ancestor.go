package golang_solutions

import "github.com/vielendanke/algorithms_in_place/leetcode/tree"

func lowestCommonAncestor(root, p, q *tree.TreeNode) *tree.TreeNode {
	if root == nil {
		return nil
	}
	if p.Val == root.Val {
		return p
	}
	if q.Val == root.Val {
		return q
	}
	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)
	if left != nil && right != nil {
		return root
	}
	if left != nil {
		return left
	}
	return right
}
