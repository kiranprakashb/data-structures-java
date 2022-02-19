package com.kiran.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main (String[] args) {
        int[] candidates = {2,3,6,7};
        List<List<Integer>> combinations = combinationSum (candidates, 7);
        System.out.println (combinations);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        dfs (0, new ArrayList<> (), 0, candidates, target);
        backtrack (0, new ArrayList<> (), candidates, target);
        return result;
    }

    private static void dfs(int i, List<Integer> current, int total, int[] candidates, int target) {
        if(i >= candidates.length || total > target) {
            return;
        } else if(total == target) {
            result.add(new ArrayList<> (current));
            return;
        } else {
            current.add(candidates[i]);
            total+=candidates[i];
            dfs(i, current, total, candidates, target);

            current.remove(current.size ()-1);
            total-=candidates[i];
            dfs(i+1, current, total, candidates, target);
        }
    }

    private static void backtrack (int i, List<Integer> current, int[] candidates, int target) {
        // If target > 0
        //  target = target - candidates[i]
        // if target = 0
        //  combo found
        // if target < 0
        //  wrong combo

        if(target < 0) {
            return;
        } else if(target == 0) {
            // When target==0 is iteratively found, it means the current list contains the right numbers with target to find as 0
            // For ex. 2+2+2=6, target: 7-6=1
            //         2+2+2+2=8, target: 7-8=-1
            //         2+2+3=7, target: 7-7=0, right combo
            result.add(new ArrayList<>(current));
            return;
        } else {
            for(int j=i; j<candidates.length; j++) {
                current.add(candidates[j]);
                // since the candidate is added to current list, the target will now be target-candidate[iter]
                backtrack (j, current, candidates, target - candidates[j]);
                // backtrack if target==0 not met
                current.remove(current.size()-1);
            }
        }
    }
}
