package main

type BinaryTree struct {
	Value int

	Left  *BinaryTree
	Right *BinaryTree
}

type Edge struct {
	Depth int
	Sum   int
}

func BinaryTreeDiameter(tree *BinaryTree) int {
	return bottomUp(tree).Depth
}

func bottomUp(node *BinaryTree) *Edge {
	if node.Left == nil && node.Right == nil {
		return &Edge{Depth: 1, Sum: node.Value}
	}
	maxEdge := &Edge{}
	leftEdge, rightEdge := &Edge{}, &Edge{}
	if node.Left != nil {
		leftEdge = bottomUp(node.Left)
	}
	if node.Right != nil {
		rightEdge = bottomUp(node.Right)
	}
	if leftEdge.Sum > rightEdge.Sum {
		maxEdge.Sum += leftEdge.Sum
	} else {
		maxEdge.Sum += rightEdge.Sum
	}
	maxEdge.Depth += 1
	return maxEdge
}

func main() {
	BinaryTreeDiameter(&BinaryTree{
		Value: 1, Left: &BinaryTree{
			Value: 3, Left: &BinaryTree{
				Value: 7, Left: &BinaryTree{
					Value: 8, Left: &BinaryTree{Value: 9},
				},
			},
			Right: &BinaryTree{Value: 4, Right: &BinaryTree{Value: 5, Right: &BinaryTree{Value: 6}}},
		},
		Right: &BinaryTree{Value: 2},
	},
	)
}
