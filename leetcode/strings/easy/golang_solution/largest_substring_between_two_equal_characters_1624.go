package golang_solution

import "math"

// array

func maxLengthBetweenEqualCharacters(s string) int {
	matrix := make([][]int, 26)
	for i, r := range s {
		matrix[r-'a'] = append(matrix[r-'a'], i)
	}
	diff := -1
	for _, indexes := range matrix {
		n := len(indexes)
		if n > 1 && diff < indexes[n-1]-indexes[0]-1 {
			diff = indexes[n-1] - indexes[0] - 1
		}
	}
	return diff
}

// map

func maxLengthBetweenEqualCharactersMap(s string) int {
	// group characters by positions
	// find the longest distance between 2 characters
	m := make(map[rune][]int)
	for i, r := range s {
		m[r] = append(m[r], i)
	}
	diff := -1
	for _, v := range m {
		if len(v) > 1 {
			diff = int(math.Max(float64(diff), float64(v[len(v)-1]-v[0]-1)))
		}
	}
	return diff
}
