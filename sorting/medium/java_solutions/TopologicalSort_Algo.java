package sorting.medium.java_solutions;

import java.util.*;

public class TopologicalSort_Algo {

    // Time O(J + D) | Space O(J + D)

    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        List<Integer> sortedJobs = new ArrayList<>();
        Map<Integer, List<Integer>> graph = buildGraph(jobs, deps);
        Set<Integer> visited = new HashSet<>();
        Set<Integer> parents = new HashSet<>();

        if (!checkIfGraphIsValidAndTraverse(sortedJobs, jobs, graph, visited, parents)) {
            return new ArrayList<>();
        }
        return sortedJobs;
    }

    private static boolean checkIfGraphIsValidAndTraverse(List<Integer> sortedJobs, List<Integer> jobs, Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> parents) {
        for (Integer j : jobs) {
            if (parents.contains(j)) {
                return false;
            }
            if (visited.contains(j)) {
                continue;
            }
            visited.add(j);
            parents.add(j);
            List<Integer> dependJobs = graph.get(j);
            if (dependJobs.size() != 0) {
                if (!checkIfGraphIsValidAndTraverse(sortedJobs, dependJobs, graph, visited, parents)) {
                    return false;
                }
            }
            parents.remove(j);
            sortedJobs.add(j);
        }
        return true;
    }

    private static Map<Integer, List<Integer>> buildGraph(List<Integer> jobs, List<Integer[]> deps) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (Integer job : jobs) {
            graph.put(job, new ArrayList<>());
        }
        for (Integer[] dep : deps) {
            graph.get(dep[1]).add(dep[0]);
        }
        return graph;
    }
}
