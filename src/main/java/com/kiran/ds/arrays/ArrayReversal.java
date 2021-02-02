package com.kiran.ds.arrays;

public class ArrayReversal {

    public static void main(String[] args) {
        ArrayReversal arrayReversal = new ArrayReversal();

        // Reverse by Iteration
        int arr1[] = {1, 2, 3};
        System.out.print("Before: ");
        printArray(arr1);
        arrayReversal.reverseIterative(arr1);
        System.out.print("After: ");
        printArray(arr1);

        // Reverse by Recursion
        int arr2[] = {4, 5, 1, 2};
        System.out.print("Before: ");
        printArray(arr2);
        arrayReversal.reverseRecursive(arr2, 0, arr2.length - 1);
        System.out.print("After: ");
        printArray(arr2);
    }

    private void reverseIterative(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }

    private void reverseRecursive(int[] arr, int start, int end) {
        if(start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
            reverseRecursive(arr, start++, end--);
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("{");
        for (int entry : arr) {
            System.out.print(entry);
            if(entry != arr[arr.length - 1]) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }
}
