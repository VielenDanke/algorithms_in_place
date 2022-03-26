package tree

func DFS(root *TreeNode, array *[]int) {
	if root == nil {
		return
	}
	DFS(root.Left, array)
	*array = append(*array, root.Val)
	DFS(root.Right, array)
}
