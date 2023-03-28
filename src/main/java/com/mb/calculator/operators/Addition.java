package com.mb.calculator.operators;

import com.mb.calculator.Calculator;
import com.mb.util.NumericUtil;

import java.math.BigDecimal;

public class Addition implements Calculator {

    @Override
    public BigDecimal calculate(BigDecimal num1, BigDecimal num2) {
        return num1.add(num2);
    }
}
