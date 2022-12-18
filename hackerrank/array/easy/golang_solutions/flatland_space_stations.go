package golang_solutions

import (
	"math"
	"sort"
)

func flatlandSpaceStations(n int32, c []int32) int32 {
	maxPath := int32(0)
	sort.Slice(c, func(i, j int) bool {
		return c[i] < c[j]
	})
	maxPath = int32(math.Max(float64(maxPath), float64(c[0])))
	maxPath = int32(math.Max(float64(maxPath), float64(n-1-c[len(c)-1])))

	for i := 1; i < len(c); i++ {
		maxPath = int32(math.Max(float64(maxPath), math.Floor(float64((c[i]-c[i-1])/2))))
	}
	return maxPath
}

func flatlandSpaceStationsTimeLimit(n int32, c []int32) int32 {
	m := make(map[int32]interface{})

	for _, v := range c {
		m[v] = nil
	}
	maxNum := int32(0)

	for i := int32(0); i < n; i++ {
		if _, ok := m[i]; !ok {
			left, right := i-1, i+1

			minNum := int32(1 << 30)

			for left >= 0 {
				if _, ok := m[left]; ok {
					minNum = int32(math.Min(float64(minNum), float64(i-left)))
					break
				}
				left--
			}
			for right < n {
				if _, ok := m[right]; ok {
					minNum = int32(math.Min(float64(minNum), float64(right-i)))
					break
				}
				right++
			}
			maxNum = int32(math.Max(float64(maxNum), float64(minNum)))
		}
	}
	return maxNum
}
