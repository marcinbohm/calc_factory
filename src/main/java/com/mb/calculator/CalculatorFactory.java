package com.mb.calculator;

import com.mb.OperatorsEnum;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.BiFunction;

public class CalculatorFactory {

    public static BiFunction<BigDecimal, BigDecimal, Calculator> getOperation(String operator) throws IllegalArgumentException {
         OperatorsEnum operatorsEnum = OperatorsEnum.fromOperator(operator)
                .orElseThrow(() -> new IllegalArgumentException("Invalid operator: " + operator));
         return operatorsEnum.getOperation();
    }
}
