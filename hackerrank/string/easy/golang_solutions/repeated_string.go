package golang_solutions

// https://www.hackerrank.com/challenges/repeated-string/problem

func repeatedStringBruteForce(s string, n int64) int64 {
	// Write your code here
	m := make(map[int]interface{})
	for i, v := range []rune(s) {
		if v == 'a' {
			m[i] = nil
		}
	}
	result := int64(0)
	for i := 0; i <= int(n); i++ {
		idx := i % len(s)
		if _, ok := m[idx]; ok {
			result++
		}
	}
	return result
}

func repeatedString(s string, n int64) int64 {
	counter := int64(0)
	for _, v := range s {
		if v == 'a' {
			counter++
		}
	}
	l := int64(len(s))
	aCounter := n / l * counter
	if n%l == 0 {
		return aCounter
	}
	floor := n / l
	for i := floor * l; i < n; i++ {
		if s[int(i)%len(s)] == 'a' {
			aCounter++
		}
	}
	return aCounter
}
