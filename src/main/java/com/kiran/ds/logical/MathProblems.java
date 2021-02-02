package com.kiran.ds.logical;

public class MathProblems {

    private void printFibonacciByCount(int count) {
        // holds value of previous number
        int prev = 0;
        // holds value of current number
        int current = 1;
        // count is the count of fibonacci numbers to print
        for(int i = 1; i <= count; i++) {
            // current holds the fibonacci number
            System.out.println(current);
            // add previous and current numbers to generate fibonacci
            int sum = prev + current;
            // move the prev pointer to current pointer
            prev = current;
            // move current pointer to the sum
            current = sum;
        }
    }

    private void printFibonacciByValue(int value) {
        int prev = 0;
        int current = 1;
        for(int i = 1; i <= value; i++) {
            // if the calculated fibonacci is greater than the value then stop printing
            if(current <= value) {
                System.out.println(current);
                int sum = prev + current;
                prev = current;
                current = sum;
            }
        }
    }

    private void printPrimeNumbers(int num) {
        // start from 2 as 0 and 1 are not factorial
        for(int i = 2; i <= num; i++) {
            // flag which identifies a number as non-prime
            boolean notPrime = false;
            // divide i with every number lesser than itself (j) and check the remainder
            for(int j = i-1; j > 1; j--) {
                // if remainder is 0 then the number is not prime
                if(i % j == 0) {
                    notPrime = true;
                    // if a number is not prime then break the loop
                    break;
                }
            }
            // if a number is prime then print the number
            if(!notPrime) {
                System.out.println(i);
            }
        }
    }

    private int getFactorialByLooping(int num) {
        int factorial = 1;
        for(int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private int getFactorialByRecursion(int num){
        int factorial = 1;
        if(num == 1) {
            return factorial;
        }
        factorial = getFactorialByRecursion(num-1) * num;
        return factorial;
    }

    public static void main(String[] args) {
        int num = 4;
        int factorial = new MathProblems().getFactorialByRecursion(num);
        System.out.println(factorial);
    }
}
