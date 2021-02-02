package com.kiran.ds.arrays;

public class ArrayRotation {

    public static void main(String[] args) {
        ArrayRotation arrayRotation = new ArrayRotation();
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.print("Before: ");
        printArray(arr);
        arrayRotation.rotate(arr, 2);
        System.out.print("After: ");
        printArray(arr);
    }

    private void rotate(int[] arr, int d) {
        for(int i=0; i<d; i++) {
            int temp = arr[0];
            for(int j=0; j<arr.length-1; j++) {
                arr[j] = arr[j+1];
            }
            arr[arr.length-1] = temp;
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("{");
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
            if(i != arr.length-1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }
}
