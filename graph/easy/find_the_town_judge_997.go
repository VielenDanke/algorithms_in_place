package easy

func findJudge(n int, trust [][]int) int {
	citizenMap := make(map[int]map[int]interface{})

	citizen := 1

	for citizen <= n {
		citizenMap[citizen] = make(map[int]interface{})
		citizen++
	}

	for _, v := range trust {
		citizenMap[v[0]][v[1]] = nil
	}
	judge := -1 << 31

	for k, v := range citizenMap {
		if len(v) == 0 {
			judge = k
			break
		}
	}
	if judge == -1<<31 {
		return -1
	}
	for k, v := range citizenMap {
		if k == judge {
			continue
		} else {
			if _, ok := v[judge]; !ok {
				return -1
			}
		}
	}
	return judge
}
