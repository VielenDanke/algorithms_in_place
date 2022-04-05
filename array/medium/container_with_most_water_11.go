package medium

// O(N) time | O(1) space | 76.97% time, 16.58% space

func maxArea(height []int) (maxArea int) {
	left, right := 0, len(height)-1

	for left < right {
		area := calculateArea(min(height[left], height[right]), right-left)
		if area > maxArea {
			maxArea = area
		}
		if height[left] < height[right] {
			left++
		} else {
			right--
		}
	}
	return
}

// O(N^2) time | O(1) space | Time limit exceeded

func maxAreaBruteForce(height []int) (maxArea int) {
	for i := 0; i < len(height); i++ {
		for j := len(height) - 1; j >= i; j-- {
			if area := calculateArea(min(height[i], height[j]), j-i); area > maxArea {
				maxArea = area
			}
		}
	}
	return
}

func calculateArea(a, b int) int {
	return a * b
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
