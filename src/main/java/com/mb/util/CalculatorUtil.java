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
        num1 = num1.trim();
        num2 = num2.trim();
        operator = operator.trim();
        if (StringUtils.isNotBlank(num1)
                && StringUtils.isNotBlank(num2)
                && StringUtils.isNotBlank(operator)
                && OperatorsEnum.getOperatorsSet().contains(operator)
                && NumericUtil.isNumeric(num1)
                && NumericUtil.isNumeric(num2))
            return CalculatorFactory
                    .getInstance(operator)
                    .calculate(new BigDecimal(num1), new BigDecimal(num2));
        else
            throw new FailureException("Operator not found or num parameter not numeric or parameter is blank!");
    }
}
