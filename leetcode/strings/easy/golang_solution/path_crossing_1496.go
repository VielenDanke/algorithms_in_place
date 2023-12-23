package golang_solution

import "fmt"

/*
use std::collections::HashSet;

impl Solution {
    pub fn is_path_crossing(path: String) -> bool {
        let (mut y, mut x, mut seen) = (0, 0, HashSet::from([(0, 0)]));
        for c in path.chars() {
            if c == 'N' {
                y += 1;
            } else if c == 'E' {
                x += 1;
            } else if c == 'S' {
                y -= 1;
            } else {
                x -= 1;
            }

            if seen.contains(&(y, x)) {
                return true;
            }
            seen.insert((y, x));
        }
        false
    }
}
*/

var coordinates = make(map[rune][]int)

func init() {
	coordinates['N'] = []int{1, 0}
	coordinates['S'] = []int{-1, 0}
	coordinates['E'] = []int{0, -1}
	coordinates['W'] = []int{0, 1}
}

func isPathCrossing(path string) bool {
	visited := make(map[string]interface{})

	visited["0-0"] = nil

	row, col := 0, 0

	for _, v := range []rune(path) {
		coordinate := coordinates[v]
		row += coordinate[0]
		col += coordinate[1]

		key := fmt.Sprintf("%d-%d", row, col)

		if _, ok := visited[key]; ok {
			return true
		}
		visited[key] = nil
	}
	return false
}
