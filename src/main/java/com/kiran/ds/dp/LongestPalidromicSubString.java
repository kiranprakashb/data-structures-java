package com.kiran.ds.dp;

public class LongestPalidromicSubString {

    public static void main (String[] args) {
        System.out.println (longestPalindrome ("babad"));
    }

    public static String longestPalindrome(String s) {
        int start=0, end=0;
        for(int i=0; i<s.length(); i++) {
            // Find both even and odd palindromes from every char to find the longest palindrome
            int even = expand(s, i, i);
            int odd = expand(s, i, i+1);
            int len = Math.max(even, odd);
            if(len > end-start) {
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }

    // Expand to either side with given char as the middle
    // For even length, middle has one char
    // For odd length, middle has two chars
    private static int expand(String s, int start, int end) {
        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    public static String longestPalindromeDP(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        int start = 0,end = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j >= 0; j--){
                //Checking whether the substring starting at index i and ending at index j is palindromic or not
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[i - 1][j + 1])){   //i-j <= 2 means strings of length <= 3 if string is of length 2 and s[i] == s[j] then it is palindrome and if string is of length 3 and if s[i] == s[j] and only the middle character will be left which is palindrome in itself.
                    dp[i][j] = true;
                }

                //Now we will calculate the length of the substring if the substring starting at i and ending at j is palindrome
                if(dp[i][j] && i - j > end - start){
                    end = i;
                    start = j;
                }
            }
        }
        return s.substring(start,end + 1);
    }

    public static String longestPalindromeBF(String s) {
        String result = s.length() == 0 ? "" : String.valueOf(s.charAt(0));
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int start=0; start<s.length(); start++) {
            for(int end=s.length()-1; end>start; end--) {
                if(isPalindrome(s, start, end) && (end-start+1) > result.length()) {
                    result = s.substring(start, end+1);
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while(end > start) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}
