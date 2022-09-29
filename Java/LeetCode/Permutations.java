package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtracking(nums, result, new LinkedList<>());
        return result;
    }

    public void backtracking(int[] nums, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new LinkedList<>(list));
            return;
        }

        for (int num : nums) {
            if (list.contains(num)) continue;

            list.add(num);
            backtracking(nums, result, list);
            list.remove(list.size() - 1);
        }
    }
}
