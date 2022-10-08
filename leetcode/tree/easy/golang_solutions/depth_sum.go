package golang_solutions

type Tree struct {
	Value       int
	Left, Right *Tree
}

type Level struct {
	Node   *Tree
	Depths int
}

func NodeDepthsRecursion(root *Tree) int {
	depthsSum := 0
	return calculateDepthsSum(root, depthsSum)
}

func calculateDepthsSum(node *Tree, sum int) int {
	if node == nil {
		return 0
	}
	return sum + calculateDepthsSum(node.Left, sum+1) + calculateDepthsSum(node.Right, sum+1)
}

func NodeDepths(root *Tree) int {
	// Write your code here.
	// breadth for search nodes
	stack := make([]Level, 0)
	stack = append(stack, Level{Node: root, Depths: 0})
	var depthsSum int
	var lvl Level
	for len(stack) > 0 {
		lvl, stack = stack[len(stack)-1], stack[:len(stack)-1]
		node, depth := lvl.Node, lvl.Depths
		if node == nil {
			continue
		}
		depthsSum += depth
		stack = append(stack, Level{Node: node.Left, Depths: depth + 1})
		stack = append(stack, Level{Node: node.Right, Depths: depth + 1})
	}
	return depthsSum
}
