package leetcode.tree.hard.java_solutions;

import java.util.ArrayList;
import java.util.List;

import static leetcode.tree.Helper.Node;

public class LongestPathWithDifferentAdjacentCharacters_2246 {

    static class Solution {

        private int maxPath = 0;

        public int longestPath(int[] parent, String s) {
            List<List<Integer>> nodes = constructTree(parent, s);
            findMaxPath(nodes, s, 0);
            return maxPath;
        }

        private int findMaxPath(List<List<Integer>> nodes, String s, int i) {
            int left = 0, right = 0;
            for (int j : nodes.get(i)) {
                int temp = findMaxPath(nodes, s, j);
                if (s.charAt(j) != s.charAt(i))
                    if (temp > left) {
                        right = left;
                        left = temp;
                    } else if (temp > right) {
                        right = temp;
                    }
            }
            maxPath = Math.max(maxPath, left + right + 1);
            return left + 1;
        }

        private List<List<Integer>> constructTree(int[] parent, String s) {
            int n = parent.length;

            List<List<Integer>> l = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                l.add(new ArrayList<>());
            }
            for (int i = 1; i < n; i++) {
                l.get(parent[i]).add(i);
            }
            return l;
        }
    }

    static class SolutionBruteForce {

        private int maxPath = 0;

        public int longestPath(int[] parent, String s) {
            Node[] nodes = constructTree(parent, s);
            findMaxPath(nodes, 0);
            return maxPath;
        }

        private int findMaxPath(Node[] nodes, int i) {
            int left = 0, right = 0;
            for (int j = 0; j < nodes[i].children.size(); j++) {
                int temp = findMaxPath(nodes, j);
                if (nodes[i].val != nodes[i].children.get(j).val) {
                    if (temp > left) {
                        right = left;
                        left = temp;
                    } else if (temp > right) {
                        right = temp;
                    }
                }
            }
            maxPath = Math.max(maxPath, left + right + 1);
            return left + 1;
        }

        private Node[] constructTree(int[] parent, String s) {
            int n = parent.length;

            Node[] nodes = new Node[n];

            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(s.charAt(i));
            }
            for (int i = 1; i < n; i++) {
                nodes[parent[i]].children.add(nodes[i]);
            }
            return nodes;
        }
    }
}
