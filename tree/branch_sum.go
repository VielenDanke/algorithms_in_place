package tree

type BinaryTree struct {
	Value int
	Left  *BinaryTree
	Right *BinaryTree
}

func BranchSums(root *BinaryTree) []int {
	// Write your code here.
	// walking till the end - end value + right
	// add node to stack - when rich the end pop from stack and move right
	sums := make([]int, 0)
	calculateSum(root, 0, &sums)
	return sums
}

type unvisited struct {
	node       *BinaryTree
	runningSum int
}

func BranchSums2(root *BinaryTree) []int {
	sums := make([]int, 0)
	stack := []unvisited{{root, 0}}

	for len(stack) > 0 {
		lastIdx := len(stack) - 1
		node, runningSum := stack[lastIdx].node, stack[lastIdx].runningSum
		stack = stack[:lastIdx]

		runningSum += node.Value

		if node.Left == nil && node.Right == nil {
			sums = append(sums, runningSum)
			continue
		}
		if node.Right != nil {
			stack = append(stack, unvisited{node.Right, runningSum})
		}
		if node.Left != nil {
			stack = append(stack, unvisited{node.Left, runningSum})
		}
	}
	return sums
}

func calculateSum(root *BinaryTree, sum int, sums *[]int) {
	if root == nil {
		return
	}
	sum += root.Value
	if root.Left == nil && root.Right == nil {
		*sums = append(*sums, sum)
		return
	}
	calculateSum(root.Left, sum, sums)
	calculateSum(root.Right, sum, sums)
}
