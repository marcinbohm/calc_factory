package com.mb.util;

import com.mb.OperatorsEnum;
import com.mb.calculator.CalculatorFactory;
import com.mb.exception.FailureException;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;

public class CalculatorUtil {

    public static BigDecimal evalIgnoreMathPrec(final String mathExpression) {

        List<String> expressionList =
                new ArrayList<>(Arrays.asList(mathExpression.replaceAll("\\s", "").split("((?=\\+|-|\\*|/)|(?<=\\+|-|\\*|/))")));
        int idx = 0;
        BigDecimal val = calculate(expressionList.get(idx), expressionList.get(idx + 1), expressionList.get(idx + 2));
        idx += 2;
        while (expressionList.size() - 1 > idx) {
            val = calculate(val.toString(), expressionList.get(idx + 1), expressionList.get(idx + 2));
            idx += 2;
        }
        return val;
    }

    public static BigDecimal calculate(String num1, String operator, String num2) {
        try {
            if (StringUtils.isNotBlank(num1)
                    && StringUtils.isNotBlank(num2)
                    && StringUtils.isNotBlank(operator)
                    && OperatorsEnum.getOperatorsSet().contains(operator)) {
                num1 = num1.trim();
                num2 = num2.trim();
                operator = operator.trim();
                return CalculatorFactory
                        .getInstance(operator)
                        .calculate(new BigDecimal(num1), new BigDecimal(num2));
            } else
                throw new FailureException("Operator not found or parameter is blank!");
        } catch (NumberFormatException e) {
            throw new FailureException("Parsed number is not BigDecimal value!");
        } catch (NullPointerException e) {
            throw new NullPointerException("No parameter parsed to calculate function, can't do further calculations!");
        }
    }
}
