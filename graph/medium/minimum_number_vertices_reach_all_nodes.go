package medium

func FindSmallestSetOfVertices(n int, edges [][]int) []int {
	inDeg := make([]bool, n)

	// just counting the nodes which are reachable from somewhere
	// []bool will also do here , no need to maintain count
	for _, v := range edges {
		inDeg[v[1]] = true
	}
	res := make([]int, 0)

	// the nodes which are not reachable from anywhere have to be in the set of our starting
	// nodes since we have to travel all nodes
	for i, isReachable := range inDeg {
		if !isReachable {
			res = append(res, i)
		}
	}
	return res
}
