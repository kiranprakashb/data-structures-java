package com.kiran.ds.arrays;

public class NumberOfIslands {

    public static void main (String[] args) {
        char[][] grid = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println (numIslands (grid));
    }

    /**
     * Solved using DFS
     */
    public static int numIslands(char[][] grid) {
        int islands = 0;
        for(int i=0; i<grid.length; i++) {
            // For every cell:
            //  1. Check if the value is 1
            //  2. If yes then visitLand surrounding the cell
            for(int j=0; j<grid[i].length; j++) {
                // New island found.  Islands visited during previous iterations are marked as 2, i.e, visited
                if(grid[i][j] == '1') {
                    visitLand (i, j, grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void visitLand (int i, int j, char[][] grid) {
        // For every land visited:
        // 1. If the value is 1 mark the land as visited (change value to 2)
        // 2. Visit land surrounding the current cell recursively until the boundaries are found
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length) {
            return;
        }
        if(grid[i][j] == '1') {
            // Mark the land visited as 2
            grid[i][j] = '2';

            visitLand (i-1, j, grid);  // TOP
            visitLand (i+1, j, grid);  // DOWN
            visitLand (i, j-1, grid);  // LEFT
            visitLand (i, j+1, grid);  // RIGHT
        }
    }
}
