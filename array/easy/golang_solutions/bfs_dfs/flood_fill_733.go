package bfs_dfs

func floodFill(image [][]int, sr int, sc int, newColor int) [][]int {
	if image[sr][sc] == newColor {
		return image
	}
	return flood(image, sr, sc, newColor, image[sr][sc])
}

func flood(image [][]int, sr int, sc int, newColor int, oldColor int) [][]int {
	if sr < 0 || sr >= len(image) {
		return image
	}
	if sc < 0 || sc >= len(image[0]) {
		return image
	}
	if image[sr][sc] != oldColor {
		return image
	}
	image[sr][sc] = newColor
	flood(image, sr-1, sc, newColor, oldColor)
	flood(image, sr+1, sc, newColor, oldColor)
	flood(image, sr, sc+1, newColor, oldColor)
	flood(image, sr, sc-1, newColor, oldColor)
	return image
}
