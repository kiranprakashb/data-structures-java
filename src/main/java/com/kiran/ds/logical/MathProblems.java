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

    private static int countFibonacciByRecursion(int num) {
        if(num == 0) {
            return 0;
        }
        if(num == 1) {
            return 1;
        }
        return countFibonacciByRecursion(num-1) + countFibonacciByRecursion(num-2);
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

    private static int lcm(int n1, int n2) {
        int max = n1>n2 ? n1 : n2;
        while(true) {
            if(max%n1 == 0 && max%n2 == 0) {
                return max;
            } else {
                max++;
            }
        }
    }

    private static void findNumberInMatrix(int m[][], int x) {
        int i=0; int j=m.length-1;
        while(i<m.length && j>0) {
            if(m[i][j] == x) {
                System.out.println(x + " found at: (" + i + "," + j + ")");
                return;
            } else if(m[i][j] > x) {
                j--;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = {{10,20,30,40},
                {15,25,35,45},
                {17,29,37,48},
                {32,33,39,50}};
        findNumberInMatrix(m, 29);
    }
}
