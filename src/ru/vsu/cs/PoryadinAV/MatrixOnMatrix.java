package ru.vsu.cs.PoryadinAV;

import java.util.Arrays;

public class MatrixOnMatrix {

    public int[] overlayMatrixOnOtherMatrix(int[][] matrix1, int[][] matrix2) {
        int[] answer = {-1, -1};
        for (int y = 0; y < matrix1.length; y++) {
            for (int x = 0; x < matrix1[0].length; x++) {
                int[][] subMatrix = takeSquareFromMatrix(x, y, matrix1);

                if (bruteForceMatrices(subMatrix, matrix2)) {
                    answer[0] = x;
                    answer[1] = y;

                    return answer;
                }
            }
        }

        return answer;
    }

    private boolean bruteForceMatrices(int[][] matrix1, int[][] matrix2) {
        for (int i = 0; i < matrix1.length; i++) {
            int[][] subMatrix = new int[i + 1][matrix1[0].length - 1];
            System.arraycopy(matrix1, 0, subMatrix, 0, i + 1);

            if (Arrays.equals(matrixToRegularArray(subMatrix), matrixToRegularArray(matrix2))) {
                return true;
            }
        }

        return false;
    }

    private int[][] takeSquareFromMatrix(int x, int y, int[][] matrix) {
        int[][] squareFromMatrix = new int[matrix.length - y][matrix[0].length - x];

        for (int row = y; row < matrix.length; row++) {
            squareFromMatrix[row - y] = takeSubSequenceFromArray(x, matrix[0].length - 1, matrix[row]);
        }

        return squareFromMatrix;
    }

    private int[] takeSubSequenceFromArray(int start, int end, int[] array) {
        int length = end - start + 1;
        int[] subSequence = new int[length];

        System.arraycopy(array, start, subSequence, 0, length);

        return subSequence;
    }

    private int[] matrixToRegularArray(int[][] matrix) {
        int lengthOfRegArr = matrix.length * matrix[0].length;
        int[] regularArray = new int[lengthOfRegArr];

        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, regularArray, i * matrix[i].length, matrix[i].length);
        }

        return regularArray;
    }
}
