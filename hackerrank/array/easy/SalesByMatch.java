package hackerrank.array.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SalesByMatch {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     *
     * https://www.hackerrank.com/challenges/sock-merchant/problem
     */

    public static int sockMerchant(int n, List<Integer> ar) {
    // Write your code here
        Map<Integer, Integer> colorCounter = new HashMap<>();
        
        for (Integer color : ar) {
            colorCounter.putIfAbsent(color, 0);
            colorCounter.put(color, colorCounter.get(color) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : colorCounter.entrySet()) {
            result += entry.getValue() % 2 == 0 ? entry.getValue() / 2 : (entry.getValue() - 1) / 2;
        }
        return result;
    }

}