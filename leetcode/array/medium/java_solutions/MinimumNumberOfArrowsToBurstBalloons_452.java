package leetcode.array.medium.java_solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/*
Rust solution:

pub fn find_min_arrow_shots(mut points: Vec<Vec<i32>>) -> i32 {
    points.sort_by(|a, b| a[1].cmp(&b[1]));

    let (mut result, mut end) = (1, points[0][1]);

    for i in 1..points.len() {
        if points[i][0] > end {
            result += 1;
            end = points[i][1];
        }
    }
    result
}

use std::cmp::max;
use std::cmp::min;

    pub fn find_min_arrow_shots(mut points: Vec<Vec<i32>>) -> i32 {
        points.sort_by(|l, r| if l[0] == r[0] { l[1].cmp(&r[1]) } else { l[0].cmp(&r[0]) });

        let mut stack = Vec::new();

        for point in &points {
            if stack.is_empty() || !Solution::is_intersect(&stack.get(stack.len() - 1).unwrap(), &point) {
                stack.push(point.to_vec());
            } else {
                let last_elem = stack.remove(stack.len() - 1);
                stack.push(vec![max(point[0], last_elem[0]), min(point[1], last_elem[1])]);
            }
        }
        stack.len() as i32
    }

    fn is_intersect(from_stack: &Vec<i32>, next: &Vec<i32>) -> bool {
        (next[0] >= from_stack[0] && next[0] <= from_stack[1]) || (next[1] >= from_stack[0] && next[1] <= from_stack[1])
    }

 */

public class MinimumNumberOfArrowsToBurstBalloons_452 {

    static class SolutionWithoutStack {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

            int result = 1;
            int end = points[0][1];

            for (int i = 1; i < points.length; i++) {
                if (points[i][0] > end) {
                    result++;
                    end = points[i][1];
                }
            }
            return result;
        }
    }

    static class Solution {
        public int findMinArrowShots(int[][] points) {
            // sort using start position
            // unite points such as [max(x0, x1), min(y0, y1)]
            // check if next point cross boarder, if yes - unite, if not - skip
            Arrays.sort(points, (l, r) -> {
                if (l[0] == r[0]) {
                    return l[1] - r[1];
                }
                return l[0] - r[0];
            });

            Stack<int[]> stack = new Stack<>();

            for (int[] point : points) {
                if (stack.isEmpty() || !isIntersect(stack.peek(), point)) {
                    stack.add(point);
                } else {
                    int[] lastElem = stack.pop();
                    stack.add(new int[]{Math.max(point[0], lastElem[0]), Math.min(point[1], lastElem[1])});
                }
            }
            return stack.size();
        }

        private boolean isIntersect(int[] fromStack, int[] next) {
            return (next[0] >= fromStack[0] && next[0] <= fromStack[1]) || (next[1] >= fromStack[0] && next[1] <= fromStack[1]);
        }
    }
}
