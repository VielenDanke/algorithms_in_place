package tree

func InOrderTraversal(root *TreeNode, array *[]int) {
	if root == nil {
		return
	}
	InOrderTraversal(root.Left, array)
	*array = append(*array, root.Val)
	InOrderTraversal(root.Right, array)
}
