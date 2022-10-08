package leetcode.array.medium.java_solutions;

public class ContainerWithMostWater_11 {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = -1 << 30;

        while (left < right) {
            max = Math.max(Math.min(height[left], height[right]) * (right - left), max);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
