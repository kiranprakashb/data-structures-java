package com.kiran.ds.hackerrank;

/**
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class MinimumSwaps {

    private static int minimumSwaps(int[] arr) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == i+1) {
                continue;
            }
            swap(arr, i, arr[i]-1);
            count++;
            // Stay at the pointer until you get the element you need at the pointer, i.e, a[i] == i+1
            i--;
        }
        return count;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int swaps = minimumSwaps(new int[]{7, 1, 3, 2, 4, 5, 6});
        System.out.println(swaps);
    }
}
