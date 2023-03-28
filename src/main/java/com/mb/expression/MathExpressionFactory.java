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

    public String getExpression(Queue<Pair<String, Integer>> expressionElements, Integer applyValue) {

        applyValue = Optional.ofNullable(applyValue)
                .orElseThrow(() -> new FailureException("applyValue not provided"));

        expression.append(applyValue).append(" ");

        while (!expressionElements.isEmpty()) {
            try {
                Optional<Integer> operatorValue = Optional.ofNullable(expressionElements.element().getElement1());
                Optional<String> operatorName = Optional.ofNullable(expressionElements.element().getElement0());
                if (operatorValue.isPresent()
                        && operatorName.isPresent()) {
                    Optional<OperatorsEnum> optionalOperator =
                            OperatorsEnum.fromName(operatorName.get());
                    optionalOperator.ifPresent(operatorsEnum -> {
                        expression.append(operatorsEnum.getOperator())
                                .append(" ")
                                .append(operatorValue.get()).append(" ");
                    });
                }
                expressionElements.remove();
            } catch (NoSuchElementException e) {
                break;
            }
        }
        return this.expression.toString().trim();
    }
}
