package com.mb.calculator.operators;

import com.mb.calculator.Calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Division implements Calculator {

    @Override
    public BigDecimal calculate(BigDecimal num1, BigDecimal num2) {
        return num1.divide(num2, RoundingMode.CEILING);
    }
}
