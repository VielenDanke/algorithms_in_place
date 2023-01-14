package leetcode.strings.medium.java_solutions;

public class LexicographicallySmallestEquivalentString_1061 {

    static class Solution {

        static class UnionFind {

            int[] id;

            UnionFind() {
                id = new int[26];
                for (int i = 0; i < 26; i++) {
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
                int left = find(p), right = find(q);
                if (left < right) {
                    id[right] = left;
                } else {
                    id[left] = right;
                }
            }
        }

        public String smallestEquivalentString(String s1, String s2, String baseStr) {
            UnionFind uf = new UnionFind();

            for (int i = 0; i < s1.length(); i++) {
                uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < baseStr.length(); i++) {
                builder.append((char) (uf.find(baseStr.charAt(i) - 'a') + 'a'));
            }
            return builder.toString();
        }
    }
}
