package graph.medium.java_solutions;

import java.util.Arrays;

public class DijkstraAlgorithm {

    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        // Write your code here.
        int[][] table = new int[edges.length + 1][edges.length];
        int[] result = new int[edges.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < edges.length + 1; i++) {
            for (int j = 0; j < edges.length; j++) {
                table[i][j] = -1;
            }
        }
        table[0][start] = 0;
        result[start] = 0;
        for (int i = 1; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i - 1][j] != -1) {
                    int[][] currentEdges = edges[j];
                    for (int[] edge : currentEdges) {
                        if (table[i - 1][edge[0]] != -1) {
                            table[i][edge[0]] = Math.min(table[i - 1][j] + edge[1], table[i - 1][edge[0]]);
                        } else if (table[i][edge[0]] == -1) {
                            table[i][edge[0]] = table[i - 1][j] + edge[1];
                        }
                        if (result[edge[0]] == -1) {
                            result[edge[0]] = table[i][edge[0]];
                        } else {
                            result[edge[0]] = Math.min(table[i][edge[0]], result[edge[0]]);
                        }
                    }
                }
            }
        }
        return result;
    }
}
