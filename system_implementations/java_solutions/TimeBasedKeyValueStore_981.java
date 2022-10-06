package system_implementations.java_solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore_981 {

    static class TimeMap {

        private static class Pair {
            String value;
            int timestamp;

            Pair(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }

        private final Map<String, List<Pair>> storage;

        public TimeMap() {
            this.storage = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            storage.putIfAbsent(key, new ArrayList<>());
            storage.get(key).add(new Pair(value, timestamp));
        }

        public String get(String key, int timestamp) {
            List<Pair> current = storage.getOrDefault(key, null);
            if (current != null && !current.isEmpty()) {
                for (int i = current.size() - 1; i >= 0; i--) {
                    if (current.get(i).timestamp <= timestamp) {
                        return current.get(i).value;
                    }
                }
            }
            return "";
        }
    }
}
