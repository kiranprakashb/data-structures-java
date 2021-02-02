package com.kiran.ds.logical;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    public static void main(String[] args) throws IOException {
        List<String> strings = Arrays.asList("room1", "foo", "room2", "room100", "room10");

        List<String> versions = Arrays.asList("V5", "V1", "V17", "V10", "V2");



        Collections.sort(versions, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return extractInt(o1) - extractInt(o2);
            }

            int extractInt(String s) {
                String num = s.replaceAll("\\D", "");
                // return 0 if no digits found
                return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
        });
        System.out.println(versions);
    }
}
