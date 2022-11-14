package golang_solutions

func removeStones(stones [][]int) int {
	n := len(stones)
	visited := make([]bool, n, n)
	numOfIslands := 0

	for i := range stones {
		if !visited[i] {
			dfs(i, stones, visited)
			numOfIslands++
		}
	}
	return n - numOfIslands
}

func dfs(prevIdx int, stones [][]int, visited []bool) {
	visited[prevIdx] = true

	for i, v := range stones {
		if !visited[i] && (v[0] == stones[prevIdx][0] || v[1] == stones[prevIdx][1]) {
			dfs(i, stones, visited)
		}
	}
}

// ----------------------
// Union Find

var id []int
var n int
var components int

func removeStonesUnionFind(stones [][]int) int {
	n = len(stones)
	id = make([]int, n, n)
	components = n

	for i := 0; i < n; i++ {
		id[i] = i
	}

	for i, v1 := range stones {
		for j, v2 := range stones {
			if (v1[0] == v2[0] || v1[1] == v2[1]) && !isConnected(i, j) {
				components--
				union(i, j)
			}
		}
	}
	return n - components
}

func isConnected(i, j int) bool {
	return find(i) == find(j)
}

func union(i, j int) {
	id[find(i)] = find(j)
}

func find(i int) int {
	for i != id[i] {
		id[i] = id[id[i]]
		i = id[i]
	}
	return i
}
