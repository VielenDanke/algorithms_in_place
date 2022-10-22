package hackerrank.array.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class ClimbingLeaderboard {

    // https://www.hackerrank.com/challenges/climbing-the-leaderboard

    static class Solution {

        // TODO: solve
        public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> players) {
            int amountOfRanked = 0;
            int[] ranks = new int[10000];

            for (Integer rank : ranked) {
                if (ranks[rank] == 0) {
                    ranks[rank]++;
                    amountOfRanked++;
                }
            }
            List<Integer> places = new LinkedList<>();
            for (Integer player : players) {
                int place;
                if (ranks[player] != 0) {
                    place = 0;
                } else {
                    ranks[player]++;
                    place = 0;
                }
                places.add(place);
            }
            return places;
        }
    }

    static class SolutionBruteForce {
        public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
            // Write your code here
            TreeSet<Integer> set = new TreeSet<>((i, j) -> j - i);

            set.addAll(ranked);

            List<Integer> places = new LinkedList<>();

            for (Integer currentScore : player) {
                List<Integer> list = new LinkedList<>();
                int size = set.size();

                while (!set.isEmpty() && set.first() > currentScore) {
                    list.add(set.pollFirst());
                }
                if (set.isEmpty()) {
                    places.add(size + 1);
                } else {
                    places.add(size - set.size() + 1);
                }
                list.add(currentScore);
                set.addAll(list);
            }
            return places;
        }

        public static void main(String[] args) {
            System.out.println(SolutionBruteForce.climbingLeaderboard(Arrays.asList(100, 100, 50, 40, 40, 20, 10), Arrays.asList(5, 25, 50, 120)));
        }
    }
}
