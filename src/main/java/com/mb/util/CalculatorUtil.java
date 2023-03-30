package com.mb.util;

import com.mb.OperatorsEnum;
import com.mb.calculator.CalculatorFactory;
import com.mb.exception.FailureException;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class CalculatorUtil {

    public static BigDecimal evalIgnoreMathPrec(final String mathExpression) {
        List<String> expressionList = splitExpression(mathExpression);
        BigDecimal val = calculate(expressionList.get(0), expressionList.get(1), expressionList.get(2));

        for (int i = 3; i < expressionList.size(); i += 2)
            val = calculate(val.toString(), expressionList.get(i), expressionList.get(i + 1));

        return val;
    }

    private static List<String> splitExpression(final String mathExpression) {
        return Arrays.stream(mathExpression.replaceAll("\\s", "")
                        .split("((?=\\+|-|\\*|/)|(?<=\\+|-|\\*|/))"))
                .collect(Collectors.toList());
    }

    public static BigDecimal calculate(String num1, String operator, String num2) throws FailureException {
        if (StringUtils.isBlank(num1) || StringUtils.isBlank(num2) || StringUtils.isBlank(operator))
            throw new FailureException("Blank parameter provided!");

        operator = operator.trim();

        if (!OperatorsEnum.getOperatorsSet().contains(operator))
            throw new FailureException("Operator not found!");

        try {
            return CalculatorFactory.getInstance(operator)
                    .calculate(new BigDecimal(num1.trim()), new BigDecimal(num2.trim()));
        } catch (NumberFormatException e) {
            throw new FailureException("Parsed number is not a BigDecimal value!");
        }
    }
}
