package leetcode.graph.medium.java_solutions;

import leetcode.graph.Helpers;

import java.util.HashMap;

import static leetcode.graph.Helpers.*;

public class CloneGraph {

    static class SolutionDFS {

        private Node[] visited;

        public Node cloneGraph(Node node) {
            if (node == null) return null;
            // constraint is 100 nodes at maximum with 1-indexed based array
            // to maintain dynamic constraint use HashSet instead (would need to modify equals and hashCode functions)
            this.visited = new Node[101];
            Node copy = new Node(node.val);
            dfs(node, copy);
            return copy;
        }

        private void dfs(Node node, Node copy) {
            visited[copy.val] = copy;

            for (Node child : node.neighbors) {
                if (visited[child.val] == null) {
                    Node copyChild = new Node(child.val);
                    copy.neighbors.add(copyChild);
                    dfs(child, copyChild);
                } else {
                    copy.neighbors.add(visited[child.val]);
                }
            }
        }
    }
}
