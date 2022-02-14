package com.epam.ld.javabasics2_1.filemath;

import java.io.*;

public class FileMath {

    public static void processFile(String fileName, String outputFileName) throws FileNotFoundException {
        try {
            FileMathProcessor fileMathProcessor = new FileMathProcessor(outputFileName);
            fileMathProcessor.processFile(fileName);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
