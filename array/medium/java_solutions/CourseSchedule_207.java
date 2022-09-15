package array.medium.java_solutions;

import java.util.*;

public class CourseSchedule_207 {

    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites.length == 0) return true;

            Map<Integer, Set<Integer>> prereqMap = buildPrerequisitesMap(prerequisites);

            Stack<Integer> stack = new Stack<>();

            for (Map.Entry<Integer, Set<Integer>> entry : prereqMap.entrySet()) {
                if (entry.getValue().size() == 0) {
                    stack.add(entry.getKey());
                }
            }
            while (!stack.isEmpty() && numCourses > 0 && !prereqMap.isEmpty()) {
                int noDependenciesCourse = stack.pop();
                numCourses--;
                prereqMap.remove(noDependenciesCourse);

                for (Map.Entry<Integer, Set<Integer>> entry : prereqMap.entrySet()) {
                    entry.getValue().remove(noDependenciesCourse);
                    if (entry.getValue().size() == 0) {
                        stack.add(entry.getKey());
                    }
                }
            }
            return prereqMap.isEmpty();
        }

        private Map<Integer, Set<Integer>> buildPrerequisitesMap(int[][] prerequisites) {
            Map<Integer, Set<Integer>> prereqMap = new HashMap<>();
            for (int[] prereq : prerequisites) {
                prereqMap.putIfAbsent(prereq[0], new HashSet<>());
                prereqMap.putIfAbsent(prereq[1], new HashSet<>());
                prereqMap.get(prereq[0]).add(prereq[1]);
            }
            return prereqMap;
        }
    }
}
