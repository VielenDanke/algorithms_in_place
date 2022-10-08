package leetcode.array.medium.java_solutions;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinRewards_Algo {

    public static int minRewardsSol2(int[] scores) {
        int N = scores.length;
        int[] rewards = new int[N];
        Arrays.fill(rewards, 1);
        for (int i = 1; i < N; i++) {
            int j = i - 1;
            if (scores[i] > scores[j]) {
                rewards[i] = rewards[j] + 1;
            } else {
                while (j >= 0 && scores[j] > scores[j + 1]) {
                    rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
                    j--;
                }
            }
        }
        return IntStream.of(rewards).sum();
    }

    // -----------------------------------------------------------------------------------------------

    public static int minRewards(int[] scores) {
        // Write your code here.
        if (scores.length == 1) {
            return 1;
        }
        int N = scores.length;
        int[] rewards = new int[N];
        Arrays.fill(rewards, -1);
        for (int i = 0; i < N; i++) {
            if (isBetweenBigger(scores, i) && rewards[i] == -1) {
                rewards[i] = 1;
                int j = i;
                while (j > 0 && scores[j] < scores[j - 1]) {
                    rewards[j - 1] = Math.max(rewards[j] + 1, rewards[j - 1]);
                    j--;
                }
                j = i;
                while (j < N - 1 && scores[j] < scores[j + 1]) {
                    rewards[j + 1] = Math.max(rewards[j] + 1, rewards[j + 1]);
                    j++;
                }
            }
        }
        return IntStream.of(rewards).sum();
    }

    private static boolean isBetweenBigger(int[] scores, int idx) {
        if (idx == scores.length - 1) {
            return scores[idx] < scores[idx - 1];
        } else if (idx == 0) {
            return scores[idx] < scores[idx + 1];
        } else {
            return scores[idx] < scores[idx - 1] && scores[idx] < scores[idx + 1];
        }
    }
}
