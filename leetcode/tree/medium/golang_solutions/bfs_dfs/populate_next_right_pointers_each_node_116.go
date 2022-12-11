package bfs_dfs

import "github.com/vielendanke/algorithms_in_place/leetcode/tree"

type NodePointerDepth struct {
	Node  *tree.NodePointer
	Depth int
}

func connectRecursive(root *tree.NodePointer) *tree.NodePointer {
	if root == nil {
		return root
	}
	left, right := root.Left, root.Right

	connect(left)
	connect(right)

	for left != nil {
		left.Next = right
		left = left.Right
		right = right.Left
	}
	return root
}

func connectRecursiveNodePointer(root *tree.NodePointer) *tree.NodePointer {
	start := root
	for start != nil {
		current := start
		for current != nil {
			if current.Left != nil {
				current.Left.Next = current.Right
			}
			if current.Right != nil && current.Next != nil {
				current.Right.Next = current.Next.Left
			}
			current = current.Next
		}
		start = start.Next
	}
	return root
}

func connect(root *tree.NodePointer) *tree.NodePointer {
	if root == nil {
		return root
	}
	queue := make([]*NodePointerDepth, 0)

	queue = append(queue, &NodePointerDepth{Node: root, Depth: 1})

	storage := make(map[int][]*tree.NodePointer)

	var tempNodePointerDepth *NodePointerDepth

	for len(queue) > 0 {
		tempNodePointerDepth, queue = queue[0], queue[1:]

		if tempNodePointerDepth.Node == nil {
			continue
		}

		if _, ok := storage[tempNodePointerDepth.Depth]; !ok {
			storage[tempNodePointerDepth.Depth] = make([]*tree.NodePointer, 0)
		}
		storage[tempNodePointerDepth.Depth] = append(storage[tempNodePointerDepth.Depth], tempNodePointerDepth.Node)

		queue = append(queue, &NodePointerDepth{Node: tempNodePointerDepth.Node.Left, Depth: tempNodePointerDepth.Depth + 1})
		queue = append(queue, &NodePointerDepth{Node: tempNodePointerDepth.Node.Right, Depth: tempNodePointerDepth.Depth + 1})
	}
	for _, levelNodes := range storage {
		if len(levelNodes) > 0 {
			prev := levelNodes[0]
			for i := 1; i < len(levelNodes); i++ {
				prev.Next = levelNodes[i]
				prev = levelNodes[i]
			}
		}
	}
	return root
}
