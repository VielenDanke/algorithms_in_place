package medium

type BST struct {
	Value int

	Left  *BST
	Right *BST
}

func (tree *BST) ValidateBst() bool {
	return tree.isBSTValid(-1<<31, 1<<31)
}

func (tree *BST) isBSTValid(min, max int) bool {
	if tree.Value < min || tree.Value >= max {
		return false
	}
	if tree.Left != nil && !tree.Left.isBSTValid(min, tree.Value) {
		return false
	}
	if tree.Right != nil && !tree.Right.isBSTValid(tree.Value, max) {
		return false
	}
	return true
}
