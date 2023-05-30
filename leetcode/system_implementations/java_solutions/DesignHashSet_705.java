package leetcode.system_implementations.java_solutions;

import java.util.LinkedList;

public class DesignHashSet_705 {

    static class MyHashSet {

        private final LinkedList<Integer>[] buckets;
        private final int size = 256;

        @SuppressWarnings("unchecked")
        public MyHashSet() {
            this.buckets = new LinkedList[size];
        }

        public void add(int key) {
            int idx = key % size;
            if (buckets[idx] == null) {
                buckets[idx] = new LinkedList<>();
            }
            if (!contains(idx, key)) {
                buckets[idx].add(key);
            }
        }

        public void remove(int key) {
            int idx = key % size;
            if (buckets[idx] != null) {
                buckets[idx].removeFirstOccurrence(key);
            }
        }

        public boolean contains(int key) {
            return contains(key % size, key);
        }

        private boolean contains(int idx, int key) {
            return buckets[idx] != null && buckets[idx].contains(key);
        }
    }
}
