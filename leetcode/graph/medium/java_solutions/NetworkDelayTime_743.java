package leetcode.graph.medium.java_solutions;

import java.util.*;

public class NetworkDelayTime_743 {

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.add(new int[]{k, 0});

        boolean[] visited = new boolean[n + 1];
        int res = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int curNode = cur[0];
            int curDist = cur[1];
            if (visited[curNode]) continue;
            visited[curNode] = true;
            res = curDist;
            if (--n == 0) {
                return res;
            }
            if (map.containsKey(curNode)) {
                for (int next : map.get(curNode).keySet()) {
                    pq.add(new int[]{next, curDist + map.get(curNode).get(next)});
                }
            }
        }
        return -1;
    }

    /*
    Time LImit Exceeded
     */
    public int networkDelayTimeTimeLimit(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        int[] nodes = new int[n + 1];

        Arrays.fill(nodes, -1);

        nodes[k] = 0;

        for (int i = 0; i < times.length; i++) {
            for (int j = 1; j < nodes.length; j++) {
                if (nodes[j] != -1) {
                    Map<Integer, Integer> destPositions = map.get(j);

                    if (destPositions == null) {
                        continue;
                    }

                    for (Map.Entry<Integer, Integer> entry : destPositions.entrySet()) {
                        if (nodes[entry.getKey()] != -1) {
                            nodes[entry.getKey()] = Math.min(nodes[entry.getKey()], nodes[j] + entry.getValue());
                        } else {
                            nodes[entry.getKey()] = nodes[j] + entry.getValue();
                        }
                    }
                }
            }
        }
        return isAllVisited(nodes) ? Arrays.stream(nodes).max().getAsInt() : -1;
    }

    private boolean isAllVisited(int[] nodes) {
        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i] == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NetworkDelayTime_743().networkDelayTimeTimeLimit(new int[][]{{1, 2, 1}, {2, 3, 7}, {1, 3, 4}, {2, 1, 2}}, 3, 2));
    }
}
