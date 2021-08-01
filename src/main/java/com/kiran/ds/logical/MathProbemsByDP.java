package com.kiran.ds.logical;

public class MathProbemsByDP {

    private int[] fib;

    public MathProbemsByDP(int n) {
        this.fib = new int[n];
    }

    public int countFibonacciBottomUp(int num) {
        if(num == 0 || num == 1) return 1;
        fib[0] = 1;
        fib[1] = 1;
        for(int i=2; i<num; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[num-1];
    }

    public int countFibonacciTopDown(int num) {
        if(num == 2 || num == 1) return 1;
        if(fib[num-1] != 0) {
            return fib[num-1];
        } else {
            fib[num-1] = countFibonacciTopDown(num-1) + countFibonacciTopDown(num-2);
            return fib[num-1];
        }
    }

    public static void main(String[] args) {
        System.out.println(new MathProbemsByDP(5).countFibonacciTopDown(5));
    }
}
