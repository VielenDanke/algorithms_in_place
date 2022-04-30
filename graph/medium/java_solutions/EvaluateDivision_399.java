package graph.medium.java_solutions;

import java.util.*;

public class EvaluateDivision_399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);

        int queriesSize = queries.size();

        double[] result = new double[queriesSize];

        for (int i = 0; i < queriesSize; i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }
        return result;
    }

    private double dfs(String src, String dest, Set<String> visited, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(src)) {
            return -1.0;
        }
        if (graph.get(src).containsKey(dest)) {
            return graph.get(src).get(dest);
        }
        visited.add(src);

        for (Map.Entry<String, Double> node : graph.get(src).entrySet()) {
            if (!visited.contains(node.getKey())) {
                double weight = dfs(node.getKey(), dest, visited, graph);

                if (weight != -1.0) {
                    return node.getValue() * weight;
                }
            }
        }
        return -1.0;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String left = equations.get(i).get(0);
            String right = equations.get(i).get(1);

            graph.computeIfAbsent(left, innerGraph -> new HashMap<>());
            graph.get(left).put(right, values[i]);

            graph.computeIfAbsent(right, innerGraph -> new HashMap<>());
            graph.get(right).put(left, 1 / values[i]);
        }
        return graph;
    }
}
