package backtracking_recursion.java_solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class PermutationsWithDuplicates_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        backtrack(result, nums, 0);

        return result.stream().toList();
    }

    private void backtrack(Set<List<Integer>> result, int[] nums, int start) {
        if (start == nums.length) {
            result.add(IntStream.of(nums).boxed().toList());
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(start, i, nums);
            backtrack(result, nums, start + 1);
            swap(start, i, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // ---------------------------------------------------------------------------------

    public List<List<Integer>> permuteUniqueVisited(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        boolean[] visited = new boolean[nums.length];

        backtrack(result, new ArrayList<>(), nums, visited);

        return new ArrayList<>(result);
    }

    private void backtrack(Set<List<Integer>> result, List<Integer> current, int[] nums, boolean[] visited) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            current.add(nums[i]);
            backtrack(result, current, nums, visited);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}
