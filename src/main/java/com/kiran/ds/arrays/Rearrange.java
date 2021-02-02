package com.kiran.ds.arrays;

import java.util.Arrays;

/**
 *
 Rearrange an array such that arr[i] = i
 Given an array of elements of length N, ranging from 0 to N – 1.
 All elements may not be present in the array.
 If element is not present then there will be -1 present in the array.
 Rearrange the array such that A[i] = i and if i is not present, display -1 at that place.
 Examples:
 Input : arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1}
 Output : [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]

 Input : arr = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8,
 11, 10, 9, 5, 13, 16, 2, 14, 17, 4}
 Output : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
 11, 12, 13, 14, 15, 16, 17, 18, 19]
 *
 */
public class Rearrange {

    public static void main(String[] args) {
        int[] a = {-1,-1,6,1,9,3,2,-1,4,-1};
        System.out.println(Arrays.toString(rearrangeByAux(a, a.length)));
        int[] b = {-1,-1,6,1,9,3,2,-1,4,-1};
        System.out.println(Arrays.toString(rearrangeBySwap(b, b.length)));
    }

    public static int[] rearrangeByAux(int[] a, int n) {
        int[] aux = new int[n];
        for (int i = 0; i < n; i++) {
            if (a[i] != -1)
                aux[a[i]] = 1;
        }
        for (int i = 0; i < n; i++) {
            a[i] = aux[i] == 1 ? i : -1;
        }
        return a;
    }

    public static int[] rearrangeBySwap(int[] a, int n) {
        for (int i = 0; i < n;) {
            if (a[i] > 0 && a[i] != i) {
                swap(a, i, a[i]);
            } else {
                i++;
            }
        }
        return a;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}

