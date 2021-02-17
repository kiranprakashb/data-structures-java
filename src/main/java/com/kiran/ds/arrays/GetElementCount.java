package com.kiran.ds.arrays;

public class GetElementCount {

    public static void main(String[] args) {
        String str = "abcda";
        int[] hash = new int[200];
        for(int i=0; i<str.length(); i++) {
            hash[str.charAt(i)]++;
        }
        for(int i=0; i<hash.length; i++) {
            if(hash[i] != 0) {
                char c = (char) i;
                System.out.println(c + ": " + hash[c]);
            }
        }
    }
}
