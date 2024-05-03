package org.example.practice;


public class MatrixDiagonalSwitch {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3,43},
                {4, 5, 6,6},
                {7, 8, 9,41},
                {77, 55, 99,2}
        };

        switchDiagonal(matrix);


        System.out.println("Matrix after switch");
        printMatrix(matrix);
    }

    public static void switchDiagonal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int minDim = Math.min(rows, cols);
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(minDim);

        for (int i = 0; i < minDim; i++) {
            int temp = matrix[i][i];
            matrix[i][i] = matrix[minDim - 1 - i][i];
            matrix[minDim - 1 - i][i] = temp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
