package golang_solutions

// https://www.hackerrank.com/challenges/larrys-array/problem

func larrysArray(a []int32) string {
	// Write your code here

	isSorted := false
	n := int32(len(a))

	for !isSorted {
		isSorted = true
		for i := int32(0); i+2 < n; i++ {
			if a[i] != i+1 {
				isSorted = false
				if i+2 < n {
					swap(a, i, i+1, i+2)
				}
			}
		}
	}
	for i, v := range a {
		if i+1 != int(v) {
			return "NO"
		}
	}
	return "YES"
}

// swap change position of numbers such as min number put at the most left position
func swap(a []int32, indices ...int32) {
	minIdx := indices[0]
	for _, idx := range indices {
		if a[idx] < a[minIdx] {
			minIdx = idx
		}
	}
	if minIdx == indices[1] {
		first, second := a[indices[0]], a[indices[2]]
		a[indices[0]] = a[indices[1]]
		a[indices[1]] = second
		a[indices[2]] = first
	} else if minIdx == indices[2] {
		first, second := a[indices[0]], a[indices[1]]
		a[indices[0]] = a[indices[2]]
		a[indices[1]] = first
		a[indices[2]] = second
	}
}
