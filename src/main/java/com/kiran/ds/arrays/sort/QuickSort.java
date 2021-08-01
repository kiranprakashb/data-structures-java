package com.kiran.ds.arrays.sort;

public class QuickSort {

    private static void sort(int[] arr, int left, int right) {
        if(left>=right) {
            return;
        }
        int pivot = arr[(left+right)/2];
        int x = partition(arr, left, right, pivot);
        sort(arr, left, x-1);
        sort(arr, x, right);
    }

    private static int partition(int[] arr, int left, int right, int pivot) {
        while(left<=right) {
            while(arr[left]<pivot) {
                left++;
            }
            while(arr[right]>pivot) {
                right--;
            }
            if(left<=right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private static void printArr(int[] arr) {
        for(int a: arr) {
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {8,7,6,2,4,3,1};
        sort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
