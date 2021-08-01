package com.kiran.ds.hackerrank;

public class PairCount {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        // 1,1,1,3,1,2,2,2,5
        int count=0;
        if(n>0 && ar != null) {
            // size=101, because 1 <= ar[i] <= 100
            int[] hash = new int[101];
            for(int i=0; i<n; i++) {
                hash[ar[i]]++;
            }
            for(int j=0; j<hash.length; j++) {
                if(hash[j] > 1 && hash[j]%2 >= 0) {
                    count += hash[j]/2;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{1,1,1,2,1,2,2,3,5};
        int count = sockMerchant(9, ar);
        System.out.println("Pair Count: " + count);
    }
}
