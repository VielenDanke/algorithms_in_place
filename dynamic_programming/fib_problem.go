package dynamic_programming

func fib(n int) int {
	f, s := 0, 1
	for i := 0; i < n; i++ {
		f, s = s, f+s
	}
	return f
}

func fibRecursive(n int) int {
	if n <= 2 {
		return 1
	}
	return fibRecursive(n-1) + fibRecursive(n-2)
}

// memoization
// map, keys - args, value - return value
func fibMemoization(n int, memo map[int]int) int {
	val, ok := memo[n]
	if ok {
		return val
	} else if n <= 2 {
		return 1
	} else {
		memo[n] = fibMemoization(n-1, memo) + fibMemoization(n-2, memo)
		return memo[n]
	}
}

// building table
func fibTabulation(n int) int {
	var tab []int
	for i := 0; i < n+1; i++ {
		tab = append(tab, 0)
	}
	tab[1] = 1
	for i := 0; i < len(tab); i++ {
		tab[i+1] += tab[i]
		tab[i+2] += tab[i]
	}
	return tab[n]
}
