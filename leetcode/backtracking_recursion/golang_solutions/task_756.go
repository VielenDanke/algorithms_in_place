package golang_solutions

var prefixMap = map[string][]byte{}

func pyramidTransition(bottom string, allowed []string) bool {
	patterns := make(map[string][]byte)
	for _, s := range allowed {
		key := s[:2]
		patterns[key] = append(patterns[key], s[2])
	}

	var dfs func(row, nextRow []byte) bool
	dfs = func(row, nextRow []byte) bool {
		if len(row) == 1 {
			return true
		}

		if len(nextRow) == len(row)-1 {
			return dfs(nextRow, []byte{})
		}

		idx := len(nextRow)
		key := string(row[idx]) + string(row[idx+1])

		if tops, exists := patterns[key]; exists {
			for _, top := range tops {
				nextRow = append(nextRow, top)

				if dfs(row, nextRow) {
					return true
				}

				nextRow = nextRow[:len(nextRow)-1]
			}
		}

		return false
	}

	return dfs([]byte(bottom), []byte{})
}
