package hackerrank.array.medium.java_solutions;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrganizingContainersOfBalls {

    // https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem

    static class Solution {
        public static String organizingContainers(List<List<Integer>> container) {
            Set<Integer> balls = container.stream()
                    .map(b -> b.stream().mapToInt(Integer::intValue).sum())
                    .collect(Collectors.toSet());
            Set<Integer> types = IntStream.range(0, container.size())
                    .mapToObj(t -> container.stream().mapToInt(b -> b.get(t)).sum())
                    .collect(Collectors.toSet());
            return balls.containsAll(types) ? "Possible" : "Impossible";
        }
    }
}
