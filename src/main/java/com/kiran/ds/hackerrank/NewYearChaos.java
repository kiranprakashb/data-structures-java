package com.kiran.ds.hackerrank;

/**
 * https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class NewYearChaos {

    private static void minimumBribes(int[] q) {
        int bribes = 0;
        for(int i=q.length-1; i>=0; i--) {
            if(q[i] != (i+1)) {
                if(q[i-1] == (i+1)) {
                    q[i-1] = q[i];
                    q[i] = i+1;
                    bribes++;
                } else if(q[i-2] == (i+1)) {
                    q[i-2] = q[i-1];
                    q[i-1] = q[i];
                    q[i] = i+1;
                    bribes += 2;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(bribes);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5,3,7,8,6,4};
        minimumBribes(arr);
    }
}
