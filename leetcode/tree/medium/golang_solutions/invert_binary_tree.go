package golang_solutions

type BinaryTree struct {
	Value int
	Left  *BinaryTree
	Right *BinaryTree
}

func (tree *BinaryTree) InvertBinaryTree() {
	queue := []*BinaryTree{tree}
	for len(queue) > 0 {
		current := queue[0]
		queue = queue[1:]
		if current == nil {
			continue
		}
		current.Left, current.Right = current.Right, current.Left
		queue = append(queue, current.Left, current.Right)
	}
}

func (tree *BinaryTree) InvertBinaryTreeRecursive() {
	if tree.Left == nil && tree.Right == nil {
		return
	}
	tree.Left, tree.Right = tree.Right, tree.Left
	if tree.Right != nil {
		tree.Right.InvertBinaryTreeRecursive()
	}
	if tree.Left != nil {
		tree.Left.InvertBinaryTreeRecursive()
	}
}
