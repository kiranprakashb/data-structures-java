package com.kiran.ds.arrays;

public class ReverseWords {

    String reverseWords(String s) {
        // code here
        String[] words = s.split("\\.");
        StringBuilder rev = new StringBuilder();
        for(int i=words.length-1; i>=0; i--) {
            rev.append(words[i]);
            if(i != 0) {
                rev.append(".");
            }
        }
        return rev.toString();
    }

    public static void main(String[] args) {
        String reverseWords = new ReverseWords().reverseWords("i.like.this.program.very.much");
        System.out.println(reverseWords);
    }
}
