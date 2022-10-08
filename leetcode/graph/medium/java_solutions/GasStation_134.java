package leetcode.graph.medium.java_solutions;

public class GasStation_134 {

    static class Solution {
        /*
        Idea:
        1. We are moving 1 time through gas and cost
        2. Each iteration we increase total and subTotal by gas[i] and decrease cost[i]
        3. if subTotal < 0 means we cannot finish from start point (index 0), we need assign subTotal to 0
           and start to the next index in leetcode.array (i + 1)
        4. By the end we check if total < 0, if true - means we cannot reach from any index in leetcode.array, if false - return start
         */
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            int total = 0;
            int surplus = 0;
            int start = 0;

            for(int i = 0; i < n; i++){
                total += gas[i] - cost[i];
                surplus += gas[i] - cost[i];
                if(surplus < 0){
                    surplus = 0;
                    start = i + 1;
                }
            }
            return (total < 0) ? -1 : start;
        }
    }

    static class SolutionBruteForce {

        public int canCompleteCircuit(int[] gas, int[] cost) {
            int len = gas.length;
            for (int i = 0; i < len; i++) {
                int stopCount = 0, j = i, totalGas = 0;
                while (stopCount < len) {
                    totalGas += gas[j % len] - cost[j % len];
                    if (totalGas < 0) break;
                    stopCount++;
                    j++;
                }
                if (stopCount == len) return i;
            }
            return -1;
        }
    }

    static class SolutionGraph {

        private static class Node {
            int gas;
            int cost;
            int idx;
            Node next;

            Node(int gas, int cost, int idx) {
                this.gas = gas;
                this.cost = cost;
                this.idx = idx;
            }
        }

        public int canCompleteCircuit(int[] gas, int[] cost) {
            Node node = new Node(gas[0], cost[0], 0);
            Node head = node;

            for (int i = 1; i < gas.length; i++) {
                node.next = new Node(gas[i], cost[i], i);
                node = node.next;
            }
            node.next = head;
            Node start = head;
            while (head != null) {
                boolean[] visited = new boolean[gas.length];
                if (find(head, head.gas, visited)) {
                    return head.idx;
                }
                head=head.next;
                if (head == start) {
                    break;
                }
            }
            return -1;
        }

        private boolean find(Node node, int gasAmount, boolean[] visited) {
            if (visited[node.idx]) {
                return true;
            }
            if (gasAmount < node.cost) {
                return false;
            }
            visited[node.idx] = true;
            gasAmount -= node.cost;
            return find(node.next, gasAmount + node.next.gas, visited);
        }
    }
}
