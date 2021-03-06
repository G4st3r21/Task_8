package ru.vsu.cs.PoryadinAV.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ArrayUtils {

    private static final Random RND = new Random();

    public static int[] readIntArrayFromFile(String fileName) {
        try {
            return toIntArray(readLinesFromFile(fileName)[0]);
        }
        catch(FileNotFoundException e) {
            return null;
        }
    }

    public static String[] readLinesFromFile(String fileName) throws FileNotFoundException {
        List<String> lines;
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
            lines = new ArrayList<>();
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
            // обязательно, чтобы закрыть открытый файл
        }
        return lines.toArray(new String[0]);
    }

    public static int[][][] read2Arrays2FromFile(String fileName) throws FileNotFoundException {
        int[][][] matrices = new int[2][][];
        List<String> lines1;
        List<String> lines2;

        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
            lines1 = new ArrayList<>();
            while (scanner.hasNext()) {
                String tempLine = scanner.nextLine();
                if (!Objects.equals(tempLine, "*")) {
                    lines1.add(tempLine);
                } else break;
            }

            lines2 = new ArrayList<>();
            while (scanner.hasNext()) {
                lines2.add(scanner.nextLine());
            }

            matrices[0] = toIntArray2(lines1.toArray(new String[0]));
            matrices[1] = toIntArray2(lines2.toArray(new String[0]));
        }

        return matrices;
    }

    public static int[][] toIntArray2(String[] lines) {
        int[][] arr2 = new int[lines.length][];
        for (int r = 0; r < lines.length; r++) {
            arr2[r] = toIntArray(lines[r]);
        }
        return arr2;
    }

    public static int[] toIntArray(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("(\\s|[,;])+");
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }

        Integer[] arr = list.toArray(new Integer[0]);
        return ArrayUtils.toPrimitive(arr);
    }

    public static int[] toPrimitive(Integer[] arr) {
        if (arr == null) {
            return null;
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static void writeArrayToFile(String fileName, int[] arr, String itemFormat)
            throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(toString(toObject(arr), itemFormat));
        }
    }

    public static void write2ArraysToFile(String fileName, int[][][] arr, String itemFormat)
            throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(toString(toObject(arr[0]), itemFormat));
            out.println("*");
            out.println(toString(toObject(arr[1]), itemFormat));
        }
    }

    public static String toString(Integer[] arr, String itemFormat) {
        if (arr == null) {
            return null;
        }
        if (itemFormat == null || itemFormat.length() == 0) {
            itemFormat = "%s";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(String.format(Locale.ROOT, itemFormat, arr[i]));
        }
        return sb.toString();
    }

    public static String toString(Integer[][] arr, String itemFormat) {
        if (arr == null) {
            return null;
        }
        if (itemFormat == null || itemFormat.length() == 0) {
            itemFormat = "%s";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(String.format(Locale.ROOT, itemFormat, arr[i][j]));
                if (j != arr[i].length - 1) {
                    sb.append(", ");
                }
            }
            if (i != arr.length - 1) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public static Integer[] toObject(int[] arr) {
        if (arr == null) {
            return null;
        }
        Integer[] result = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static Integer[][] toObject(int[][] arr) {
        if (arr == null) {
            return null;
        }
        Integer[][] result = new Integer[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            result[i] = toObject(arr[i]);
        }
        return result;
    }

    public static int[] createRandomIntArray(int length, int minValue, int maxValue) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++)
            arr[i] = minValue + RND.nextInt(maxValue - minValue);
        return arr;
    }

    public static int[] createRandomIntArray(int length, int maxValue) {
        return createRandomIntArray(length, 0, maxValue);
    }

    public static int[][] createRandomIntMatrix(int rowCount, int colCount, int minValue, int maxValue) {
        int[][] matrix = new int[rowCount][];
        for (int r = 0; r < rowCount; r++)
            matrix[r] = createRandomIntArray(colCount, minValue, maxValue);
        return matrix;
    }

    public static int[][] createRandomIntMatrix(int rowCount, int colCount, int maxValue) {
        return createRandomIntMatrix(rowCount, colCount, 0, maxValue);
    }

}
