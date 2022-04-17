package easy

import "github.com/vielendanke/algorithms_in_place/tree"

func increasingBST(root *tree.TreeNode) *tree.TreeNode {
	nodes := make([]*tree.TreeNode, 0)

	inOrderTraversal(root, &nodes)

	for i := 0; i < len(nodes)-1; i++ {
		nodes[i].Left = nil
		nodes[i].Right = nodes[i+1]
	}
	nodes[len(nodes)-1].Left = nil
	nodes[len(nodes)-1].Right = nil
	return nodes[0]
}

func inOrderTraversal(root *tree.TreeNode, nodes *[]*tree.TreeNode) {
	if root == nil {
		return
	}
	inOrderTraversal(root.Left, nodes)
	*nodes = append(*nodes, root)
	inOrderTraversal(root.Right, nodes)
}
