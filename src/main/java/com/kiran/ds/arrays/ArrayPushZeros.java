package com.kiran.ds.arrays;

public class ArrayPushZeros {

    public static void main(String[] args) {
        ArrayPushZeros arrayPushZeros = new ArrayPushZeros();
        int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
        System.out.print("Before: ");
        printArray(arr);
        arrayPushZeros.pushZerosToEnd(arr);
        System.out.print("After: ");
        printArray(arr);
    }

    private void pushZerosToEnd(int[] arr) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }
        for(int i=count; count<arr.length; count++) {
            arr[count] = 0;
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
