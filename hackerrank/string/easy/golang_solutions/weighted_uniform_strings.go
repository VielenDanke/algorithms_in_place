package golang_solutions

func weightedUniformStrings(s string, queries []int32) []string {
	// Write your code here
	// uniform - substring of the same letter
	// weight - currentRune - 'a' + 1
	set := createSetOfQueries([]rune(s))

	m := len(queries)

	result := make([]string, m, m)

	for i, query := range queries {
		if _, ok := set[query]; ok {
			result[i] = "Yes"
		} else {
			result[i] = "No"
		}
	}
	return result
}

func createSetOfQueries(runeArray []rune) map[int32]interface{} {
	n := len(runeArray)
	dp := make([]int32, n, n)
	set := make(map[int32]interface{})

	for i := 0; i < n; i++ {
		dp[i] = int32(runeArray[i]-'a') + 1

		if i != 0 && runeArray[i] == runeArray[i-1] {
			dp[i] += dp[i-1]
		}
		set[dp[i]] = nil
	}
	return set
}
