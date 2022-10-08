package golang_solutions

type node struct {
	row      int
	idx      int
	children []*node
}

func RemoveIslands(matrix [][]int) [][]int {
	nodes := constructNodes(matrix)

	for _, n := range nodes {
		if !isValidDFS(n, matrix) {
			matrix[n.row][n.idx] = 0
		}
	}
	return matrix
}

func isValidDFS(n *node, m [][]int) bool {
	if n.children == nil {
		if m[n.row][n.idx] == 1 {
			return false
		}
		return true
	}
	for _, v := range n.children {
		if !isValidDFS(v, m) {
			return false
		}
	}
	return true
}

func constructNodes(matrix [][]int) []*node {
	nodes := make([]*node, 0)
	for i := range matrix {
		if i == 0 && i == len(matrix)-1 {
			continue
		}
		for j := range matrix[i] {
			if j == 0 || j == len(matrix[i])-1 {
				continue
			}
			// i - 1
			// i + 1
			// j - 1
			// j + 1
			// currentIdx = row + idx
			n := &node{row: i, idx: j}
			n.children = append(n.children, &node{row: i - 1, idx: j})
			n.children = append(n.children, &node{row: i + 1, idx: j})
			n.children = append(n.children, &node{row: i, idx: j - 1})
			n.children = append(n.children, &node{row: i, idx: j + 1})
			nodes = append(nodes, n)
		}
	}
	return nodes
}
