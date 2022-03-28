package medium

func canVisitAllRooms(rooms [][]int) bool {
	visited := make(map[int]interface{})
	visitRooms(0, rooms, visited)
	return len(visited) == len(rooms)
}

func visitRooms(nextIdx int, rooms [][]int, visited map[int]interface{}) {
	visited[nextIdx] = nil

	keys := rooms[nextIdx]

	for _, key := range keys {
		if _, ok := visited[key]; ok {
			continue
		}
		visitRooms(key, rooms, visited)
	}
}
