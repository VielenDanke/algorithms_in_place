package golang_solutions

import (
	"container/heap"
	"sort"
)

type KthLargest struct {
	k    int
	nums []int
}

func Constructor(k int, nums []int) KthLargest {
	sort.Ints(nums)
	return KthLargest{k: k, nums: nums}
}

func (this *KthLargest) Add(val int) int {
	this.nums = append(this.nums, val)
	for i := len(this.nums) - 1; i > 0; i-- {
		if this.nums[i-1] > this.nums[i] {
			this.nums[i-1], this.nums[i] = this.nums[i], this.nums[i-1]
		}
	}
	return this.nums[len(this.nums)-this.k]
}

// ----------------------------------------------------

// MinHeap

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

func (h *minHeap) Push(val interface{}) {
	*h = append(*h, val.(int))
}

func (h *minHeap) Pop() interface{} {
	l := (*h)[len(*h)-1]
	*h = (*h)[:len(*h)-1]
	return l
}

type KthLargestMinHeap struct {
	capacity int
	h        minHeap
}

func ConstructorMinHeap(k int, nums []int) KthLargestMinHeap {
	ret := KthLargestMinHeap{
		capacity: k,
		h:        minHeap{},
	}
	for _, num := range nums {
		(&ret).AddMinHeap(num)
	}
	return ret
}

func (this *KthLargestMinHeap) AddMinHeap(val int) int {
	if this.h.Len() < this.capacity {
		heap.Push(&this.h, val)
		return this.h[0]
	}
	if val <= this.h[0] {
		return this.h[0]
	}
	heap.Pop(&this.h)
	heap.Push(&this.h, val)
	return this.h[0]
}
