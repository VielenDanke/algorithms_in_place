package easy

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func InorderTraversal(root *TreeNode) []int {
	arr := make([]int, 0)

	recursive(root, &arr)

	return arr
}

func recursive(root *TreeNode, arr *[]int) {
	if root == nil {
		return
	}
	recursive(root.Left, arr)
	*arr = append(*arr, root.Val)
	recursive(root.Right, arr)
}
