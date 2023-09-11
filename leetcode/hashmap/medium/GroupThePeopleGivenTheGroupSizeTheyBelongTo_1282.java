package leetcode.hashmap.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo_1282 {

    static class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            Map<Integer, List<Integer>> groups = new HashMap<>();
            List<List<Integer>> result = new ArrayList<>();
            for (int id = 0; id < groupSizes.length; id++) {
                int group = groupSizes[id];
                groups.putIfAbsent(group, new ArrayList<>());
                groups.get(group).add(id);
                if (groups.get(group).size() >= group) {
                    result.add(new ArrayList<>(groups.get(group)));
                    groups.put(group, new ArrayList<>());
                }
            }
            return result;
        }
    }

    static class SolutionArray {

        @SuppressWarnings({"unchecked", "rawtypes"})
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            List<List<Integer>> result = new ArrayList<>();
            ArrayList[] list = new ArrayList[500];
            for (int id = 0; id < groupSizes.length; id++) {
                int group = groupSizes[id];
                if (list[group] == null) {
                    list[group] = new ArrayList();
                }
                list[group].add(id);
                if (list[group].size() >= group) {
                    result.add(list[group]);
                    list[group] = new ArrayList();
                }
            }
            return result;
        }
    }
}
