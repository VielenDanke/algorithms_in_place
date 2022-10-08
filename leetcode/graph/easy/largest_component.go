package easy

func LargestComponent(graph map[string][]string) (largest int) {
	for node := range graph {
		nodesSize := exploreSize(graph, make(map[string]interface{}), node)
		if nodesSize > largest {
			largest = nodesSize
		}
	}
	return
}

func exploreSize(graph map[string][]string, visited map[string]interface{}, node string) (size int) {
	if _, ok := visited[node]; ok {
		return
	}
	visited[node] = nil
	size = 1
	for _, neighbor := range graph[node] {
		size += exploreSize(graph, visited, neighbor)
	}
	return
}
