package com.kiran.ds.logical;

public class Palindrome {

    public static void main(String[] args) {
        String value = "malayalam";
        boolean isPalindrome = new Palindrome().checkPalindrome(value);
        System.out.println(value + " is Palindrome: " + isPalindrome);
    }

    private boolean checkPalindrome(String value) {
        int length = value.length();
        String firstHalf;
        String secondHalf;
        // check if the length of the string is even
        if(length % 2 == 0) {
            // first half is a substring from the start of the string to the middle of the string, last index is exclusive
            firstHalf = value.substring(0, length/2);
            // second half is a substring from the middle of the string to the end, first index is inclusive
            secondHalf = value.substring(length/2);
            System.out.println(firstHalf);
            System.out.println(secondHalf);
        } else {
            // in case the length of the string is odd we should ignore the middle character
            // first half is a substring from start to the left of the middle character
            firstHalf = value.substring(0, (length-1)/2);
            // second half is a substring from the right of the middle character to the end
            secondHalf = value.substring(((length-1)/2) + 1);
            System.out.println("First half: " + firstHalf);
            System.out.println("Second half: " + secondHalf);
        }
        // reverse the second half of the string
        StringBuffer reverseSecondHalf = new StringBuffer();
        int index = secondHalf.length() - 1;
        while(index >= 0) {
            reverseSecondHalf.append(secondHalf.charAt(index));
            index--;
        }
        System.out.println("Reverse Second half: " + reverseSecondHalf);
        // now compare first half with the second half to find if its a palindrome
        return firstHalf.equals(reverseSecondHalf.toString());
    }
}
