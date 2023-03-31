package com.mb.service;

import com.mb.Pair;
import com.mb.exception.FailureException;
import com.mb.expression.MathExpressionFactory;
import com.mb.files.FileReader;
import com.mb.util.CalculatorUtil;

import java.math.BigDecimal;
import java.util.LinkedList;

public class CalculationService {

    public static void calculateExpressionsFromFile() {
        LinkedList<Pair<String, Integer>> expressionsFromFile = (LinkedList<Pair<String, Integer>>) FileReader.getOperatorsWithValuesFromFile();

        System.out.println("Input from file:");
        expressionsFromFile.forEach(System.out::println);

        Integer applyValue = expressionsFromFile.stream()
                .filter(expression -> expression.getElement0().equals("apply"))
                .findFirst()
                .map(Pair::getElement1)
                .orElseThrow(() -> new FailureException("apply expression not found in file, can't go further!"));

        expressionsFromFile.removeLast();

        String expression = MathExpressionFactory.getExpression(expressionsFromFile, applyValue);
        BigDecimal result = CalculatorUtil.evalIgnoreMathPrec(expression);

        System.out.println("Output: " + result);
        System.out.println("Explanation: " + expression + " = " + result);
    }
}