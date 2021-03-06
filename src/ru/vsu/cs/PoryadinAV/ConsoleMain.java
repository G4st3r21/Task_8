package ru.vsu.cs.PoryadinAV;

import ru.vsu.cs.PoryadinAV.utils.ArrayUtils;

import java.io.PrintStream;

public class ConsoleMain {

    public static class CmdParams {
        public String inputFile;
        public String outputFile;
        public boolean error;
        public boolean help;
        public boolean window;
    }

    public static void main(String[] args) throws Exception {
        MatrixOnMatrix program = new MatrixOnMatrix();
        CmdParams cmdParams = parseArgs(args);

        if (cmdParams.help) {
            printHelp(cmdParams);
        }

        if (cmdParams.window) {
            GuiMain.winMain();
        } else if (cmdParams.inputFile != null) {
            int[][][] matrices = ArrayUtils.read2Arrays2FromFile(cmdParams.inputFile);

            int[] answer = program.overlayMatrixOnOtherMatrix(matrices[0], matrices[1]);

            if (cmdParams.outputFile != null) {
                ArrayUtils.writeArrayToFile(cmdParams.outputFile, answer, null);
            } else {
                printAnswerArray(answer);
            }
        }

    }

    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();
        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }
            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }
            params.inputFile = args[0];
            if (args.length >= 2) {
                params.outputFile = args[1];
            }
        } else {
            params.help = true;
            params.error = true;
        }
        return params;
    }

    public static void printHelp(CmdParams params) {
        PrintStream out = params.error ? System.err : System.out;
        out.println("Usage:");
        out.println("  <cmd> args <input-file> (<output-file>)");
        out.println("  <cmd> --help");
        out.println("  <cmd> --window  // show window");
        System.exit(params.error ? 1 : 0);
    }

    public static void printAnswerArray(int[] answer) {
        System.out.println("Coordinates: " + answer[0] + ", " + answer[1]);
    }
}
