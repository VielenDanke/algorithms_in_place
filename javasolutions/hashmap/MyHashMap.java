package javasolutions.hashmap;

import java.util.LinkedList;
import java.util.List;

class MyHashMap {

    private List<KeyValue>[] table;
    private int capacity;
    private int size;

    public MyHashMap() {
        this.capacity = 8;
        this.table = new List[capacity];
        this.size = 0;
    }

    public void put(int key, int value) {
        if (this.size == this.capacity / 2) {
            this.capacity *= 2;
            List<KeyValue>[] newTable = new List[this.capacity];

            for (List<KeyValue> kv : this.table) {
                if (kv != null) {
                    KeyValue keyValue = kv.get(0);
                    int newIdx = keyValue.hashCode() % this.capacity;
                    newTable[newIdx] = kv;
                }
            }
            this.table = newTable;
        }
        KeyValue input = new KeyValue(key, value);
        int inputIdx = input.hashCode() % this.table.length;
        List<KeyValue> idxList = this.table[inputIdx];
        if (idxList == null) {
            List<KeyValue> incomingList = new LinkedList<>();
            incomingList.add(input);
            this.table[inputIdx] = incomingList;
        } else {
            for (int i = 0; i < idxList.size(); i++) {
                if (idxList.get(i).equals(input)) {
                    idxList.set(i, input);
                    break;
                }
            }
            this.table[inputIdx] = idxList;
        }
        this.size++;
    }

    public int get(int key) {
        int idx = key % this.table.length;

        List<KeyValue> idxList = this.table[idx];

        return (idxList == null) ? -1 : idxList
                .stream()
                .filter(k -> k.getKey() == key)
                .map(k -> k.getValue())
                .findFirst().orElse(-1);
    }

    public void remove(int key) {
        int idx = key % this.table.length;

        List<KeyValue> idxList = this.table[idx];

        if (idxList != null) {
            for (int i = 0; i < idxList.size(); i++) {
                KeyValue keyValue = idxList.get(i);
                if (keyValue.getKey() == key) {
                    List<KeyValue> left = idxList.subList(0, i);
                    if (i != idxList.size() - 1) {
                        List<KeyValue> right = idxList.subList(i + 1, idxList.size());
                        left.addAll(right);
                    }
                    this.table[idx] = left;
                }
            }
        }
    }

    static class KeyValue {
        private final Integer key;
        private final Integer value;

        public KeyValue(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return this.key;
        }

        public Integer getValue() {
            return this.value;
        }

        @Override
        public int hashCode() {
            return this.key;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            KeyValue other = (KeyValue) o;

            if (other.getKey() == null) {
                return false;
            }
            return this.key.equals(other.getKey());
        }
    }
}
