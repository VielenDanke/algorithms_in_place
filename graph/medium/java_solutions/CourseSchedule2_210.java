package graph.medium.java_solutions;

import java.util.*;

public class CourseSchedule2_210 {

    private static class Solution {

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Set<Integer> visited = new HashSet<>();
            Stack<Integer> stack = new Stack<>();
            Map<Integer, Set<Integer>> topologicalMap = buildGraph(numCourses, prerequisites);

            for (Map.Entry<Integer, Set<Integer>> entry : topologicalMap.entrySet()) {
                if (entry.getValue().size() == 0) {
                    stack.add(entry.getKey());
                }
            }
            int[] result = new int[numCourses];
            int nextIdx = 0;
            while (numCourses > 0 && !stack.isEmpty()) {
                Integer lastCourse = stack.pop();
                if (!visited.add(lastCourse)) {
                    continue;
                }
                result[nextIdx++] = lastCourse;

                for (Map.Entry<Integer, Set<Integer>> entry : topologicalMap.entrySet()) {
                    entry.getValue().remove(lastCourse);

                    if (entry.getValue().size() == 0) {
                        stack.add(entry.getKey());
                    }
                }
                numCourses--;
            }
            if (numCourses != 0) {
                return new int[]{};
            }
            return result;
        }

        private Map<Integer, Set<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
            Map<Integer, Set<Integer>> topologicalMap = new HashMap<>();

            for (int i = 0; i < numCourses; i++) {
                topologicalMap.put(i, new HashSet<>());
            }
            for (int[] prereq : prerequisites) {
                Set<Integer> dependencies = topologicalMap.get(prereq[0]);
                dependencies.add(prereq[1]);
                topologicalMap.put(prereq[0], dependencies);
            }
            return topologicalMap;
        }
    }
}
