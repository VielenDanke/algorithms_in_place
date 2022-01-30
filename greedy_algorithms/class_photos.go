package greedy_algorithms

import "sort"

/*
Problem [r] [b] - have to relocate them that red shirts will be shorter than blue shirts on the same index
*/

// ClassPhotos algorithm O(N * logN) time | O(1) space
func ClassPhotos(redShirtHeights []int, blueShirtHeights []int) bool {
	sort.Slice(redShirtHeights, func(i, j int) bool {
		return redShirtHeights[i] > redShirtHeights[j]
	})
	sort.Slice(blueShirtHeights, func(i, j int) bool {
		return blueShirtHeights[i] > blueShirtHeights[j]
	})
	shortInFrontRow := "BLUE"
	if redShirtHeights[0] < blueShirtHeights[0] {
		shortInFrontRow = "RED"
	}
	for idx := range redShirtHeights {
		if shortInFrontRow == "RED" {
			if redShirtHeights[idx] >= blueShirtHeights[idx] {
				return false
			}
		} else {
			if redShirtHeights[idx] <= blueShirtHeights[idx] {
				return false
			}
		}
	}
	return true
}
