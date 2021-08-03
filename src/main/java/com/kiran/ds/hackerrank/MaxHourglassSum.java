package com.kiran.ds.hackerrank;

/**
 * https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class MaxHourglassSum {

    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length-2; i++) {
            for(int j=0; j<arr[i].length-2; j++) {
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2]
                        + arr[i+1][j+1]
                        + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,1,2,5},{2,5,1,3},{1,0,7,3},{4,1,1,0}};
        int maxSum = hourglassSum(arr);
        System.out.println(maxSum);
    }

}
