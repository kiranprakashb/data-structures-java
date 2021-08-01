package com.kiran.ds.hackerrank;

public class CountAInRepeatingString {

    static long repeatedString(String s, long n) {
        char[] sarr = s.toCharArray();
        long count = 0;
        long reps = n/sarr.length;
        long left = n - sarr.length * reps;
        for(int i=0; i<sarr.length; i++) {
            if(sarr[i] == 'a') {
                count++;
            }
        }
        count*=reps;
        for(int j=0; j<left; j++) {
            if(sarr[j] == 'a') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abc";
        long count = repeatedString(s, 10);
        System.out.println(count);
    }
}
