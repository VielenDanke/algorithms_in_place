package golang_solutions

func HeightBalancedBinaryTree(tree *BinaryTree) bool {
	isBalanced, _ := checkIfBalanced(tree)
	return isBalanced
}

func checkIfBalanced(tree *BinaryTree) (bool, int) {
	if tree == nil {
		return true, -1
	}
	isFirstBalanced, firstDepth := checkIfBalanced(tree.Left)
	isSecondBalanced, secondDepth := checkIfBalanced(tree.Right)

	height := max(firstDepth, secondDepth)

	return isFirstBalanced && isSecondBalanced && abs(firstDepth, secondDepth) <= 1, height
}

func abs(f, s int) int {
	if f > s {
		return f - s
	}
	return s - f
}
