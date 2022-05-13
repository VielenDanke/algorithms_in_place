package backtracking_recursion.java_solutions;

import java.util.*;

public class SubsetsWithDuplication_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(result, new LinkedList<>(), nums, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, LinkedList<Integer> temp, int[] nums, int start) {
        result.add(new LinkedList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(result, temp, nums, i + 1);
            temp.removeLast();
        }
    }

    // ---------------------------------------------------------------------------------------------------------

    public List<List<Integer>> subsetsWithDupWithSet(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> duplicates = new HashSet<>();

        result.add(new ArrayList<>());
        duplicates.add(new ArrayList<>());

        Arrays.sort(nums);

        for (int num : nums) {
            int length = result.size();

            for (int j = 0; j < length; j++) {
                List<Integer> l = new ArrayList<>(result.get(j));
                l.add(num);
                if (!duplicates.contains(l)) {
                    result.add(l);
                    duplicates.add(l);
                }
            }
        }
        return result;
    }

    // -------------------------------------------------------------------------------------------------------

    public List<List<Integer>> subsetsWithDupSet(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        backtrack(result, new LinkedList<>(), nums, 0);

        return new ArrayList<>(result);
    }

    private void backtrack(Set<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
