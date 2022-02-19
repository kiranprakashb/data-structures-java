package com.kiran.ds.arrays;

import java.util.*;

public class TwoSum {

    public static void main (String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println (Arrays.toString (twoSum (nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        // the number, index
        // for a given number, find the reqd number and see if its found in the map, if yes then return
        // if reqd number not found, put given number in the map

        Map<Integer, Integer> map = new HashMap<> ();
        for(int i=0 ; i<nums.length; i++) {
            int other = target - nums[i];
            if(map.containsKey(other)) {
                return new int[]{i, map.get(other)};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
