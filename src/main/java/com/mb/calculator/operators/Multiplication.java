package com.mb.calculator.operators;

import com.mb.calculator.Calculator;

import java.math.BigDecimal;

public class Multiplication extends Calculator {

    public Multiplication(BigDecimal num1, BigDecimal num2) {
        super(num1, num2);
    }

    @Override
    public BigDecimal calculate() {
        return getNum1().multiply(getNum2());
    }
}
