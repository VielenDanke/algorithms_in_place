package graph.medium.java_solutions;

import java.util.*;

public class SmallestStringWithSwaps_1202 {
    // Maximum number of vertices
    final static int N = 100001;
    boolean[] visited = new boolean[N];
    List<List<Integer>> adj = new ArrayList<>();

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        for (int i = 0; i < s.length(); i++) {
            adj.add(new ArrayList<>());
        }
        // Build the adjacency list
        for (List<Integer> edge : pairs) {
            int source = edge.get(0);
            int destination = edge.get(1);

            adj.get(source).add(destination);
            adj.get(destination).add(source);
        }
        char[] answer = new char[s.length()];
        for (int vertex = 0; vertex < s.length(); vertex++) {
            // If not covered in DFS yet
            if (!visited[vertex]) {
                List<Character> characters = new ArrayList<>();
                List<Integer> indices = new ArrayList<>();
                dfs(s, vertex, characters, indices);
                // Sort the list of characters and indices
                Collections.sort(characters);
                Collections.sort(indices);

                // Store the sorted characters corresponding to the index
                for (int index = 0; index < characters.size(); index++) {
                    answer[indices.get(index)] = characters.get(index);
                }
            }
        }
        return new String(answer);
    }

    private void dfs(String s, int vertex, List<Character> characters, List<Integer> indices) {
        // Add the character and index to the list
        characters.add(s.charAt(vertex));
        indices.add(vertex);

        visited[vertex] = true;

        // Traverse the adjacency list
        for (int adjacent : adj.get(vertex)) {
            if (!visited[adjacent]) {
                dfs(s, adjacent, characters, indices);
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------

    private int[] p;
    private int n;

    public String smallestStringWithSwapsUnionFind(String s, List<List<Integer>> pairs) {
        n = s.length();
        p = new int[n];

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(find(i), k -> new PriorityQueue<>((left, right) -> left - right));
            map.get(p[i]).offer(s.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(map.get(p[i]).poll());
        }
        return builder.toString();
    }

    private int find(int i) {
        if (i != p[i]) {
            p[i] = find(p[i]);
        }
        return p[i];
    }

    private void union(int i, int j) {
       p[find(i)] = find(j);
    }
}
