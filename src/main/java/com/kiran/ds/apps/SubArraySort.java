package com.kiran.ds.apps;

public class SubArraySort {

    public static void main(String[] args) {
        int arr [] = {13,7,6,21,9,100, 45, 34};
        int temp;

//        for (int i=1; i <= 5; i++) {
            for (int j = 1;  j <=4; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
//        }
//        Arrays.sort(arr, 1, 5);

        for (int i=0; i< arr.length; i++) {
            System.out.print(arr[i] + ",");
        }

    }


}
