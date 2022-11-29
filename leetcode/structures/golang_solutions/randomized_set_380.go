package golang_solutions

import "math/rand"

type RandomizedSet struct {
	arr     []int
	storage map[int]int
}

func NewRandomizedSet() RandomizedSet {
	return RandomizedSet{
		arr:     make([]int, 0),
		storage: make(map[int]int),
	}
}

func (r *RandomizedSet) Insert(val int) bool {
	if _, ok := r.storage[val]; ok {
		return false
	}
	r.arr = append(r.arr, val)
	r.storage[val] = len(r.arr) - 1
	return true
}

func (r *RandomizedSet) Remove(val int) bool {
	if _, ok := r.storage[val]; !ok {
		return false
	}
	idx := r.storage[val]
	if idx == len(r.arr)-1 {
		r.arr = r.arr[:len(r.arr)-1]
	} else {
		idx := r.storage[val]
		r.arr[idx] = r.arr[len(r.arr)-1]
		r.arr = r.arr[:len(r.arr)-1]
		r.storage[r.arr[idx]] = idx
	}
	delete(r.storage, val)
	return true
}

func (r *RandomizedSet) GetRandom() int {
	return r.arr[rand.Intn(len(r.arr))]
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Insert(val);
 * param_2 := obj.Remove(val);
 * param_3 := obj.GetRandom();
 */

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Insert(val);
 * param_2 := obj.Remove(val);
 * param_3 := obj.GetRandom();
 */
