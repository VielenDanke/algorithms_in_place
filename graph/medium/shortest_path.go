package medium

type node struct {
	key    string
	depths int
}

func FindShortestPath(edges [][]string, src, dst string) (shortestPath int) {
	graph := buildGraph(edges)
	visited := make(map[string]interface{})

	queue := make([]*node, 0)

	queue = append(queue, &node{key: src, depths: 0})
	visited[src] = nil

	var current *node

	for len(queue) > 0 {
		current, queue = queue[0], queue[1:]

		if current.key == dst {
			return current.depths
		}
		for _, neighbor := range graph[current.key] {
			if _, ok := visited[current.key]; !ok {
				visited[current.key] = nil
				queue = append(queue, &node{key: neighbor, depths: current.depths + 1})
			}
		}
	}
	return -1
}

func buildGraph(edges [][]string) map[string][]string {
	graph := make(map[string][]string)
	for _, v := range edges {
		if _, ok := graph[v[0]]; !ok {
			graph[v[0]] = make([]string, 0)
		}
		if _, ok := graph[v[1]]; !ok {
			graph[v[1]] = make([]string, 0)
		}
		graph[v[0]] = append(graph[v[0]], v[1])
		graph[v[1]] = append(graph[v[1]], v[0])
	}
	return graph
}
