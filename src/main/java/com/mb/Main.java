package com.mb;

import com.mb.exception.FailureException;
import com.mb.util.CalculatorUtil;
import com.mb.expression.MathExpressionFactory;
import com.mb.files.FileReader;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        prepareAndUseDataForCalculate();
    }

    private static void prepareAndUseDataForCalculate() {
        LinkedList<Pair<String, Integer>> expressionsFromFile = (LinkedList<Pair<String, Integer>>) FileReader.getOperatorsWithValuesFromFile();

        System.out.println("Input from file:");
        expressionsFromFile.forEach(expressionFromFile -> System.out.println(expressionFromFile.toString()));

        Integer applyValue = Optional.ofNullable(expressionsFromFile.getLast().getElement0().equals("apply") ?
                        expressionsFromFile.getLast().getElement1() : null)
                .orElseThrow(() -> { throw new FailureException("apply expression not found in file, can't go further!"); });

        expressionsFromFile.pollLast();

        MathExpressionFactory mathExpressionFactory = new MathExpressionFactory(new StringBuilder());
        String expression = mathExpressionFactory.getExpression(expressionsFromFile, applyValue);
        BigDecimal result = CalculatorUtil.evalIgnoreMathPrec(expression);

        System.out.println("Output: " + result);
        System.out.println("Explanation: " + expression + " = " + result);

    }
}