package leetcode.array.medium.java_solutions;

import java.util.*;

public class SnapshotArray_1146 {

    static class SnapshotArray {

        private final List<TreeMap<Integer, Integer>> arr;
        private int currentId;

        public SnapshotArray(int length) {
            this.currentId = 0;
            this.arr = new ArrayList<>();

            for (int i = 0; i < length; i++) {
                arr.add(i, new TreeMap<>());
                arr.get(i).put(0, 0);
            }
        }

        public void set(int index, int val) {
            arr.get(index).put(currentId, val);
        }

        public int snap() {
            return currentId++;
        }

        public int get(int index, int snapId) {
            return arr.get(index).floorEntry(snapId).getValue();
        }
    }

    static class SnapshotArrayBruteForce {

        private final Map<Integer, Object> snaps;
        private final Map<Integer, Integer> associatedIds;
        private int currentId;
        private final int[] arr;

        public SnapshotArrayBruteForce(int length) {
            this.currentId = 0;
            this.snaps = new HashMap<>();
            this.associatedIds = new HashMap<>();
            this.arr = new int[length];
        }

        public void set(int index, int val) {
            arr[index] = val;
        }

        public int snap() {
            int key = Arrays.hashCode(arr);
            if (associatedIds.containsKey(key)) {
                snaps.put(currentId, associatedIds.get(key));
            } else {
                snaps.put(currentId, arr.clone());
                associatedIds.put(key, currentId);
            }
            currentId++;
            return currentId - 1;
        }

        public int get(int index, int snapId) {
            if (snaps.containsKey(snapId)) {
                Object o = snaps.get(snapId);
                if (o.getClass().isAssignableFrom(Integer.class)) {
                    return ((int[])snaps.get((Integer) o))[index];
                } else {
                    return ((int[]) snaps.get(snapId))[index];
                }
            }
            return -1;
        }
    }

}
