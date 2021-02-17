package com.kiran.ds.arrays;

public class FindPairForSum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int sum = 10;
        int[] hash = new int[sum+1];
        for(int i=0; i<arr.length; i++) {
            int diff = sum - arr[i];
            if(hash[diff] != 0) {
                for(int count=0; count<hash[diff]; count++) {
                    System.out.println("(" + arr[i] + "," + diff + ")");
                }
                hash[diff]++;
            }
            if(hash[arr[i]] != 0) {
                hash[arr[i]]++;
            } else {
                hash[arr[i]] = 1;
            }
        }
    }
}
