package golang_solutions

func isBipartite(graph [][]int) bool {
	n := len(graph)
	colors := make([]int, n)

	for i := 0; i < n; i++ {
		if colors[i] == 0 && !isValid(graph, colors, i, 1) {
			return false
		}
	}
	return true
}

func isValid(graph [][]int, colors []int, node int, color int) bool {
	if colors[node] != 0 {
		return colors[node] == color
	}
	colors[node] = color
	for _, v := range graph[node] {
		if !isValid(graph, colors, v, -color) {
			return false
		}
	}
	return true
}
