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

    /**
     * https://www.hackerrank.com/challenges/mini-max-sum/problem
     */
    static void miniMaxSum(List<Integer> arr) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(int i=0; i<arr.size(); i++) {
            long sum = 0L;
            for(int j=0; j<arr.size(); j++) {
                if(i != j) {
                    sum = sum + arr.get(j);
                }
            }
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        System.out.println(min + " " + max);
    }

    /**
     * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
     */
    static int birthdayCakeCandles(List<Integer> candles) {
        int max = 0;
        int maxCount = 0;
        for (Integer candle : candles) {
            if (max == candle) {
                maxCount++;
            } else if (max < candle) {
                max = candle;
                maxCount = 1;
            }
        }
        return maxCount;
    }

    /**
     * https://www.hackerrank.com/challenges/time-conversion/problem
     */
    static String timeConversion(String s) {
        String ampm = s.substring(s.length()-2);
        String time = s.substring(0, s.length()-2);
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        if(ampm.equals("AM") && hour == 12) {
            split[0] = "00";
        } else if(ampm.equals("PM") && hour != 12) {
            hour = (hour + 12) % 24;
            split[0] = String.valueOf(hour);
        }
        return String.format("%s:%s:%s", split);
    }

    public static void main(String[] args) {

        List<Integer> scores = compareTriplets(Arrays.asList(17, 28, 30), Arrays.asList(99, 16, 8));
        scores.forEach(score -> System.out.print(score + " "));
        System.out.println();

        List<List<Integer>> arr = Arrays.asList(Arrays.asList(11, 2, 4), Arrays.asList(4, 5, 6), Arrays.asList(10, 8, -12));
        int diff = diagonalDifference(arr);
        System.out.println(diff);

        plusMinus(Arrays.asList(-4, 3, -9, 0, 4, 1));

        miniMaxSum(Arrays.asList(1,2,3,4,5));

        System.out.println(birthdayCakeCandles(Arrays.asList(3,2,1,3)));

        String ampm = "07:05:45PM";
        System.out.println(timeConversion(ampm));
    }
}
