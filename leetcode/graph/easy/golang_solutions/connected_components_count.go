package golang_solutions

func ConnectedComponentsCount(graph map[string][]string) (counter int) {
	visited := make(map[string]interface{})
	for k := range graph {
		if explore(graph, visited, k) {
			counter++
		}
	}
	return
}

func explore(graph map[string][]string, visited map[string]interface{}, current string) bool {
	if _, ok := visited[current]; ok {
		return false
	}
	visited[current] = nil
	for _, neighbor := range graph[current] {
		explore(graph, visited, neighbor)
	}
	return true
}
