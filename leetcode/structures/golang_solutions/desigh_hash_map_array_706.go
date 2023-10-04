package golang_solutions

type ArrayHashMap struct {
	buckets []int
	visited []bool
}

func ConstructorArrayMap() ArrayHashMap {
	return ArrayHashMap{buckets: make([]int, 100000), visited: make([]bool, 100000)}
}

func (this *ArrayHashMap) Put(key int, value int) {
	idx := key % 100000
	this.buckets[idx] = value
	this.visited[idx] = true
}

func (this *ArrayHashMap) Get(key int) int {
	idx := key % 100000
	if !this.visited[idx] {
		return -1
	}
	return this.buckets[idx]
}

func (this *ArrayHashMap) Remove(key int) {
	idx := key % 100000
	this.visited[idx] = false
}
