package golang_solutions

import "math"

// if by the shortest path we can reach fx and fx in the period of time
// it means we can reach by any path the dest point

func isReachableAtTime(sx int, sy int, fx int, fy int, t int) bool {
	if sx == fx && sy == fy {
		return t != 1
	}
	return int(math.Max(math.Abs(float64(sx-fx)), math.Abs(float64(sy-fy)))) <= t
}

// ---------------------------------------------------------------------------------------------------

func isReachableAtTimeBruteForce(sx int, sy int, fx int, fy int, t int) bool {
	if sx == fx && sy == fy {
		return t != 1
	}
	return dfs(sx, sy, fx, fy, t)
}

func dfs(sx, sy, fx, fy, t int) bool {
	if sx == fx && sy == fy {
		return t >= 0
	}
	if sx > fx {
		sx--
	} else if sx < fx {
		sx++
	}
	if sy > fy {
		sy--
	} else if sy < fy {
		sy++
	}
	return dfs(sx, sy, fx, fy, t-1)
}
