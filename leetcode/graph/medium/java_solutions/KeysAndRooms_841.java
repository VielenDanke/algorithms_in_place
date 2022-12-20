package leetcode.graph.medium.java_solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms_841 {

    static class SolutionBFS {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            Queue<Integer> queue = new LinkedList<>();

            queue.add(0);

            boolean[] visited = new boolean[rooms.size()];

            while (!queue.isEmpty()) {
                int idx = queue.poll();

                if (visited[idx]) continue;

                visited[idx] = true;

                List<Integer> currentRooms = rooms.get(idx);

                queue.addAll(currentRooms);
            }
            for (boolean isVisited : visited) {
                if (!isVisited) return false;
            }
            return true;
        }
    }

    static class SolutionDFS {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            boolean[] visited = new boolean[rooms.size()];

            dfs(rooms, visited, 0);

            for (boolean isVisited : visited) {
                if (!isVisited) {
                    return false;
                }
            }
            return true;
        }

        private void dfs(List<List<Integer>> rooms, boolean[] visited, int idx) {
            if (visited[idx]) {
                return;
            }
            visited[idx] = true;
            List<Integer> currentRooms = rooms.get(idx);

            for (Integer nextRoom : currentRooms) {
                dfs(rooms, visited, nextRoom);
            }
        }
    }
}
