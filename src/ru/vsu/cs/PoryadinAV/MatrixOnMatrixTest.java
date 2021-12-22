package ru.vsu.cs.PoryadinAV;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.vsu.cs.PoryadinAV.utils.ArrayUtils;

import java.io.FileNotFoundException;

public class MatrixOnMatrixTest {

    MatrixOnMatrix program = new MatrixOnMatrix();

    @Test
    public void testNormalCase() throws FileNotFoundException {
        int[][][] matrices = ArrayUtils.read2Arrays2FromFile("testSrc/testInput1.txt");

        int[] expectedResult = ArrayUtils.readIntArrayFromFile("testSrc/testOutput1.txt");
        int[] receivedResult = program.overlayMatrixOnOtherMatrix(matrices[0], matrices[1]);

        Assertions.assertArrayEquals(expectedResult, receivedResult);
    }

    @Test
    public void testCaseWithTwoPossibleAnswers() throws FileNotFoundException {
        int[][][] matrices = ArrayUtils.read2Arrays2FromFile("testSrc/testInput2.txt");

        int[] expectedResult = ArrayUtils.readIntArrayFromFile("testSrc/testOutput2.txt");
        int[] receivedResult = program.overlayMatrixOnOtherMatrix(matrices[0], matrices[1]);

        Assertions.assertArrayEquals(expectedResult, receivedResult);
    }

    @Test
    public void testCaseWithUnusualInput() throws FileNotFoundException {
        int[][][] matrices = ArrayUtils.read2Arrays2FromFile("testSrc/testInput3.txt");

        int[] expectedResult = ArrayUtils.readIntArrayFromFile("testSrc/testOutput3.txt");
        int[] receivedResult = program.overlayMatrixOnOtherMatrix(matrices[0], matrices[1]);

        Assertions.assertArrayEquals(expectedResult, receivedResult);
    }

    @Test
    public void testCaseWithUnusualInput2() throws FileNotFoundException {
        int[][][] matrices = ArrayUtils.read2Arrays2FromFile("testSrc/testInput4.txt");

        int[] expectedResult = ArrayUtils.readIntArrayFromFile("testSrc/testOutput4.txt");
        int[] receivedResult = program.overlayMatrixOnOtherMatrix(matrices[0], matrices[1]);

        Assertions.assertArrayEquals(expectedResult, receivedResult);
    }

    @Test
    public void testCaseWithBigInput() throws FileNotFoundException {
        int[][][] matrices = ArrayUtils.read2Arrays2FromFile("testSrc/testInput5.txt");

        int[] expectedResult = ArrayUtils.readIntArrayFromFile("testSrc/testOutput5.txt");
        int[] receivedResult = program.overlayMatrixOnOtherMatrix(matrices[0], matrices[1]);

        Assertions.assertArrayEquals(expectedResult, receivedResult);
    }
}