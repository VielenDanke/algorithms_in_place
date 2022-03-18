package javasolutions.array.medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

    public static int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> store = new HashMap<>();
        store.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (store.containsKey(sum - k)) {
                result += store.get(sum - k);
            }
            if (store.containsKey(sum)) {
                store.put(sum, store.get(sum) + 1);
            } else {
                store.put(sum, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
