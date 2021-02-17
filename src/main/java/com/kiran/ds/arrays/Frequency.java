package com.kiran.ds.arrays;

public class Frequency{

    public static void frequencyCount(int arr[], int n)
    {
        // code here
        for(int i=0; i<n; i++) {
            arr[i] = arr[i] - 1;
        }
        for(int i=0; i<n; i++) {
            arr[arr[i]%n] = arr[arr[i]%n] + n;
        }
         for(int i=0; i<n; i++) {
             arr[i] = arr[i]/n;
         }
    }

    public static void main(String[] args) {
        frequencyCount(new int[]{2,3,2,3,5}, 5);
    }
}