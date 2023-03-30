package com.mb.calculator;

import com.mb.OperatorsEnum;
import com.mb.calculator.operators.Addition;
import com.mb.calculator.operators.Difference;
import com.mb.calculator.operators.Division;
import com.mb.calculator.operators.Multiplication;

import java.util.Optional;

public class CalculatorFactory {

    public static Calculator getInstance(String operator) throws IllegalArgumentException {
        OperatorsEnum operatorEnum = OperatorsEnum.fromOperator(operator)
                .orElseThrow(() -> new IllegalArgumentException("Invalid operator: " + operator));

        switch (operatorEnum) {
            case ADD:
                return new Addition();
            case SUBTRACT:
                return new Difference();
            case DIVIDE:
                return new Division();
            case MULTIPLY:
                return new Multiplication();
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }
}
