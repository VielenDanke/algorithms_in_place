package golang_solutions

// https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
// https://www.hackerrank.com/challenges/bigger-is-greater/problem

/*
1. find index with condition when letters[i - 1] < letters[i]
2. find the most right index when letters[i - 1] < letters[j]
3. swap two indices
4. reverse suffix from i to n - 1
*/

func biggerIsGreater(w string) string {
	letters := []rune(w)
	n := len(letters)
	i, j := n-1, n-1

	for i > 0 && letters[i-1] >= letters[i] {
		i--
	}
	if i <= 0 {
		return "no answer"
	}
	for letters[j] <= letters[i-1] {
		j--
	}
	letters[i-1], letters[j] = letters[j], letters[i-1]

	j = n - 1

	for i < j {
		letters[i], letters[j] = letters[j], letters[i]
		i++
		j--
	}
	return string(letters)
}
