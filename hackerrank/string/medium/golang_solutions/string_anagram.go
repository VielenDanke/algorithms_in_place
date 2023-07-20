package golang_solutions

import "strconv"

func stringAnagram(dictionary []string, query []string) []int {
	trDict := countWords(dictionary)
	trQuery := countQueries(query)

	var result []int

	for _, q := range trQuery {
		if val, ok := trDict[q]; ok {
			result = append(result, val)
		}
	}
	return result
}

func countQueries(queries []string) []string {
	for i, q := range queries {
		queries[i] = transform(q)
	}
	return queries
}

func countWords(dictionary []string) map[string]int {
	m := make(map[string]int)
	for _, d := range dictionary {
		t := transform(d)
		m[t]++
	}
	return m
}

func transform(s string) string {
	alph := make([]int, 26)
	for _, c := range s {
		alph[c-'a']++
	}
	var builder string

	for i := 0; i < 26; i++ {
		if alph[i] != 0 {
			builder += strconv.Itoa(alph[i]) + string(rune(i+'a'))
		}
	}
	return builder
}
