package graph.medium.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceToTarget_797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        temp.add(0);

        dfs(result, temp, graph, 0);

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int[][] graph, int nextIdx) {
        if (nextIdx == graph.length - 1) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < graph[nextIdx].length; i++) {
            temp.add(graph[nextIdx][i]);
            dfs(result, temp, graph, graph[nextIdx][i]);
            temp.remove(temp.size() - 1);
        }
    }
}
