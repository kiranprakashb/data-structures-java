package com.kiran.ds.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseArray {
    public static void main (String[] args) throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        reverseArray(t, br);
    }

    private static void reverseArray(int t, BufferedReader br) throws IOException {
        while(t>0) {
            int n = Integer.parseInt(br.readLine());
            String[] strArr = br.readLine().split(" ");
            int[] arr = new int[strArr.length];
            for(int i=0; i<strArr.length; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }
            int temp;
            for(int i=0; i<n/2; i++) {
                temp = arr[i];
                arr[i] = arr[n-1-i];
                arr[n-1-i] = temp;
            }
            for(int num : arr) {
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println();
            t--;
        }
    }
}
