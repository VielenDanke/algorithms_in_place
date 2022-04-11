package tree

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type Node struct {
	InnerNode *TreeNode
	Depth     int
}

type BinaryTree struct {
	Value       int
	Left, Right *BinaryTree
}

type NodePointer struct {
	Val   int
	Left  *NodePointer
	Right *NodePointer
	Next  *NodePointer
}
