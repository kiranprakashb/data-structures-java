package com.kiran.ds.hackerrank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class MathBasic {

    static int simpleArraySum(List<Integer> ar) {
        return ar.stream().mapToInt(Integer::intValue).sum();
    }

    static long aVeryBigSum(List<Long> ar) {
        return ar.stream().mapToLong(l -> l).sum();
    }

    /**
     * https://www.hackerrank.com/challenges/compare-the-triplets/problem
     */
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> scores = new ArrayList<>();
        scores.add(0);
        scores.add(0);
        for(int i=0; i<a.size(); i++) {
            if(a.get(i) > b.get(i)) {
                scores.set(0,scores.get(0) + 1);
            } else if(!scores.isEmpty() && a.get(i) < b.get(i)) {
                scores.set(1,scores.get(1) + 1);
            }
        }
        return scores;
    }

    /**
     * https://www.hackerrank.com/challenges/diagonal-difference/problem
     */
    static int diagonalDifference(List<List<Integer>> arr) {
        int leftDiagonalSum = 0;
        int rightDiagonalSum = 0;
        // i starts from the front, j starts from the back.  Both i and j have to move simultaneously hence both i&j are both used in the same loop
        for(int i=0, j=arr.size()-1; i<arr.size(); i++, j--) {
            leftDiagonalSum += arr.get(i).get(i);
            rightDiagonalSum += arr.get(i).get(j);
        }
        return Math.abs(leftDiagonalSum-rightDiagonalSum);
    }

    /**
     * https://www.hackerrank.com/challenges/plus-minus/problem
     */
    static void plusMinus(List<Integer> arr) {
        double size = arr.size();
        double positive = 0;
        double negative = 0;
        double zero = 0;
        for(int i : arr) {
            if(i > 0) {
                positive++;
            } else if(i < 0) {
                negative++;
            } else {
                zero++;
            }
        }
        System.out.println(BigDecimal.valueOf(positive/size).setScale(6, RoundingMode.HALF_UP));
        System.out.println(BigDecimal.valueOf(negative/size).setScale(6, RoundingMode.HALF_UP));
        System.out.println(BigDecimal.valueOf(zero/size).setScale(6, RoundingMode.HALF_UP));
    }

    static void plusMinusLambda(List<Integer> arr) {
        Map<Integer, Long> count = arr.stream().collect(Collectors.groupingBy(i -> i.compareTo(0), Collectors.counting()));
        BigDecimal positive = count.get(1) == null ? BigDecimal.ZERO.setScale(6) : BigDecimal.valueOf(count.get(1).doubleValue()).divide(BigDecimal.valueOf(arr.size()), 6, RoundingMode.HALF_UP);
        BigDecimal negative = count.get(-1) == null ? BigDecimal.ZERO.setScale(6) : BigDecimal.valueOf(count.get(-1).doubleValue()).divide(BigDecimal.valueOf(arr.size()), 6, RoundingMode.HALF_UP);
        BigDecimal zero = count.get(0) == null ? BigDecimal.ZERO.setScale(6) : BigDecimal.valueOf(count.get(0).doubleValue()).divide(BigDecimal.valueOf(arr.size()), 6, RoundingMode.HALF_UP);
        System.out.println(positive);
        System.out.println(negative);
        System.out.println(zero);
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = Arrays.asList(Arrays.asList(11, 2, 4), Arrays.asList(4, 5, 6), Arrays.asList(10, 8, -12));
        int diff = diagonalDifference(arr);
        System.out.println(diff);
        plusMinus(Arrays.asList(-4, 3, -9, 0, 4, 1));
    }
}
