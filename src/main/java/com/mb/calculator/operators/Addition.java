package com.mb.calculator.operators;

import com.mb.calculator.Calculator;
import com.mb.util.NumericUtil;

import java.math.BigDecimal;

public class Addition extends Calculator {

    public Addition(BigDecimal num1, BigDecimal num2) {
        super(num1, num2);
    }

    @Override
    public BigDecimal calculate() {
        return getNum1().add(getNum2());
    }
}
