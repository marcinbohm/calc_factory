package com.mb.calculator.operators;

import com.mb.calculator.Calculator;

import java.math.BigDecimal;

public class Difference extends Calculator {

    public Difference(BigDecimal num1, BigDecimal num2) {
        super(num1, num2);
    }

    @Override
    public BigDecimal calculate() {
        return getNum1().subtract(getNum2());
    }
}
