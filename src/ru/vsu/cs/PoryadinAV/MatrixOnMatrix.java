package ru.vsu.cs.PoryadinAV;

import java.util.Arrays;

public class MatrixOnMatrix {

    public int[] overlayMatrixOnOtherMatrix(int[][] matrix1, int[][] matrix2) {
        int[] answer = {-1, -1};
        int[] regularArray1 = matrixToRegularArray(matrix1);
        int[] regularArray2 = matrixToRegularArray(matrix2);

        for (int i = 0; i < regularArray1.length; i++) {
            if (regularArray1[i] == regularArray2[0]) {
                int[] coordinates = findCoordinatesOfValueInMatrix(i, matrix1);
                int[] tempArray = matrixToRegularArray(takeSquareFromMatrix(coordinates[0], coordinates[1], matrix1));
                int lenOfMatrix2 = matrix2.length * matrix2[0].length;
                if (Arrays.equals(takeSubSequenceFromArray(0, lenOfMatrix2 - 1, tempArray), regularArray2)) {
                    answer[0] = coordinates[0];
                    answer[1] = coordinates[1];
                    break;
                }
            }
        }

        return answer;
    }

    private int[] findCoordinatesOfValueInMatrix(int pos, int[][] matrix) {
        int y = pos / matrix[0].length;
        int x = pos - y * matrix[0].length;

        return new int[] {x, y};
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
