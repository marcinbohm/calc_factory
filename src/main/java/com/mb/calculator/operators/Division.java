package com.mb.calculator.operators;

import com.mb.calculator.Calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Division extends Calculator {

    public Division(BigDecimal num1, BigDecimal num2) {
        super(num1, num2);
    }

    @Override
    public BigDecimal calculate() {

        return getNum1().divide(getNum2(), RoundingMode.CEILING);
    }

    @Override
    public Calculator validated() {
        if (getNum2().equals(BigDecimal.ZERO)) {
            throw new ArithmeticException("Error: Division by zero is not allowed");
        }
        return super.validated();
    }
}
