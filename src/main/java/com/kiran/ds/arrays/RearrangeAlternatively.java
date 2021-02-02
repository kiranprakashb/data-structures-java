package com.kiran.ds.arrays;

import java.util.Arrays;

/**
 *
 Rearrange positive and negative numbers in O(n) time and O(1) extra space.
 An array contains both positive and negative numbers in random order.
 Rearrange the array elements so that positive and negative numbers are placed alternatively.
 Number of positive and negative numbers need not be equal.
 If there are more positive numbers they appear at the end of the array.
 If there are more negative numbers, they too appear in the end of the array.
 For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9],
 then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]
 *
 */
public class RearrangeAlternatively {

    public static void main(String[] args) {
        int[] a = {-1,2,-3,4,5,6,-7,8,9};
        System.out.println(Arrays.toString(rearrange(a, a.length-1)));
    }

    public static int[] rearrange(int[] a, int n) {
        a = partitionAtZero(a, 0, n-1);
        int neg = 0, pos = 0;
        // Get positive index
        while (a[pos] < 0) {
            pos++;
        }
        // Swap alternate -ve with next +ve
        while (pos < n && neg < pos && a[neg] < 0) {
            swap(a, neg, pos);
            pos++;
            neg = neg + 2;
        }
        return a;
    }

    public static int[] partitionAtZero(int[] a, int lo, int hi) {
        while(true) {
            while(a[lo] < 0) {lo++; if (lo>hi) break;}
            while(a[hi] > 0) {hi--; if (lo>hi) break;}
            if (lo>hi) break;
            swap(a, lo, hi);
        }
        return a;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
