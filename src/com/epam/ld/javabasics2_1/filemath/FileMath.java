package com.epam.ld.javabasics2_1.filemath;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileMath {

    private static Pattern pattern = Pattern.compile("^\\s*([^\\s]+)\\s+([^\\s]+)\\s+([^\\s])\\s*$");

    public static void processFile(String fileName, String outputFileName) throws FileNotFoundException {
        try(BufferedReader fr = new BufferedReader(new FileReader(fileName)); PrintWriter pw = new PrintWriter(new FileWriter(outputFileName, false))) {
            String line = fr.readLine();
            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    try {
                        Double operand1 = Double.parseDouble(matcher.group(1));
                        Double operand2 = Double.parseDouble(matcher.group(2));
                        Double result = Operator.get(matcher.group(3)).apply(operand1, operand2).doubleValue();
                        pw.println(String.format("%s %s %s = %s", matcher.group(1), matcher.group(3), matcher.group(2), result));
                    } catch (NumberFormatException nfe) {
                        pw.println(String.format("Could not parse numbers: %s", line));
                        nfe.printStackTrace();
                    } catch (NoSuchOperatorException nsoe) {
                        pw.println(String.format("Undefined operator: %s", matcher.group(3)));
                        nsoe.printStackTrace();
                    }
                }
                line = fr.readLine();
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
