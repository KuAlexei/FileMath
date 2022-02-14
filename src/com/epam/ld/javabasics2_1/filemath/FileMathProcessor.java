package com.epam.ld.javabasics2_1.filemath;

import java.io.*;

public class FileMathProcessor {

    private final PrintWriter pw;

    public FileMathProcessor(String out) throws IOException {
        this(out, false);
    }

    public FileMathProcessor(String out, Boolean append) throws IOException {
        this(new PrintWriter(new FileWriter(out, append)));
    }

    public FileMathProcessor(PrintWriter pw) {
        this.pw = pw;
    }

    public void processFile(String fileName) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        String line = fr.readLine();
        while (line != null) {
            Operation operation;
            try {
                operation = Operation.parse(line);
                pw.println(operation.getResult());
            } catch (NumberFormatException nfe) {
                pw.println(String.format("Could not parse numbers: %s", line));
                nfe.printStackTrace();
            } catch (InvalidFormatException ife) {
                pw.println(String.format("Wrong line format: %s", line));
                ife.printStackTrace();
            }
            line = fr.readLine();
        }
        fr.close();
        pw.flush();
    }
}
