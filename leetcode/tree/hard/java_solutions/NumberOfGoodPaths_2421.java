package leetcode.tree.hard.java_solutions;

import java.util.*;

public class NumberOfGoodPaths_2421 {

    static class Solution {

        static class UnionFind {

            int[] id;

            UnionFind(int n) {
                id = new int[n];
                for (int i = 0; i < n; i++) {
                    id[i] = i;
                }
            }

            int find(int p) {
                while (p != id[p]) {
                    id[p] = id[id[p]];
                    p = id[p];
                }
                return p;
            }

            void union(int p, int q) {
                id[find(p)] = find(q);
            }
        }

        private int n;

        public int numberOfGoodPaths(int[] vals, int[][] edges) {
            n = vals.length;
            int sum = n;
            ArrayList<ArrayList<Integer>> graph = buildGraph(edges);
            TreeMap<Integer, ArrayList<Integer>> tm = buildTree(vals);
            UnionFind uf = new UnionFind(n);

            while (!tm.isEmpty()) {
                Map.Entry<Integer, ArrayList<Integer>> curr = tm.pollFirstEntry();
                List<Integer> listNodes = curr.getValue();

                for (Integer node : listNodes) {
                    List<Integer> neighbors = graph.get(node);
                    for (Integer neighbor : neighbors) {
                        if (vals[node] >= vals[neighbor]) {
                            uf.union(node, neighbor);
                        }
                    }
                }
                if (listNodes.size() > 1) {
                    Map<Integer, Integer> freq = new HashMap<>();

                    for (Integer listNode : listNodes) {
                        int parent = uf.find(listNode);
                        freq.put(parent, freq.getOrDefault(parent, 0) + 1);
                    }
                    for (int parentKey : freq.keySet()) {
                        int frequency = freq.get(parentKey) - 1;
                        sum += (frequency * (frequency + 1)) / 2;
                    }
                }
            }
            return sum;
        }

        private TreeMap<Integer, ArrayList<Integer>> buildTree(int[] vals) {
            var tree = new TreeMap<Integer, ArrayList<Integer>>();

            for (int i = 0; i < n; i++) {
                tree.putIfAbsent(vals[i], new ArrayList<>());
                tree.get(vals[i]).add(i);
            }
            return tree;
        }

        private ArrayList<ArrayList<Integer>> buildGraph(int[][] edges) {
            var list = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                list.get(edge[0]).add(edge[1]);
                list.get(edge[1]).add(edge[0]);
            }
            return list;
        }
    }
}
