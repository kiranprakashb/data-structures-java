package com.kiran.ds.hackerrank;

public class ValleyCount {

    static int countTheValleys(String path) {
        char[] pathArr = path.toCharArray();
        int valleyCount = 0;
        int seaLevel = 0;
        for(int i=0; i<pathArr.length; i++) {
            if(pathArr[i] == 'U') {
                seaLevel++;
                if(seaLevel == 0) {
                   valleyCount++;
                }
            } else {
                seaLevel--;
            }
        }
        return valleyCount;
    }

    public static void main(String[] args) {
        String path = "UUDDDDUUDDUU";
        int valleyCount = countTheValleys(path);
        System.out.println("No of Valleys: " + valleyCount);
    }
}
