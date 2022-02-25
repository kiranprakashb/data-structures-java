package com.kiran.ds.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringNonRepeatingChars {

    public static void main (String[] args) {
        System.out.println (lengthOfLongestSubstring ("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<> ();
        while(end < s.length()) {
            if(set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            } else {
                set.add(s.charAt(end));
                end++;
                maxLength = Math.max(maxLength, set.size());
            }
        }
        return maxLength;
    }
}
