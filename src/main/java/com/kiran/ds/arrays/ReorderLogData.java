package com.kiran.ds.arrays;

import java.util.*;

public class ReorderLogData {

    public static void main (String[] args) {
        String[] input = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        System.out.println (Arrays.toString (reorderLogFiles (input)));
    }

    public static String[] reorderLogFiles(String[] logs) {
        List<String> digLogs = new ArrayList<>();
        List<String> letLogs = new ArrayList<>();
        for(String log : logs) {
            String logText = log.substring(log.indexOf(" ")+1);
            if(Character.isDigit(logText.charAt(0))) {
                digLogs.add(log);
            } else {
                letLogs.add(log);
            }
        }
        letLogs.sort((s1, s2)  -> {
            String text1 = s1.substring(s1.indexOf(" ")+1);
            String text2 = s2.substring(s2.indexOf(" ")+1);
            if(text1.equals(text2)) {
                return s1.compareTo(s2);
            } else {
                return text1.compareTo(text2);
            }
        });
        letLogs.addAll(digLogs);
        return letLogs.toArray(new String[0]);
    }

    public static String[] reorderLogFiles2(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            // If s1 is str, s2 is str, then text1.compareTo(text2)
            // If s1 is str, s2 is str, if text1.equals(text2), then id1.compareTo(id2)
            // If s1 is str, s2 is dig, return 0
            // If s1 is dig, s2 is str, return 1
            // If s1 is dig, s2 is dig, return 0

            String[] log1 = s1.split(" ", 2);
            String[] log2 = s2.split(" ", 2);

            if(Character.isDigit(log1[1].charAt(0)) && Character.isDigit(log2[1].charAt(0))) {
                return 0;
            } else if(Character.isDigit(log1[1].charAt(0))) {
                return 1;
            } else if(Character.isDigit(log2[1].charAt(0))) {
                return -1;
            } else if(log1[1].equals(log2[1])) {
                return log1[0].compareTo(log2[0]);
            } else {
                return log1[1].compareTo(log2[1]);
            }
        });

        return logs;
    }
}
