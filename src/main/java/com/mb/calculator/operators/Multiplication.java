package com.mb.calculator.operators;

import com.mb.calculator.Calculator;

import java.math.BigDecimal;

public class Multiplication implements Calculator {

    @Override
    public BigDecimal calculate(BigDecimal num1, BigDecimal num2) {
        return num1.multiply(num2);
    }
}
