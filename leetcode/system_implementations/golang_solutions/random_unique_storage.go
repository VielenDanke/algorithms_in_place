package golang_solutions

import "math/rand"

type UniqueRandomStorage struct {
	arr     []int
	storage map[int]int
	rand    *rand.Rand
}

func NewUniqueRandomStorage(rand *rand.Rand) *UniqueRandomStorage {
	return &UniqueRandomStorage{
		arr:     make([]int, 0),
		storage: make(map[int]int),
		rand:    rand,
	}
}

func (u *UniqueRandomStorage) Add(val int) bool {
	if _, ok := u.storage[val]; ok {
		return false
	}
	u.arr = append(u.arr, val)
	u.storage[val] = len(u.arr) - 1
	return true
}

func (u *UniqueRandomStorage) Remove(val int) bool {
	idx, ok := u.storage[val]
	if !ok {
		return false
	}
	u.arr[idx] = u.arr[len(u.arr)-1]
	delete(u.storage, val)
	u.storage[u.arr[idx]] = idx
	u.arr = u.arr[:len(u.arr)-1]
	return true
}

func (u *UniqueRandomStorage) GetRandom() int {
	return u.arr[u.rand.Intn(len(u.arr))]
}
