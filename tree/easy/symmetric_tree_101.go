package easy

import "github.com/vielendanke/algorithms_in_place/tree"

type DepthNode struct {
	Node  *tree.TreeNode
	Depth int
}

func isSymmetricTreeRecursive(root *tree.TreeNode) bool {
	return checkSymmetric(root, root)
}

func checkSymmetric(left, right *tree.TreeNode) bool {
	if left == nil && right == nil {
		return true
	}
	if left != nil || right != nil {
		return false
	}
	if left.Val != right.Val {
		return false
	} else {
		return checkSymmetric(left.Left, right.Right) && checkSymmetric(left.Right, right.Left)
	}
}

func isSymmetric(root *tree.TreeNode) bool {
	depthsMap := make(map[int][]*tree.TreeNode)

	queue := make([]*DepthNode, 0)

	queue = append(queue, &DepthNode{Node: root, Depth: 1})

	var depthNode *DepthNode

	for len(queue) > 0 {
		depthNode, queue = queue[0], queue[1:]

		if _, ok := depthsMap[depthNode.Depth]; !ok {
			depthsMap[depthNode.Depth] = make([]*tree.TreeNode, 0)
		}
		if depthNode.Node == nil {
			depthsMap[depthNode.Depth] = append(depthsMap[depthNode.Depth], nil)
			continue
		}
		depthsMap[depthNode.Depth] = append(depthsMap[depthNode.Depth], depthNode.Node)

		queue = append(queue, &DepthNode{Node: depthNode.Node.Left, Depth: depthNode.Depth + 1})
		queue = append(queue, &DepthNode{Node: depthNode.Node.Right, Depth: depthNode.Depth + 1})
	}
	for _, v := range depthsMap {
		left, right := 0, len(v)-1

		for left <= right {
			leftNode := v[left]
			rightNode := v[right]
			left++
			right--
			if leftNode == nil && rightNode == nil {
				continue
			}
			if leftNode == nil && rightNode != nil {
				return false
			}
			if leftNode != nil && rightNode == nil {
				return false
			}
			if leftNode.Val != rightNode.Val {
				return false
			}
		}
	}
	return true
}
