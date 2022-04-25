package golang_solutions

func mySqrt(x int) int {
	if x == 0 {
		return 0
	}
	if x == 1 {
		return 1
	}
	prev := 1
	for i := 2; i <= x; i++ {
		current := i * i
		if current < x {
			prev = i
		} else if current == x {
			return i
		} else {
			return prev
		}
	}
	return prev
}

func mySqrtBinarySearch(x int) int {
	if x == 0 {
		return 0
	}
	left, right := 1, 1<<31

	for {
		mid := left + (right-left)/2
		if mid > x/mid {
			right = mid - 1
		} else {
			if mid+1 > x/(mid+1) {
				return mid
			}
			left = mid + 1
		}
	}
}
