package leetcode.structures.java_solutions;

public class UnionFind {

    private int[] id;
    private int[] sizes;
    private int size;
    private int numComponents;

    public UnionFind(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        this.size = numComponents = size;
        id = new int[size];
        sizes = new int[size];

        for (int i = 0; i < size; i++) {
            id[i] = i;
            sizes[i] = i;
        }
    }

    public int find(int p) {
        int root = p;
        while (root != id[root]) root = id[root];

        // Compress the path leading back to the root
        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    public void unify(int p, int q) {
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
}
