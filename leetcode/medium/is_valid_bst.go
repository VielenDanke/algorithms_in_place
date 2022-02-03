package medium

type TreeNode struct {
	Val   int64
	Left  *TreeNode
	Right *TreeNode
}

func IsValidBst(root *TreeNode) bool {
	return searchValid(root, -1<<61, 1<<61)
}

func searchValid(node *TreeNode, min, max int64) bool {
	if node == nil {
		return true
	}
	return node.Val > min &&
		node.Val < max &&
		searchValid(node.Left, min, node.Val) &&
		searchValid(node.Right, node.Val, max)
}
