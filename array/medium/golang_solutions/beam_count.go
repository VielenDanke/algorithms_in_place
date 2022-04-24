package golang_solutions

import "strings"

func NumberOfBeams(bank []string) int {
	nextIdx := 0
	beamCounter := 0
	start := 0
	for start+1 < len(bank) {
		if !strings.Contains(bank[start], "1") {
			start++
			continue
		}
		nextIdx = start + 1
		for nextIdx < len(bank) && !strings.Contains(bank[nextIdx], "1") {
			nextIdx++
		}
		if nextIdx >= len(bank) {
			break
		}
		for _, fBeam := range bank[start] {
			if fBeam == 48 {
				continue
			}
			beamCounter += strings.Count(bank[nextIdx], "1")
		}
		start = nextIdx
	}
	return beamCounter
}
