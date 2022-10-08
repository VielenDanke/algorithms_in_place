package golang_solutions

import (
	"container/heap"
	"math"
)

type pair struct {
	key   int
	value int
}

type pairHeap []*pair

func (ph pairHeap) Len() int {
	return len(ph)
}

func (ph pairHeap) Less(i, j int) bool {
	return ph[i].key < ph[j].key
}

func (ph pairHeap) Swap(i, j int) {
	ph[i], ph[j] = ph[j], ph[i]
}

func (ph *pairHeap) Push(x interface{}) {
	*ph = append(*ph, x.(*pair))
}

func (ph *pairHeap) Pop() interface{} {
	old := *ph
	n := len(old)
	x := old[n-1]
	*ph = old[0 : n-1]
	return x
}

func (ph *pairHeap) Peek() interface{} {
	old := *ph
	n := len(old)
	x := old[n-1]
	return x
}

func minCostConnectPoints(points [][]int) int {
	n := len(points)
	var ph pairHeap
	heap.Init(&ph)
	visited := make([]bool, n)

	heap.Push(&ph, &pair{0, 0})
	commonCost := 0
	visitedEdges := 0

	for visitedEdges < n {
		top := heap.Pop(&ph).(*pair)

		weight, currentNode := top.key, top.value

		if visited[currentNode] {
			continue
		}
		visited[currentNode] = true
		commonCost += weight
		visitedEdges++

		for nextNode := 0; nextNode < n; nextNode++ {
			if !visited[nextNode] {
				nextWeight := int(math.Abs(float64(points[currentNode][0]-points[nextNode][0])) +
					math.Abs(float64(points[currentNode][1]-points[nextNode][1])))
				heap.Push(&ph, &pair{nextWeight, nextNode})
			}
		}
	}
	return commonCost
}
