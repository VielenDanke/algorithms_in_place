package graph.medium.java_solutions;

public class SatisfiabilityEqualityEquations_990 {

    static class SolutionUnionFind {

        private static class UnionFind {
            int[] id;

            UnionFind(int size) {
                id = new int[size];
                for (int i = 0; i < size; i++) {
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

            boolean isConnected(int p, int q) {
                return find(p) == find(q);
            }
        }

        public boolean equationsPossible(String[] equations) {
            final UnionFind uf = new UnionFind(26);
            for (String str : equations) {
                if (str.charAt(1) == '=') {
                    uf.union(str.charAt(0) - 'a', str.charAt(3) - 'a');
                }
            }
            for (String str : equations) {
                if (str.charAt(1) == '!' && uf.isConnected(str.charAt(0) - 'a', str.charAt(3) - 'a')) {
                    return false;
                }
            }
            return true;
        }
    }
}
