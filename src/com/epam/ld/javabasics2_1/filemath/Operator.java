package com.epam.ld.javabasics2_1.filemath;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Operator {

    private final static Map<String, BiFunction<Number,Number,Number>> OPERATORS = new HashMap<>();

    public static BiFunction<Number,Number,Number> get(String operator) throws NoSuchOperatorException {
        BiFunction func = OPERATORS.get(operator);
        if (func == null) {
            throw new NoSuchOperatorException();
        }
        return func;
    }

    static {
        OPERATORS.put("+", (a, b) -> a.doubleValue() + b.doubleValue());
        OPERATORS.put("-", (a, b) -> a.doubleValue() - b.doubleValue());
        OPERATORS.put("*", (a, b) -> a.doubleValue() * b.doubleValue());
        OPERATORS.put("/", (a, b) -> a.doubleValue() / b.doubleValue());
    }
}
