package com.kiran.ds.hackerrank;

public class Staircase {

    static void staircase(int n) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(j >= (n-1) - i) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        staircase(6);
    }
}
