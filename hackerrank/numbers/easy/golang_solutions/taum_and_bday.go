package golang_solutions

// https://www.hackerrank.com/challenges/taum-and-bday/problem

func taumBday(b int32, w int32, bc int32, wc int32, z int32) int64 {
	// Write your code here
	bcl, wcl, bl, wl, zl := int64(bc), int64(wc), int64(b), int64(w), int64(z)
	if bcl*bl > (wcl+zl)*bl {
		bcl = wcl + zl
	}
	if wcl*wl > (bcl+zl)*wl {
		wcl = bcl + zl
	}
	return bl*bcl + wl*wcl
}
