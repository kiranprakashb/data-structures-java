package com.kiran.ds.arrays;

/**
 *
 Find the Rotation Count in Rotated Sorted array.
 Consider an array of distinct numbers sorted in increasing order.
 The array has been rotated (clockwise) k number of times.
 Given such an array, find the value of k.
 Examples:
 Input : arr[] = {15, 18, 2, 3, 6, 12}
 Output: 2
 Explanation : Initial array must be {2, 3,
 6, 12, 15, 18}. We get the given array after
 rotating the initial array twice.

 Input : arr[] = {7, 9, 11, 12, 5}
 Output: 4

 Input: arr[] = {7, 9, 11, 12, 15};
 Output: 0

 Output : arr[] = {1, 2, 3, 6, 0, 0, 0};
 *
 */
public class RotationCount {

    public static void main(String[] args) {
        int[] a = {15, 18, 2, 3, 6, 12};
        System.out.println(rotationCount(a, 0, a.length - 1));
    }

    // Binary Search
    public static int rotationCount(int[] a, int lo, int hi) {
        if (lo > hi) return 0;
        if (lo == hi) return lo;
        int mid = lo + (hi - lo)/2;
        if (mid < hi && a[mid] > a[mid + 1]) return mid + 1;
        if (mid > lo && a[mid] < a[mid - 1]) return mid;
        if (a[mid] < a[hi]) return rotationCount(a, lo, mid -1);
        return rotationCount(a, mid + 1, hi);
    }
}
