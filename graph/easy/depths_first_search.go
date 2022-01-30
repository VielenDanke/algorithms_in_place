package easy

type Node struct {
	Name      string
	Children  []*Node
	IsVisited bool
}

func (n *Node) DepthFirstSearch(array []string) []string {
	array = append(array, n.Name)
	depthFirstSearchRec(n, &array)
	return array
}

// O(V + E) time | O(V) space
func depthFirstSearchRec(n *Node, array *[]string) {
	if n.Children == nil {
		return
	}
	for _, v := range n.Children {
		if v.IsVisited {
			continue
		} else {
			*array = append(*array, v.Name)
			v.IsVisited = true
			depthFirstSearchRec(v, array)
		}
	}
}
