package com.kiran.ds.hackerrank;

public class JumpingClouds {

    static int jumpingOnClouds(int[] c) {
        int n = c.length;
        int jumps = 0;
        for(int i=0; i<n; i++) {
            if(i<n-2 && c[i+2] == 0) {
                jumps++;
                i++;
            } else if(i<n-1 && c[i+1] == 0) {
                jumps++;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] c = new int[]{0,0,0,1,0,0};
        int jumps = jumpingOnClouds(c);
        System.out.println("Jumps: " + jumps);
    }
}
