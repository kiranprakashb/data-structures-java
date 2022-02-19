package com.kiran.ds.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public static void main (String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println (partitionLabels (s));
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> partitionSize = new ArrayList<> ();
        char[] chars = s.toCharArray();
        // Build a Map containing the last index of each char
        Map<Character, Integer> map = buildLastIndexMap(chars);
        // Iterate through the chars and:
        // 1. Update lastIndex with the last index of the current char, if it is the largest value
        // 2. Once you reach the lastIndex you have created one partition
        // 3. Reset size and continue the process
        int lastIndex = 0;
        int size = 0;
        for(int i=0; i<chars.length; i++) {
            size++;
            if(map.get(chars[i]) > lastIndex) {
                lastIndex = map.get(chars[i]);
            }
            if(i == lastIndex) {
                partitionSize.add(size);
                size = 0;
            }
        }
        return partitionSize;
    }

    private static Map<Character, Integer> buildLastIndexMap(char[] chars) {
        Map<Character, Integer> map = new HashMap<> ();
        for(int i=0; i<chars.length; i++) {
            map.put(chars[i], i);
        }
        return map;
    }
}
