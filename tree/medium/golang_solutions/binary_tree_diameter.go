package golang_solutions

type TreeInfo struct {
	diameter int
	height   int
}

func BinaryTreeDiameter(tree *BinaryTree) int {
	return getTreeInfo(tree).diameter
}

func getTreeInfo(tree *BinaryTree) TreeInfo {
	if tree == nil {
		return TreeInfo{0, 0}
	}
	leftTreeInfo := getTreeInfo(tree.Left)
	rightTreeInfo := getTreeInfo(tree.Right)

	longestPath := leftTreeInfo.height + rightTreeInfo.height
	maxDiameter := max(leftTreeInfo.diameter, rightTreeInfo.diameter)
	currentDiameter := max(longestPath, maxDiameter)
	currentHeight := 1 + max(leftTreeInfo.height, rightTreeInfo.height)

	return TreeInfo{currentDiameter, currentHeight}
}

func max(f, s int) int {
	if f > s {
		return f
	}
	return s
}
