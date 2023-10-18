package leetcode.graph.hard;

import java.util.*;

public class ParallelCourses3_2050 {

    static class Solution {
        List<List<Integer>> adjacencyList;  // Adjacency list to represent the course prerequisites
        List<Integer> inDegrees;  // In-degree of each course (number of prerequisites)

        // Kahn's Algorithm
        public int calculateMinimumTime(int n, int[] time) {
            int[] waitTime = new int[n + 1];  // keep track of wait time for each course
            Queue<int[]> q = new LinkedList<>();  // queue for topological sort
            int maxWaitTime = 0;  // Maximum wait time for completing all courses

            // Initialize the queue with courses that have no prerequisites
            for (int i = 1; i <= n; i++) {
                if (inDegrees.get(i) == 0) {
                    q.offer(new int[]{time[i - 1], i});
                    waitTime[i] = time[i - 1];
                }
            }

            // Perform topological sort
            while (!q.isEmpty()) {
                int[] currentNode = q.poll();
                int currentCourseTime = currentNode[0];
                maxWaitTime = Math.max(maxWaitTime, currentCourseTime);
                int currentCourse = currentNode[1];

                // Process each course that depends on the current course
                for (int parentCourse : adjacencyList.get(currentCourse)) {
                    inDegrees.set(parentCourse, inDegrees.get(parentCourse) - 1);
                    waitTime[parentCourse] = Math.max(time[parentCourse - 1] + waitTime[currentCourse], waitTime[parentCourse]);

                    // If all prerequisites are completed, update the wait time and add to the priority queue
                    if (inDegrees.get(parentCourse) == 0) {
                        q.offer(new int[]{waitTime[parentCourse], parentCourse});
                    }
                }
            }
            return maxWaitTime;
        }

        public int minimumTime(int n, int[][] relations, int[] time) {
            adjacencyList = new ArrayList<>(n + 1);
            inDegrees = new ArrayList<>(n + 1);

            for (int i = 0; i <= n; i++) {
                adjacencyList.add(new ArrayList<>());
                inDegrees.add(0);
            }

            // Build the adjacency list and calculate in-degrees for each course
            for (int[] prerequisitePair : relations) {
                adjacencyList.get(prerequisitePair[0]).add(prerequisitePair[1]);
                inDegrees.set(prerequisitePair[1], inDegrees.get(prerequisitePair[1]) + 1);
            }
            return calculateMinimumTime(n, time);
        }
    }

    static class SolutionBruteForce {
        public int minimumTime(int n, int[][] relations, int[] time) {
            Map<Integer, Set<Integer>> relationships = new HashMap<>();
            int[] maxTimePerRelation = new int[n];
            for (int[] relation : relations) {
                int parent = relation[1];
                int child = relation[0];
                int parentTime = time[parent - 1];
                int childTime = time[child - 1];
                relationships.putIfAbsent(parent, new HashSet<>());
                relationships.putIfAbsent(child, new HashSet<>());
                relationships.get(parent).add(child);
                maxTimePerRelation[parent - 1] = Math.max(maxTimePerRelation[parent - 1], parentTime);
                maxTimePerRelation[child - 1] = Math.max(maxTimePerRelation[child - 1], childTime);
            }
            int totalMax = 0;
            TreeMap<Integer, Set<Integer>> levelMap = new TreeMap<>();
            for (Map.Entry<Integer, Set<Integer>> entry : relationships.entrySet()) {
                levelMap.putIfAbsent(entry.getValue().size(), new HashSet<>());
                levelMap.get(entry.getValue().size()).add(entry.getKey());
            }
            while (!levelMap.isEmpty()) {
                int currentMaxTime = 0;
                Map.Entry<Integer, Set<Integer>> integerListEntry = levelMap.pollFirstEntry();
                for (int idx : integerListEntry.getValue()) {
                    currentMaxTime = Math.max(currentMaxTime, maxTimePerRelation[idx - 1]);
                }
                totalMax += currentMaxTime;
            }
            return totalMax;
        }
    }
}
