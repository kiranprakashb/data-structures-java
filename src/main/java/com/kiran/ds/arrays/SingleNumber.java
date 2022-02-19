package com.kiran.ds.arrays;

public class SingleNumber {

    public static void main (String[] args) {
        int[] nums = {2,2,1};
        System.out.println (singleNumber (nums));
    }

    public static int singleNumber(int[] nums) {
        int n = 0;
        for(int num : nums) {
            n ^= num;
        }
        return n;
    }
}
