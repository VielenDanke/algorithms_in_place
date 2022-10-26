package hackerrank.array.easy;

import java.util.Arrays;
import java.util.List;

public class TheHurdleRace {

    // https://www.hackerrank.com/challenges/the-hurdle-race

    public static int hurdleRace(int k, List<Integer> heights) {
        // Write your code here
        /*
        height[i] + k > height[i + 1];
        doses = height[i] + k + n where n is the number to overcome height[i + 1]
        means height[i] + k + n > height[i + 1]
        Arrays.stream(height).filter(h -> h > k).map(h->h-k).max().orElse(0);
        */
        int doses = 0;
        for (Integer height : heights) {
            if (height > k) {
                doses = Math.max(doses, height - k);
            }
        }
        return doses;
    }
}
