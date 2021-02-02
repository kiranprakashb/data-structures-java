package com.kiran.ds.logical;

public class Triangle {

    public static void main(String[] args) {
        int size = 5;
        // loop through the size
        for(int row = 1; row <= size; row++) {
            // reverse loop size against row to print spaces
            for(int space = size; space > row; space--) {
                System.out.print(" ");
            }
            // Consider no of stars at the base of the triangle.
            // Its always (2*row - 1).
            for(int star = 1; star <= (2*row - 1); star++) {
                // Print a star at the start, at the end and at the base of the triangle
                if(star == 1 || star == (2*row - 1) || row == size) {
                    System.out.print("*");
                }
                // Print space in the center of the triangle
                else {
                    System.out.print(" ");
                }
            }
            // Carriage return to the next row
            System.out.println("");
        }
    }
}
