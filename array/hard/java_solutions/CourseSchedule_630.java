package array.hard.java_solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class CourseSchedule_630 {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            queue.add(course[0]);
            if (time > course[1] && !queue.isEmpty()) time -= queue.poll();
        }
        return queue.size();
    }
}
