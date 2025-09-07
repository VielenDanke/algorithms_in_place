package easy

import "math"

func findClosest(x int, y int, z int) int {
	absXZ, absYZ := math.Abs(float64(x-z)), math.Abs(float64(y-z))

	if absXZ == absYZ {
		return 0
	} else if absXZ < absYZ {
		return 1
	} else {
		return 2
	}
}
