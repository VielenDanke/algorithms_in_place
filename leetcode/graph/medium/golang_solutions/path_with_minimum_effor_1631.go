package golang_solutions

import (
	"container/heap"
	"math"
)

type Item struct {
	row    int // row of the item
	col    int // col of the item
	weight int // current weight
}

type PriorityQueue []*Item

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool {
	return pq[i].weight < pq[j].weight
}

func (pq PriorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
}

func (pq *PriorityQueue) Push(x any) {
	item := x.(*Item)
	*pq = append(*pq, item)
}

func (pq *PriorityQueue) Pop() any {
	old := *pq
	n := len(old)
	item := old[n-1]
	old[n-1] = nil // avoid memory leak
	*pq = old[0 : n-1]
	return item
}

func minimumEffortPath(heights [][]int) int {
	n, m := len(heights), len(heights[0])

	weightPath := make([][]int, n)

	for i := range weightPath {
		weightPath[i] = make([]int, m)
		for j := range weightPath[i] {
			weightPath[i][j] = math.MaxInt
		}
	}

	pq := make(PriorityQueue, 0)

	heap.Push(&pq, &Item{0, 0, 0})

	directions := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}

	for len(pq) > 0 {
		item := heap.Pop(&pq).(*Item)

		row, col := item.row, item.col

		if row == n-1 && col == m-1 {
			break
		}
		for _, dir := range directions {
			nextRow := dir[0] + row
			nextCol := dir[1] + col

			if nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m {
				continue
			}
			alt := int(math.Max(float64(item.weight), math.Abs(float64(heights[row][col]-heights[nextRow][nextCol]))))
			if alt < weightPath[nextRow][nextCol] {
				weightPath[nextRow][nextCol] = alt
				heap.Push(&pq, &Item{nextRow, nextCol, alt})
			}
		}
	}
	return weightPath[n-1][m-1]
}
