package com.mb.expression;

import com.mb.OperatorsEnum;
import com.mb.Pair;
import com.mb.exception.FailureException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Queue;

public class MathExpressionFactory {

    private final StringBuilder expression;

    public MathExpressionFactory(StringBuilder expression) {
        this.expression = expression;
    }

    public static String getExpression(Queue<Pair<String, Integer>> expressionElements, Integer applyValue) throws FailureException {
        applyValue = Optional.ofNullable(applyValue).orElseThrow(() -> new FailureException("applyValue not provided"));

        StringBuilder expression = new StringBuilder();
        expression.append(applyValue).append(" ");

        for (Pair<String, Integer> expressionElement : expressionElements) {
            String operatorName = expressionElement.getElement0();
            Integer operatorValue = expressionElement.getElement1();
            if (operatorName != null && operatorValue != null) {
                OperatorsEnum operator = OperatorsEnum.fromName(operatorName)
                        .orElseThrow(() -> new FailureException("Invalid operator name: " + operatorName));
                expression.append(operator.getOperator()).append(" ").append(operatorValue).append(" ");
            }
        }

        return expression.toString().trim();
    }
}
