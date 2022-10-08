package easy

import "sort"

/*

 */

func TandemBicycle(redShirtSpeeds []int, blueShirtSpeeds []int, fastest bool) (result int) {
	sort.Ints(redShirtSpeeds)

	if fastest {
		sort.Ints(blueShirtSpeeds)
	} else {
		sort.Slice(blueShirtSpeeds, func(i, j int) bool {
			return blueShirtSpeeds[i] > blueShirtSpeeds[j]
		})
	}

	for idx := range redShirtSpeeds {
		fRider := redShirtSpeeds[idx]
		sRider := blueShirtSpeeds[len(blueShirtSpeeds)-1-idx]
		result += max(fRider, sRider)
	}
	return
}

func max(rider1 int, rider2 int) int {
	if rider1 > rider2 {
		return rider1
	}
	return rider2
}
