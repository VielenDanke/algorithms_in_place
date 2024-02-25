package leetcode.structures.java_solutions;

public class UnionFind {

    private final int[] id;
    private final int[] sizes;
    private int numComponents;

    public UnionFind(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        int size1 = numComponents = size;
        id = new int[size];
        sizes = new int[size];

        for (int i = 0; i < size; i++) {
            id[i] = i;
            sizes[i] = i;
        }
    }

    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int root1 = find(p), root2 = find(q);

        if (root1 == root2) return;

        if (sizes[root1] < sizes[root2]) {
            sizes[root2] += sizes[root1];
            id[root1] = root2;
        } else {
            sizes[root1] += sizes[root2];
            id[root2] = root1;
        }
        numComponents--;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int getNumComponents() {
        return numComponents;
    }
}
