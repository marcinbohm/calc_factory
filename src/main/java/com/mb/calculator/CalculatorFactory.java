package com.mb.calculator;

import com.mb.OperatorsEnum;
import com.mb.calculator.operators.Addition;
import com.mb.calculator.operators.Difference;
import com.mb.calculator.operators.Division;
import com.mb.calculator.operators.Multiplication;

import java.util.Optional;

public class CalculatorFactory {

    public static Calculator getInstance(String operator) {
        Optional<OperatorsEnum> optionalOperator =
                OperatorsEnum.fromOperator(operator);
        if (optionalOperator.isPresent())
            switch (optionalOperator.get()) {
                case ADD:
                    return new Addition();
                case SUBTRACT:
                    return new Difference();
                case DIVIDE:
                    return new Division();
                case MULTIPLY:
                    return new Multiplication();
            }
        throw new NullPointerException("Method not found");
    }
}
