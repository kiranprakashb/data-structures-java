package com.kiran.ds.hackerrank;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class ArrayManipulation {

    static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] arr = new long[n];
        // Not adding the number to all the elements.  Instead adding it to the first index and -ve number to lastIndex+1.
        for(List<Integer> query : queries) {
            arr[query.get(0)-1] += query.get(2);
            arr[query.get(1)] -= query.get(2);
        }
        long max = 0;
        long sum = 0;
        // Now add all elements in the array keeping a tab on the max sum reached.
        for(long ele : arr) {
            sum += ele;
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 10;
        List<List<Integer>> queries = Arrays.asList(Arrays.asList(1,5,3), Arrays.asList(4,8,7), Arrays.asList(6,9,1));
        long max = arrayManipulation(n, queries);
        System.out.println(max);
    }
}
