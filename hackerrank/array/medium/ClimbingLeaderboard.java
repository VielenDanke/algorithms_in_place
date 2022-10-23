package hackerrank.array.medium;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbingLeaderboard {

    // https://www.hackerrank.com/challenges/climbing-the-leaderboard

    static class Solution {
        public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> players) {
            LinkedList<Integer> queue = new LinkedList<>();
            int rank = 1;
            int rankScore = ranked.get(0);

            for (int player = players.size() - 1, s = 0; player >= 0; player--) {
                if (players.get(player) < rankScore) {
                    while (s++ < ranked.size()) {
                        if (ranked.get(s) < rankScore) {
                            rank++;
                            rankScore = ranked.get(s);
                        }
                        if(players.get(player) >= ranked.get(s)) break;
                    }
                }
                queue.add(s == ranked.size() ? rank + 1 : rank);
            }
            List<Integer> result = new ArrayList<>();
            while (!queue.isEmpty()) {
                result.add(queue.pollLast());
            }
            return result;
        }
    }

    static class SolutionTreeSetShorter {
        public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> players) {
            TreeSet<Integer> ranks = new TreeSet<>((i, j) -> j - i);

            ranks.addAll(ranked);

            List<Integer> places = new LinkedList<>();
            for (Integer player : players) {
                ranks.add(player);
                places.add(ranks.headSet(player).size() + 1);
            }
            return places;
        }
    }

    static class SolutionBruteForce {

        public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> players) {
            TreeSet<Integer> ranks = new TreeSet<>((i, j) -> j - i);

            ranks.addAll(ranked);

            List<Integer> places = new LinkedList<>();
            for (Integer player : players) {
                if (player < ranks.last()) {
                    places.add(ranks.size() + 1);
                } else if (player > ranks.first()) {
                    places.add(1);
                } else {
                    int place = 1;
                    for (Integer currentRank : ranks) {
                        if (currentRank <= player) {
                            places.add(place);
                            break;
                        }
                        place++;
                    }
                }
                ranks.add(player);
            }
            return places;
        }
    }
}
