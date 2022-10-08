package golang_solutions

func InterweavingStrings(one, two, three string) bool {
	if len(one)+len(two) != len(three) {
		return false
	}
	memo := make([][]*bool, len(one)+1)
	for i := range memo {
		memo[i] = make([]*bool, len(two)+1)
	}
	return areInterwoven(one, two, three, 0, 0, memo)
}

func areInterwoven(one, two, three string, i, j int, memo [][]*bool) bool {
	if memo[i][j] != nil {
		return *memo[i][j]
	}
	k := i + j

	if k == len(three) {
		return true
	}
	if i < len(one) && one[i] == three[k] {
		isInterwoven := areInterwoven(one, two, three, i+1, j, memo)
		memo[i][j] = &isInterwoven
		if isInterwoven {
			return true
		}
	}
	if j < len(two) && two[j] == three[k] {
		isInterwoven := areInterwoven(one, two, three, i, j+1, memo)
		memo[i][j] = &isInterwoven
		if isInterwoven {
			return true
		}
	}
	result := false
	memo[i][j] = &result
	return result
}
