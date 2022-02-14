package com.epam.ld.javabasics2_1.filemath;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation {

    private final static Pattern pattern = Pattern.compile("^\\s*([^\\s]+)\\s+([^\\s]+)\\s+([^\\s])\\s*$");

    private Double operand1;
    private String stringOperand1;
    private Double operand2;
    private String stringOperand2;
    private String operator;

    public Operation(Double operand1, Double operand2, String operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.stringOperand1 = operand1.toString();
        this.stringOperand2 = operand2.toString();
        this.operator = operator;
    }

    private Operation() {

    }

    public static Operation parse(String s) throws InvalidFormatException {
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            Operation operation = new Operation();
            operation.stringOperand1 = matcher.group(1);
            operation.stringOperand2 = matcher.group(2);
            operation.operator = matcher.group(3);
            operation.operand1 = Double.parseDouble(operation.stringOperand1);
            operation.operand2 = Double.parseDouble(operation.stringOperand2);
            return operation;
        } else {
            throw new InvalidFormatException();
        }
    }

    public Double getOperand1() {
        return operand1;
    }

    public String getStringOperand1() {
        return stringOperand1;
    }

    public Double getOperand2() {
        return operand2;
    }

    public String getStringOperand2() {
        return stringOperand2;
    }

    public String getOperator() {
        return operator;
    }

    public String getResult() {
        try {
            Double result = Operator.get(operator).apply(operand1, operand2).doubleValue();
            return String.format("%s %s %s = %s", stringOperand1, operator, stringOperand2, result);
        } catch (NoSuchOperatorException nsoe) {
            nsoe.printStackTrace();
            return String.format("Undefined operator: %s", operator);
        }
    }

}
