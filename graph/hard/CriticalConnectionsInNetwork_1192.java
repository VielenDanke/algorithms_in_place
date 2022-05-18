package graph.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInNetwork_1192 {

    private int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] disc = new int[n], low = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> criticalConnectionList = new ArrayList<>();

        Arrays.fill(disc, -1);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            int from = connection.get(0), to = connection.get(1);
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, low, disc, graph, criticalConnectionList, i);
            }
        }
        return criticalConnectionList;
    }


    private void dfs(int u, int[] low, int[] disc, List<List<Integer>> graph, List<List<Integer>> criticalConnectionList, int pre) {
        disc[u] = low[u] = ++time;
        for (int j = 0; j < graph.get(u).size(); j++) {
            int v = graph.get(u).get(j);
            if (v == pre) {
                continue;
            }
            if (disc[v] == -1) {
                dfs(v, low, disc, graph, criticalConnectionList, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    criticalConnectionList.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
