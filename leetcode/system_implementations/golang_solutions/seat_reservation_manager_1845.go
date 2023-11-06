package golang_solutions

import "container/heap"

type minHeap []int

func (h minHeap) Len() int {
	return len(h)
}

func (h minHeap) Less(i, j int) bool {
	return h[i] < h[j]
}

func (h minHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *minHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *minHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

type SeatManager struct {
	minHeap *minHeap
}

func ConstructorSeatManager(n int) SeatManager {
	minHeap := &minHeap{}
	for i := 1; i <= n; i++ {
		heap.Push(minHeap, i)
	}
	heap.Init(minHeap)
	return SeatManager{minHeap: minHeap}
}

func (this *SeatManager) Reserve() int {
	return heap.Pop(this.minHeap).(int)
}

func (this *SeatManager) Unreserve(seatNumber int) {
	heap.Push(this.minHeap, seatNumber)
}

// ---------------------------------------------------------------------------------------------------

type SeatManagerBruteForce struct {
	seats []int
}

func ConstructorSeatManagerBruteForce(n int) SeatManagerBruteForce {
	return SeatManagerBruteForce{seats: make([]int, 100001)}
}

func (this *SeatManagerBruteForce) Reserve() int {
	for i := 1; i < len(this.seats); i++ {
		if this.seats[i] == 0 {
			this.seats[i] = 1
			return i
		}
	}
	return -1
}

func (this *SeatManagerBruteForce) Unreserve(seatNumber int) {
	this.seats[seatNumber] = 0
}
