package leetcode.graph.medium.java_solutions;

import java.util.*;

public class IsGraphBipartite_785 {

    /*
    Python solution

    def isBipartite(self, leetcode.graph: List[List[int]]) -> bool:
        N = len(leetcode.graph)
        colors = [0] * N

        def isValid(leetcode.graph: List[List[int]], colors: List[int], nextNode: int, color: int) -> bool:
            if colors[nextNode] != 0:
                return colors[nextNode] == color
            colors[nextNode] = color
            for index, node in enumerate(leetcode.graph[nextNode]):
                if not isValid(leetcode.graph, colors, node, -color):
                    return False
            return True

        for i in range(N):
            if colors[i] == 0 and not isValid(leetcode.graph, colors, i, 1):
                return False
        return True
     */

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !isValidColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int nextNode : graph[node]) {
            if (!isValidColor(graph, colors, -color, nextNode)) {
                return false;
            }
        }
        return true;
    }

    // --------------------------------------------------------------------------------------------

    public boolean isBipartiteIterative(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                colors[i] = 1;
                while (!q.isEmpty()) {
                    Integer node = q.poll();
                    for (int adjacent : graph[node])
                        if (colors[adjacent] == colors[node]) {
                            return false;
                        } else if (colors[adjacent] == 0) {
                            q.add(adjacent);
                            colors[adjacent] = -colors[node];
                        }
                }
            }
        }
        return true;
    }
}
